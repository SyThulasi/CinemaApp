import React from "react";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import "./Navbar.css";

export default function () {
  const navigate = useNavigate();

  const { currentUser } = useSelector((state) => state.user);

  function handleLoginClick(path) {
    navigate(path);
  }

  return (
    <div>
      <nav class="navbar navbar-expand-lg navbar-dark bg-black ">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            CinemaMS
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/home">
                  Home
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/movies">
                  Movies
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/seat">
                  Seat Inventory
                </a>
              </li>
            </ul>

            <div class="form1 ">
              {currentUser ? (
                <>
                  {/* <a class="nav-link active" aria-current="page" href="/home">
                  {currentUser.cinemaName}
                  </a> */}
                  <button
                    class="btn btn-outline-danger button1"
                    type="submit"
                    onClick={(e) => handleLoginClick("/edituser")}
                  >
                    Edit User
                  </button>
                </>
              ) : (
                <>
                  <button
                    class="btn btn-outline-danger button1"
                    type="submit"
                    onClick={(e) => handleLoginClick("/login")}
                  >
                    Log IN
                  </button>

                  <button
                    class="btn btn-outline-danger pr-10"
                    type="submit"
                    onClick={(e) => handleLoginClick("/register")}
                  >
                    Register
                  </button>
                </>
              )}
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
}
