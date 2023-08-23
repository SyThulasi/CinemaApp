import React from "react";

export default function Seat() {
  return (
    <section className="custom-section">
      <div className="col-12 position-relative table-hover align-items-center justify-content-center">
        <div className="image-overlay">
          <table className="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Seat Type</th>
                <th scope="col">Price</th>
                <th scope="col">Seat Count</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Balcony</td>
                <td>1000.00</td>
                <td>50</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Middle</td>
                <td>700.00</td>
                <td>150</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Lower</td>
                <td>500.00</td>
                <td>100</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </section>
  );
}
