import React from "react";
import { useNavigate } from "react-router-dom";
import "./seat.css"

const seatData = [
  {
    cinema_id: 1,
    type: "Superier",
    count: 25,
    price: "1500",
  },
  {
    cinema_id: 1,
    type: "Balcony",
    count: 50,
    price: "1000",
  },
  {
    cinema_id: 1,
    type: "Normal",
    count: 200,
    price: "800",
  },
  {
    cinema_id: 1,
    type: "Lower",
    count: 100,
    price: "500",
  },
];


export default function Seat() {
  const navigate = useNavigate();

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
                <th scope="col">Seat Count</th>
              </tr>
            </thead>
            <tbody>
              {seatData.map((seat, index) => (
                <tr key={index}>
                  <th scope="row">{index + 1}</th>
                  <td>{seat.type}</td>
                  <td>{seat.price}</td>
                  <td>{seat.count}</td>
                  <td>
                    <button
                      className="button2"
                      type="button"
                      onClick={(e) => handleClick("/editSeat")}
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
