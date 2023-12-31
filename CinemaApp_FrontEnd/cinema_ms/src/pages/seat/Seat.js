import React from "react";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import { useEffect, useState } from "react";
import DataHandler from "../../Handler/DataHandler";
import axios from "axios";
import "./seat.css"



export default function Seat() {
  const navigate = useNavigate();
  const [seats, setSeats] = useState([]);

  const { currentUser } = useSelector((state) => state.user);

  useEffect(() => {
    const fetchSeats = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8090/api/v1/cinemaUser/Seats/save/Seats/${currentUser.cinemaId}`,
          {
            auth: {
              username: DataHandler.getFromSession("username"),

              password: DataHandler.getFromSession("password"),
            },
          }
        );
        setSeats(response.data);
        console.log(seats)
      } catch (error) {
        console.error("Error fetching seats:", error);
      }
    };

    fetchSeats();
  }, []);

    function handleClick(path) {
      navigate(path);
    }
  
  return (
    <section className="custom-section">
      <div className="image-overlay1">
        <h2 className="movie">Seat Inventory Management</h2>{" "}
        <button
          class="btn btn-outline-danger "
          type="submit"
          onClick={(e) => handleClick("/addSeat")}
        >
          Add Seat Category
        </button>
      </div>
      <div className="col-12 position-relative table-hover align-items-center justify-content-center">
        <div className="image-overlay">
          <table className="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Seat Type</th>
                <th scope="col">Price</th>
                <th scope="col">Seat Count</th>
                <th scope="col">Edit</th>
              </tr>
            </thead>
            <tbody>
              {seats.map((seat, index) => (
                <tr key={index}>
                  <th scope="row">{index + 1}</th>
                  <td>{seat.type}</td>
                  <td>{seat.price}</td>
                  <td>{seat.count}</td>
                  <td>
                    <button
                      className="button2"
                      type="button"
                      onClick={(e) => handleClick(`/editSeat/${seat.id}`)}
                    >
                      Edit
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </section>
  );
}
