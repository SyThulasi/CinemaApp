import { useRef, useState, useEffect, useContext } from "react";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import axios from "../../register/api/axios";
const URL = "/Seats/save";

const AddSeatCategory = () => {

  const { currentUser } = useSelector((state) => state.user);

  const userRef = useRef();
  const errRef = useRef();

    const [category, setCategory] = useState("");
    const [seatCount, setSeatCount] = useState("");
    const [ticketPrice, setTicketPrice] = useState("");
    
  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    userRef.current.focus();
  }, []);


  const dispatch = useDispatch();
  const navigate = useNavigate();

const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post(URL, {
              cinema_id: currentUser.cinema_id,
              type: category,
              count : seatCount,
              price: ticketPrice,
            });
            navigate("/seat")
        } 
        catch (err) {

        }
    }
  return (
    <section className="custom-section1 center">
      <section className="custom-container">
        <p
          ref={errRef}
          className={errMsg ? "errmsg" : "offscreen"}
          aria-live="assertive"
        >
          {errMsg}
        </p>
        <h1>Add Seat Category</h1>
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

          <button>Add</button>
        </form>
      </section>
    </section>
  );
};

export default AddSeatCategory;
