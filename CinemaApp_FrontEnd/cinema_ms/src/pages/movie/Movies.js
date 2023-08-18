import React from "react";
import MovieAlbum from "../../layout/MovieAlbum";
import "./Movies.css";

export default function Movies() {
  return (
    <section className="custom-section3">
      <div className="image-overlay1">
        <h2>Movies</h2>{" "}
      </div>
      <div className="col-10 position-relative movie-album-container">
        <div className="movie-album">
          <MovieAlbum />
        </div>
        <div className="movie-album">
          <MovieAlbum />
        </div>
        <div className="movie-album">
          <MovieAlbum />
        </div>
      </div>
    </section>
  );
}
