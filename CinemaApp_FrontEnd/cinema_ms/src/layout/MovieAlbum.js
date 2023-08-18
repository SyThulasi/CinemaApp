import React from 'react'
import "./MovieAlbum.css"

export default function MovieAlbum() {
  return (
    <div>
        <div class="card ">
          <img src='./Images/jailer.jpg' class="card-img-top" alt="..."></img>
          <div class="card-body">
            <h5 class="card-title">Jailer</h5>
            <p class="card-text">
              South Indian super start Rajinikanth's Movie Directed By Nelson.
            </p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Tamil</li>
            <li class="list-group-item">Indian</li>
            <li class="list-group-item">169 Mins</li>
          </ul>
          <div class="card-body custom-card-body">
          <button
                class="btn btn-outline-danger "
                type="submit"
              >
                Book Now
              </button>
          </div>
        </div>
    </div>
  )
}
