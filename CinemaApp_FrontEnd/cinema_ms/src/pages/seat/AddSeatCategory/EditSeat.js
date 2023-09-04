import { useRef, useState, useEffect, useContext } from "react";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import { SeatActions } from "../../../Actions/SeatActions";
import axios from "../../register/api/axios";
import DataHandler from "../../../Handler/DataHandler";
import "./edit.css";
const URL = "/Seats/save";


const EditSeatCategory = () => {
  const { currentUser } = useSelector((state) => state.user);

  const { seatId } = useParams();

  const userRef = useRef();
  const errRef = useRef();

  const [id, setId] = useState();
  const [category, setCategory] = useState("");
  const [seatCount, setSeatCount] = useState("");
  const [ticketPrice, setTicketPrice] = useState("");

  useEffect(() => {
    userRef.current.focus();
  }, []);

  const dispatch = useDispatch();
  const navigate = useNavigate();

  //---------------------------------------------------------------------------------------

  // const handleSubmit = (e) => { 
  //   navigate("/seat");
  // }

  //--------------Set Initial Values------------------------------------------------------

    useEffect(() => {
      const fetchSeat = async () => {
        try {
          const response = await axios.get(
            `http://localhost:8090/api/v1/cinemaUser/Seats/save/Seat/${seatId}`,
            {
              auth: {
                username: DataHandler.getFromSession("username"),
                password: DataHandler.getFromSession("password"),
              },
            }
          );
          const seats = response.data;
          console.log(seats);
          setId(seats.id)
          setCategory(seats.type);
          setTicketPrice(seats.price);
          setSeatCount(seats.count);
        } catch (error) {
          console.error("Error fetching seats:", error);
        }
      };

      fetchSeat();
      
      
     
    }, []);


  //---------------------------------------------------------------------------------------

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.put(
        "http://localhost:8090/api/v1/cinemaUser/Seats/save",
        {
          id: id,
          type: category,
          count: seatCount,
          price: ticketPrice,
        },
        {
          auth: {
            username: DataHandler.getFromSession("username"),
            password: DataHandler.getFromSession("password"),
          },
        }
      );
      navigate("/seat");

    } catch (err) {
        console.log(err)
    }
  };

  //------------------------------------------------------------------------------------------
  return (
    <section className="custom-section-edit-seat center">
      <section className="custom-container">
        <h1>Edit</h1>
        <p className="errmsg" aria-live="assertive">
          These changes will be effective for <br />
          upcoming movies.
        </p>
        <form onSubmit={handleSubmit}>
          <label htmlFor="category">Category:</label>
          <input
            type="text"
            id="category"
            ref={userRef}
            autoComplete="off"
            onChange={(e) => setCategory(e.target.value)}
            value={category}
            required
          />
          <label htmlFor="count">Seat Count:</label>
          <input
            type="text"
            id="count"
            autoComplete="off"
            onChange={(e) => setSeatCount(e.target.value)}
            value={seatCount}
            required
          />
          <label htmlFor="price">Ticket price:</label>
          <input
            type="text"
            id="price"
            autoComplete="off"
            onChange={(e) => setTicketPrice(e.target.value)}
            value={ticketPrice}
            required
          />

          <button>Update</button>
        </form>
      </section>
    </section>
  );
};

export default EditSeatCategory;
