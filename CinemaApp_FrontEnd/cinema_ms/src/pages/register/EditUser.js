import { useRef, useState, useEffect, useParam } from "react";
import { loginFailure, loginStart, loginSuccess } from "../../redux/userSlice";
import { useDispatch } from "react-redux";
import { logout } from "../../redux/userSlice";
import {
  faCheck,
  faTimes,
  faInfoCircle,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from "./api/axios";
import "./Register.css";
import { useSelector } from "react-redux";
import DataHandler from "../../Handler/DataHandler";
import { useNavigate } from "react-router-dom";

const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;

const URL = "/user/save";

const EditUser = () => {
  const { currentUser } = useSelector((state) => state.user);

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const userRef = useRef();
  const errRef = useRef();

  const [cinemaName, setCinemaName] = useState(currentUser.cinemaName);

  const [city, setCity] = useState(currentUser.city);

  const [phoneNo, setphoneNo] = useState(currentUser.phoneNo);

  const [user, setUser] = useState(currentUser.userName);
  const [validName, setValidName] = useState(false);
  const [userFocus, setUserFocus] = useState(false);

  const [oldPwd, setOldPwd] = useState("");

  const [newPwd, setNewPwd] = useState("");

  const [pwd, setPwd] = useState("");
  const [validPwd, setValidPwd] = useState(false);
  const [pwdFocus, setPwdFocus] = useState(false);

  const [matchPwd, setMatchPwd] = useState("");
  const [validMatch, setValidMatch] = useState(false);
  const [matchFocus, setMatchFocus] = useState(false);

  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    userRef.current.focus();
  }, []);

  useEffect(() => {
    setValidName(USER_REGEX.test(user));
  }, [user]);

  useEffect(() => {
    setValidPwd(PWD_REGEX.test(pwd));
    setValidMatch(pwd === matchPwd);
  }, [pwd, matchPwd]);

  useEffect(() => {
    setErrMsg("");
  }, [user, pwd, matchPwd]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const v1 = USER_REGEX.test(user);
      const v2 = PWD_REGEX.test(pwd);
      DataHandler.setToSession("username", user);

    if (oldPwd.length === 0) {
      if (pwd.length === 0 && matchPwd === 0) {

        setNewPwd(DataHandler.getFromSession("password"));
        //---------------------------------------------
      } else {
        setErrMsg("Old Password is not correct");
        return;
      }
    } else {
        if (oldPwd == DataHandler.getFromSession("password")) {
            if (pwd == matchPwd) {
              if (!v2) {
                setErrMsg("Invalid Entry");
                return;
              }
              setNewPwd(pwd);
              //-----------------------------------------
            } else {
              setErrMsg("Password does not match..!");
              return;
            }
        }
        else { 
            setErrMsg("Incorrect Old Password");
            return;
        }
    }
    if (!v1) {
      setErrMsg("Invalid Entry");
      return;
    }

    try {
      const response = await axios.put(
        `http://localhost:8090/api/v1/cinemaUser/user/save`,
        {
          cinemaId: currentUser.cinemaId,
          cinemaName: cinemaName,
          city: city,
          phoneNo: phoneNo,
          userName: user,
          password: newPwd,
        },
        {
          auth: {
            username: DataHandler.getFromSession("username"),
            password: DataHandler.getFromSession("password"),
          },
        }
      );
        
      DataHandler.setToSession("password", newPwd);
      dispatch(loginSuccess(response.data));
      dispatch(logout());
      navigate("/login");
      
      console.log(response?.data);
      console.log(response?.accessToken);
      console.log(JSON.stringify(response));
      setSuccess(true);
    } catch (err) {
      if (!err?.response) {
        setErrMsg("No Server Response");
      } else if (err.response?.status === 409) {
        setErrMsg("Username Taken");
      } else {
        setErrMsg("Registration Failed");
      }
      errRef.current.focus();
    }
  };

  return (
    <section className="custom-section2 center">
      <section className="custom-container">
        <p
          ref={errRef}
          className={errMsg ? "errmsg" : "offscreen"}
          aria-live="assertive"
        >
          {errMsg}
        </p>
        <h1>Edit Your Profile</h1>
        <form onSubmit={handleSubmit}>
          <label htmlFor="cinemaName">Cinema Name:</label>
          <input
            type="text"
            id="cinemaName"
            ref={userRef}
            autoComplete="off"
            onChange={(e) => setCinemaName(e.target.value)}
            value={cinemaName}
            required
          />
          <label htmlFor="city">City:</label>
          <input
            type="text"
            id="city"
            autoComplete="off"
            onChange={(e) => setCity(e.target.value)}
            value={city}
            required
          />
          <label htmlFor="phoneNo">Phone Number:</label>
          <input
            type="text"
            id="phoneNo"
            autoComplete="off"
            onChange={(e) => setphoneNo(e.target.value)}
            value={phoneNo}
            required
          />
          <label htmlFor="username">
            Username:
            <FontAwesomeIcon
              icon={faCheck}
              className={validName ? "valid" : "hide"}
            />
            <FontAwesomeIcon
              icon={faTimes}
              className={validName || !user ? "hide" : "invalid"}
            />
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
          />
          <p
            id="uidnote"
            className={
              userFocus && user && !validName ? "instructions" : "offscreen"
            }
          >
            <FontAwesomeIcon icon={faInfoCircle} />
            4 to 24 characters.
            <br />
            Must begin with a letter.
            <br />
            Letters, numbers, underscores, hyphens allowed.
          </p>

          <label htmlFor="password">Old Password:</label>
          <input
            type="password"
            id="oldPassword"
            onChange={(e) => setOldPwd(e.target.value)}
            value={oldPwd}
          />

          <label htmlFor="password">
            New Password:
            <FontAwesomeIcon
              icon={faCheck}
              className={validPwd ? "valid" : "hide"}
            />
            <FontAwesomeIcon
              icon={faTimes}
              className={validPwd || !pwd ? "hide" : "invalid"}
            />
          </label>
          <input
            type="password"
            id="password"
            onChange={(e) => setPwd(e.target.value)}
            value={pwd}
            aria-invalid={validPwd ? "false" : "true"}
            aria-describedby="pwdnote"
            onFocus={() => setPwdFocus(true)}
            onBlur={() => setPwdFocus(false)}
          />
          <p
            id="pwdnote"
            className={pwdFocus && !validPwd ? "instructions" : "offscreen"}
          >
            <FontAwesomeIcon icon={faInfoCircle} />
            8 to 24 characters.
            <br />
            Must include uppercase and lowercase letters, a number and a special
            character.
            <br />
            Allowed special characters:{" "}
            <span aria-label="exclamation mark">!</span>{" "}
            <span aria-label="at symbol">@</span>{" "}
            <span aria-label="hashtag">#</span>{" "}
            <span aria-label="dollar sign">$</span>{" "}
            <span aria-label="percent">%</span>
          </p>

          <label htmlFor="confirm_pwd">
            Confirm New Password:
            <FontAwesomeIcon
              icon={faCheck}
              className={validMatch && matchPwd ? "valid" : "hide"}
            />
            <FontAwesomeIcon
              icon={faTimes}
              className={validMatch || !matchPwd ? "hide" : "invalid"}
            />
          </label>
          <input
            type="password"
            id="confirm_pwd"
            onChange={(e) => setMatchPwd(e.target.value)}
            value={matchPwd}
            aria-invalid={validMatch ? "false" : "true"}
            aria-describedby="confirmnote"
            onFocus={() => setMatchFocus(true)}
            onBlur={() => setMatchFocus(false)}
          />
          <p
            id="confirmnote"
            className={matchFocus && !validMatch ? "instructions" : "offscreen"}
          >
            <FontAwesomeIcon icon={faInfoCircle} />
            Must match the first password input field.
          </p>

          <button>Update Your Profile</button>
        </form>
      </section>
    </section>
  );
};

export default EditUser;
