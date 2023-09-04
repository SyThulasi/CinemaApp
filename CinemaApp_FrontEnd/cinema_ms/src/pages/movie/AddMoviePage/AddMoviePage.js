import {
  Form,
  Input,
  Button,
  Radio,
  Select,
  Cascader,
  DatePicker,
  InputNumber,
  TreeSelect,
  Switch,
  Checkbox,
  Upload,
  Card,
  Space,
  Tag,
  Typography,
  Calendar,
  Alert,
  message,
  TimePicker,
} from "antd";
import {
  faInfoCircle,
} from "@fortawesome/free-solid-svg-icons";
import { useRef, useState, useEffect } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "./AddMoviePage.css";
import { useNavigate } from "react-router-dom";
import ShowCustomCalendar from "./ShowCustomCalender";
import { useDispatch, useSelector } from "react-redux";
import { MovieActions } from "/home//thulasiyan/Documents/CinemaApp/CinemaApp_FrontEnd/cinema_ms/src/Actions/MovieActions";
import axios from "../../register/api/axios";
import DataHandler from "../../../Handler/DataHandler";

const URL = "/Movies/save";

const languageList = [
  "English",
  "Tamil",
  "Sinhala",
  "Spanish",
  "French",
  "German",
  "Italian",
  "Japanese",
  "Chinese",
  "Korean",
  "Russian",
  "Arabic",
  "Portuguese",
  "Hindi",
  "Bengali",
  "Punjabi",
  "Swahili",
  "Dutch",
  "Swedish",
  "Norwegian",
  "Finnish",
  "Danish",
  "Greek",
  "Turkish",
  "Hebrew",
  "Thai",
  "Vietnamese",
  "Indonesian",
  "Malay",
  "Tagalog",
];



const AddMoviePage = () => {

  const { currentUser } = useSelector((state) => state.user);
  // const jsonString = JSON.stringify(currentUser);
  // const userId = jsonString.split(",")
  // const id = userId[0].split(":")

  const dispatch = useDispatch();

  const userRef = useRef();
  const errRef = useRef();

  const navigate = useNavigate();

  const [movieName, setMovieName] = useState("");

  const [description, setDescription] = useState("");

  const [language, setLanguage] = useState(languageList[0]);

  const [duration, setDuration] = useState("");

  const [releaseDate, setReleaseDate] = useState("");

  const [showTimes, setShowTimes] = useState("");

  const [errMsg, setErrMsg] = useState("");

  useEffect(() => {
    userRef.current.focus();
  }, []);
  //-------------------------------------------------------------------------------------------
  const [seats, setSeats] = useState([]);
  
    useEffect(() => {
      const fetchSeats = async () => {
        try {
          const response = await axios.get(
            `http://localhost:8090/api/v1/cinemaUser/Seats/save/Seats/${currentUser.cinemaId}`,
            {
              auth: {
                username: DataHandler.getFromSession("username"),
                password: DataHandler.getFromSession("password"),
              },
            }
          );
          setSeats(response.data);
        } catch (error) {
          console.error("Error fetching seats:", error);
        }
      };
      fetchSeats();
    }, []);
  

  //----------------------------Date and Time Functions----------------------------------------

  const [showArray, setShowArray] = useState([]);

  const handleShowDaysChange = (newElement) => {
    const newArray = [...showArray, newElement];
    setShowArray(newArray);
    console.log(showArray);
  };


  // -----------------------------Handle Submit--------------------------------------------------
  
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (seats.length === 0) {
      setErrMsg("You need to enter your seat details first.");
    } else {
      {
        try {
          const response = await axios.post(
            URL,
            {
              cinemaId: currentUser.cinemaId,
              durationMinutes: duration,
              releaseDate: releaseDate,
              description: description,
              imgURL: "../../public/Images/jailer.jpg",
              language: language,
              movieName: movieName,
              showDates: showArray,
              showTimes: showTimes.split(","),
            },
            {
              auth: {
                username: DataHandler.getFromSession("username"),

                password: DataHandler.getFromSession("password"),
              },
            }
          );
          navigate("/movies");
          console.log("Movie Successfully added.....");
        } catch (err) {
          console.log(err);
        }
      }
    }
  };

  //--------------------------------------------------------------------------------------------
  
  return (
    <section className="custom-section4 center">
      <section className="custom-container">
        <p
          ref={errRef}
          className={errMsg ? "errmsg" : "offscreen"}
          aria-live="assertive"
        >
          {errMsg}
        </p>
        <h1>Add New Movie</h1>
        <form onSubmit={handleSubmit}>
          <label htmlFor="cinemaName">Movie Name:</label>
          <input
            type="text"
            id="movieName"
            ref={userRef}
            onChange={(e) => setMovieName(e.target.value)}
            value={movieName}
            required
          />

          <label htmlFor="city">Description:</label>
          <input
            type="text"
            id="description"
            onChange={(e) => setDescription(e.target.value)}
            value={description}
            required
          />

          <label htmlFor="phoneNo">Language:</label>
          <select
            type="text"
            id="language"
            autoComplete="off"
            onChange={(e) => setLanguage(e.target.value)}
            value={language}
            required
          >
            {languageList.map((language) => (
              <option value={language}>{language}</option>
            ))}
          </select>

          <label htmlFor="phoneNo">Duration (Minutes):</label>

          <input
            type="text"
            id="duration"
            name="duration"
            placeholder="xxx"
            onChange={(e) => setDuration(e.target.value)}
            value={duration}
            step="900"
          />

          <label htmlFor="phoneNo">Release Date:</label>
          <input
            type="date"
            id="releaseDate"
            autoComplete="off"
            onChange={(e) => setReleaseDate(e.target.value)}
            value={releaseDate}
            required
          />

          <label htmlFor="phoneNo">Add Show Dates:</label>
          <p className="errmsg" aria-live="assertive">
            <FontAwesomeIcon icon={faInfoCircle} />
            You need to click the 'Add Date' button after <br />
            selecting everydate in the calendar.
          </p>
          <Form.Item
            name="showDay"
            rules={[
              {
                required: false,
                message: "Please input movie show days!",
              },
            ]}
          >
            <ShowCustomCalendar
              label="Show Days"
              onDateChange={handleShowDaysChange}
            />
          </Form.Item>

          <label htmlFor="showDay">Add Show Times:</label>
          <input
            type="show times"
            id="show times"
            placeholder="09.30,13.30,16.30,19.30"
            onChange={(e) => setShowTimes(e.target.value)}
            value={showTimes}
            required
          />
          <button>Add</button>
        </form>
      </section>
    </section>
  );
};

export default AddMoviePage;
