import React from "react";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import MovieAlbum from "../../layout/MovieAlbum";
import { useEffect, useState } from "react";
import "./Movies.css";
import DataHandler from "../../Handler/DataHandler";
import axios from "axios";
const URL = "/Movies/save";

export default function Movies() {
  const navigate = useNavigate();
  const [movies, setMovies] = useState([]);

  const { currentUser } = useSelector((state) => state.user);

useEffect(() => {

  const fetchMovies = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8090/api/v1/cinemaUser/Movies/save/cinema/${currentUser.cinemaId}`,
        {
          auth: {
            username: DataHandler.getFromSession("username"),

            password: DataHandler.getFromSession("password"),
          },
        }
      );
      setMovies(response.data);
      console.log(movies);
    } catch (error) {
      console.error("Error fetching movies:", error);
    }
  };

  fetchMovies();
}, []);

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
        {movies.map((movie, index) => (
          <div key={index} className="movie-album">
            <MovieAlbum
              movieName={movie.movieName}
              description={movie.description}
              releaseDate={movie.releaseDate}
              language={movie.language}
              duration={movie.durationMinutes}
              imageSrc={movie.imgURL}
              path={`/showMovie/${movie.movieID}`}
            />
          </div>
        ))}
      </div>
    </section>
  );
}
