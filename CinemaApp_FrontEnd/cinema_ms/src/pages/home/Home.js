import React from "react";
import "./Home.css"
import { useSelector } from "react-redux";

export default function Home() {
  const { currentUser } = useSelector((state) => state.user);
  return (
    <section className="custom-section">
      <div className="col-12 position-relative d-flex align-items-center justify-content-center">
        <div className="image-overlay">
          <h2>Welcome to Our CinemaMS</h2>
          <p>CinemaMS seamlessly connects cinema owners and enthusiasts.<br/>Owners effortlessly update screenings, while movie lovers explore listings and book tickets<br/>creating an accessible and immersive cinematic experience.</p>
        </div>
      </div>
    </section>
  );
}
