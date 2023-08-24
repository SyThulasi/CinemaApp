import React from "react";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import MovieAlbum from "../../layout/MovieAlbum";
import "./Movies.css";

export default function Movies() {
  const navigate = useNavigate();

  function handleLoginClick(path) {
    navigate(path);
  }

  return (
    <section className="custom-section3">
      <div className="image-overlay1">
        <h2 className="movie">Movies</h2>{" "}
        <button
          class="btn btn-outline-danger "
          type="submit"
          onClick={(e) => handleLoginClick("/addMovie")}
        >
          Add Movie
        </button>
      </div>
      <div className="col-10 position-relative movie-album-container">
        <div className="movie-album">
          <MovieAlbum
            movieName="Jailer"
            language="Tamil"
            duration="169 Mins"
            country="Indian"
            imageSrc="./Images/jailer.jpg"
          />
        </div>
        <div className="movie-album">
          <MovieAlbum
            movieName="Jailer"
            language="Tamil"
            duration="169 Mins"
            country="Indian"
            imageSrc="./Images/jailer.jpg"
          />
        </div>
        <div className="movie-album">
          <MovieAlbum
            movieName="Jailer"
            language="Tamil"
            duration="169 Mins"
            country="Indian"
            imageSrc="./Images/jailer.jpg"
          />
        </div>
        <div className="movie-album">
          <MovieAlbum
            movieName="Jailer"
            language="Tamil"
            duration="169 Mins"
            country="Indian"
            imageSrc="./Images/jailer.jpg"
          />
        </div>
        <div className="movie-album">
          <MovieAlbum
            movieName="Jailer"
            language="Tamil"
            duration="169 Mins"
            country="Indian"
            imageSrc="./Images/jailer.jpg"
          />
        </div>
      </div>
    </section>
  );
}
