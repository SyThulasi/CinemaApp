import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Navbar from './layout/Navbar';
import Home from './pages/home/Home';
import Movies from './pages/movie/Movies';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './pages/login/Login';
import Register from'./pages/register/Register'
import Seat from './pages/seat/Seat';
import EditUser from './pages/register/EditUser';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/movies" element={<Movies />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register/>} />
        <Route path="/seat" element={<Seat/>} />
        <Route path="/edituser" element={<EditUser/>} />
      </Routes>
    </Router>
  );
}

export default App;
