import React from "react";
import "./MovieAlbum.css";
import { useNavigate } from "react-router-dom";

export default function MovieAlbum({
  movieName,
  language,
  duration,
  releaseDate,
  description,
  imageSrc,
  path
}) {
  const navigate = useNavigate();

  function handleClick(path) {
    navigate(path);
  }

  return (
    <div className="movie-card">
      <div class="card ">
        <img
          src={imageSrc}
          class="card-img-top fixed-height-img"
          alt="..."
        ></img>
        <div class="card-body">
          <h5 class="card-title">{movieName}</h5>
          <p class="card-text fixed-height-p">{description}</p>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">{language}</li>
          <li class="list-group-item">From : {releaseDate}</li>
          <li class="list-group-item">Duration : {duration} Mins</li>
        </ul>
        <div class="card-body custom-card-body ">
          <button
            class="btn btn-outline-danger "
            type="submit"
            onClick={(e) => handleClick(path)}
          >
            Show
          </button>
        </div>
      </div>
    </div>
  );
}
