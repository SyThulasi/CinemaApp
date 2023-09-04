import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Navbar from './layout/Navbar';
import Home from './pages/home/Home';
import Movies from './pages/movie/Movies';
import AddMoviePage from './pages/movie/AddMoviePage/AddMoviePage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './pages/login/Login';
import Register from'./pages/register/Register'
import Seat from './pages/seat/Seat';
import EditUser from './pages/register/EditUser';
import AddSeatCategory from './pages/seat/AddSeatCategory/AddSeatCategory';
import { useSelector } from "react-redux";
import EditSeatCategory from './pages/seat/AddSeatCategory/EditSeat';
import { ShowMovie } from './pages/movie/ShowMovie';
import { ShowBookings } from './pages/movie/ShowBookings';


function App() {

  const { currentUser } = useSelector((state) => state.user);

  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/movies" element={currentUser ? <Movies /> : <Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/seat" element={currentUser ? <Seat /> : <Login />} />
        <Route
          path="/edituser"
          element={currentUser ? <EditUser /> : <Login />}
        />
        <Route
          path="/addMovie"
          element={currentUser ? <AddMoviePage /> : <Login />}
        />
        <Route
          path="/addSeat"
          element={currentUser ? <AddSeatCategory /> : <Login />}
        />
        <Route
          path="/editSeat/:seatId"
          element={currentUser ? <EditSeatCategory /> : <Login />}
        />
        <Route
          path="/showMovie/:movieID"
          element={currentUser ? <ShowMovie /> : <Login />}
        />
        <Route
          path="/showBooking/:showID"
          element={currentUser ? <ShowBookings /> : <Login />}
        />
      </Routes>
    </Router>
  );
}

export default App;
