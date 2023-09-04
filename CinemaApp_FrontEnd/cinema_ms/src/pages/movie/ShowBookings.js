import React from "react";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import DataHandler from "../../Handler/DataHandler";
import axios from "axios";
const URL = "/Movies/save";

export const ShowBookings = ({ movieID}) => {
  const navigate = useNavigate();
  const [bookingData, setBookingData] = useState([]);

    const { currentUser } = useSelector((state) => state.user);
    
    const { showID } = useParams();

  useEffect(() => {
    const fetchBookings = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8090/api/v1/cinemaUser/Movies/save/booking/${showID}`,
          {
            auth: {
              username: DataHandler.getFromSession("username"),

              password: DataHandler.getFromSession("password"),
            },
          }
        );
        setBookingData(response.data);
        console.log(bookingData);
      } catch (error) {
        console.error("Error fetching movies:", error);
      }
    };

    fetchBookings();
  }, []);

  function handleClick(path) {
    navigate(path);
  }

  return (
    <section className="custom-section3 center">
      <div className="col-12 position-relative table-hover align-items-center justify-content-center">
        <div className="image-overlay">
          <table className="table">
            <thead>
              <tr>
                <th scope="col">Booking ID</th>
                <th scope="col">Seat Category</th>
                <th scope="col">No Of Seats</th>
                <th scope="col">Customer Name</th>
              </tr>
            </thead>
            <tbody>
              {bookingData.map((booking, index) => (
                <tr key={index}>
                  <td>{booking.bookingID}</td>
                  <td>{booking.seatCategory}</td>
                  <td>{booking.noOfBookedSeats}</td>
                  <td>{booking.customer.customerName}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </section>
  );
};
