package com.example.cinemaApp.Kafka;

import com.example.cinemaApp.DTO.BookingRequestDTO;
import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.ReservationConfirmationDTO;
import com.example.cinemaApp.Entity.*;
import com.example.cinemaApp.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SeatCategoryRepository seatCategoryRepository;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @KafkaListener(topics = "movie_json", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(CinemaUserDTO user) {
        LOGGER.info(String.format("Json Message received -> %s", user.toString()));
    }


    @KafkaListener(topics = "Bookings", groupId = "${spring.kafka.consumer.group-id}")
    public ResponseEntity<?> consumeBookings(BookingRequestDTO bookingRequestDTO) throws Exception {
        LOGGER.info(String.format("Json Message received -> %s", bookingRequestDTO.toString()));

        ReservationConfirmationDTO reservationConfirmationDTO = new ReservationConfirmationDTO();

        reservationConfirmationDTO.setBookingID(bookingRequestDTO.getBookingID());
        reservationConfirmationDTO.setCustomerID(bookingRequestDTO.getCustomerID());
        reservationConfirmationDTO.setNoOfBookedSeats(bookingRequestDTO.getNoOfBookedSeats());

        try {

            Optional<Show> show = showRepository.findById(bookingRequestDTO.getShowId());

            SeatCategory seatCategory = seatCategoryRepository.findByShowAndType(show.get(),bookingRequestDTO.getSeatCategory());

            int availableSeatCount = seatCategory.getAvailableSeatCount();

            if(availableSeatCount > bookingRequestDTO.getNoOfBookedSeats()){

                Booking booking = new Booking();

                if(!checkUser(bookingRequestDTO.getCustomerID())) {
                    Customer customer = new Customer();
                    customer.setCustomerID(bookingRequestDTO.getCustomerID());
                    customer.setCustomerName(bookingRequestDTO.getName());
                    customer.setEmail(bookingRequestDTO.getCustomerEmail());
                    customerRepository.save(customer);
                    booking.setCustomer(customer);
                }
                else{
                    Customer existCustomer = customerRepository.findById(bookingRequestDTO.getCustomerID());
                    booking.setCustomer(existCustomer);
                }

                booking.setBookingID(bookingRequestDTO.getBookingID());
                booking.setNoOfBookedSeats(bookingRequestDTO.getNoOfBookedSeats());
                booking.setMovie(show.get().getMovie());
                booking.setShowID(bookingRequestDTO.getShowId());
                booking.setSeatCategory(bookingRequestDTO.getSeatCategory());
                bookingRepository.save(booking);

                seatCategory.setAvailableSeatCount(availableSeatCount-bookingRequestDTO.getNoOfBookedSeats());
                seatCategoryRepository.save(seatCategory);

                reservationConfirmationDTO.setMessage("Reservation Successfully Done...");

                jsonKafkaProducer.sendReservationStatusMessage(reservationConfirmationDTO);

                return ResponseEntity.badRequest().body("********** Reservation SuccessFull **********");
            }

            else {
                reservationConfirmationDTO.setMessage("Reservation Not Successful...!");

                jsonKafkaProducer.sendReservationStatusMessage(reservationConfirmationDTO);

                return ResponseEntity.badRequest().body("********** Seats Not Availabe **********");
            }
        } catch (Exception e) {
            LOGGER.error("Error processing message", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing message");
        }
    }

    public boolean checkUser(int id){
        return customerRepository.findById(id) !=null ? true:false;
    }

}
