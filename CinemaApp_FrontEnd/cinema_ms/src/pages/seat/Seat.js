import React from "react";
import { useNavigate } from "react-router-dom";
import "./seat.css"

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
              <tr>
                <th scope="row">1</th>
                <td>Balcony</td>
                <td>1000.00</td>
                <td>50</td>
                <td>
                  <button
                    class="button2"
                    type="submit"
                    onClick={(e) => handleClick("/addMovie")}
                  >
                    Edit
                  </button>
                </td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Middle</td>
                <td>700.00</td>
                <td>150</td>
                <td>
                  <button
                    class="button2"
                    type="submit"
                    onClick={(e) => handleClick("/addMovie")}
                  >
                    Edit
                  </button>
                </td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Lower</td>
                <td>500.00</td>
                <td>100</td>
                <td>
                  <button
                    class="button2"
                    type="submit"
                    onClick={(e) => handleClick("/addMovie")}
                  >
                    Edit
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </section>
  );
}
