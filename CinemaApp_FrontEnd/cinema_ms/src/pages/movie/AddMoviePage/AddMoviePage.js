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
import dayjs from "dayjs";
import { useRef, useState, useEffect } from "react";
import {
  faCheck,
  faTimes,
  faInfoCircle,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from "../../register/api/axios";
import "./AddMoviePage.css";
import { useNavigate } from "react-router-dom";
import ShowCustomCalendar from "./ShowCustomCalender";
import ShowTimes from "./ShowTimes";

const REGISTER_URL = "/save";

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

const format = "HH:mm";

const AddMoviePage = () => {
  const userRef = useRef();
  const errRef = useRef();

  const navigate = useNavigate();

  const [movieName, setMovieName] = useState("");

  const [description, setDescription] = useState("");

  const [language, setLanguage] = useState("");

  const [duration, setDuration] = useState("");

  const [releaseDate, setReleaseDate] = useState("");

  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    userRef.current.focus();
  }, []);

  //------------------------------------------------------------------------------

  const [showArray, setShowArray] = useState([]);
  const [showTimeArray, setShowTimeArray] = useState([]);

  const handleShowDaysChange = (newElement) => {
    const newArray = [...showArray, newElement];
    setShowArray(newArray);
    console.log(showArray);
  };

  const handleShowTimes = (newElement) => {
    const newArray = [...showTimeArray, newElement];
    setShowTimeArray(newArray);
  };

  // ------------------------------------------------------------------------------------------

  const handleSubmit = async (e) => {
    // e.preventDefault();
    // try {
    //     const response = await axios.post(REGISTER_URL,
    //         {
    //         },
    //     );
    //     navigate("/home")
    // }
    // catch (err) {
    //     errRef.current.focus();
    // }
  };

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
            autoComplete="off"
            onChange={(e) => setMovieName(e.target.value)}
            value={movieName}
            required
          />

          <label htmlFor="city">Description:</label>
          <input
            type="text"
            id="description"
            autoComplete="off"
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

            {/* <Alert message={date.toString()} type="success" /> */}
          </Form.Item>

          <label htmlFor="phoneNo">Add Show Times:</label>

          <Form.Item name="showDay">
            <ShowTimes label="Show times" onDateChange={handleShowTimes} />
            {showTimeArray.map((country) => (
              <Alert message={JSON.stringify(country)} type="success" />
            ))}
          </Form.Item>

          {/* <label htmlFor="username">
                            Username:
                            <FontAwesomeIcon icon={faCheck} className={validName ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validName || !user ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="username"

                            autoComplete="off"
                            onChange={(e) => setUser(e.target.value)}
                            value={user}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        /> */}

          <button>Add</button>
        </form>
      </section>
    </section>
  );
};

export default AddMoviePage;
