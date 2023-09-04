import React from 'react'
import { useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

import DataHandler from "../../Handler/DataHandler";
import axios from "axios";
const URL = "/Movies/save";

export const ShowMovie = () => {
  const navigate = useNavigate();
  const [movieData, setMovieData] = useState([]);
  
  const { movieID } = useParams();

    const { currentUser } = useSelector((state) => state.user);


    useEffect(() => {
      const fetchMovie = async () => {
        try {
          const response = await axios.get(
            `http://localhost:8090/api/v1/cinemaUser/Movies/save/show/${movieID}`,
            {
              auth: {
                username: DataHandler.getFromSession("username"),

                password: DataHandler.getFromSession("password"),
              },
            }
          );
          setMovieData(response.data);
          console.log(movieData);
        } catch (error) {
          console.error("Error fetching movies:", error);
        }
      };

      fetchMovie();
    }, []);

    function handleClick(path) {
      navigate(path);
    }

  return (
    <section className="custom-section3 center">
      <div className="col-12 position-relative table-hover align-items-center justify-content-center">
        <div className="image-overlay">
          <table className="table">
            <thead>
              <tr>
                <th scope="col">Show ID</th>
                <th scope="col">Show Date</th>
                <th scope="col">Show Time</th>
                <th scope="col">View Bookings</th>
              </tr>
            </thead>
            <tbody>
              {movieData.map((show, index) => (
                <tr key={index}>
                  <td>{show.showID}</td>
                  <td>{show.showDate}</td>
                  <td>{show.showTime}</td>
                  <td>
                    <button
                      className="button2"
                      type="button"
                      onClick={(e) =>
                        handleClick(`/showBooking/${show.showID}`)
                      }
                    >
                      VIEW
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
