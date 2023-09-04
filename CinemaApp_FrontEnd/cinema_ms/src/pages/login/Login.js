import { useRef, useState, useEffect, useContext } from 'react';
import { useDispatch } from "react-redux";
import { loginFailure, loginStart, loginSuccess } from "../../redux/userSlice";
import AuthContext from "./context/AuthProvider";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import DataHandler from "../../Handler/DataHandler";
import "./Login.css"
import axios from './api/axios';
const LOGIN_URL = '/user/login';


const Login = () => {

    const { setAuth } = useContext(AuthContext);

    const { currentUser } = useSelector((state) => state.user);
    
    const userRef = useRef();
    const errRef = useRef();

    const [user, setUser] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);


    useEffect(() => {
        userRef.current.focus();
    }, [])

    useEffect(() => {
        setErrMsg('');
    }, [user, pwd])


    const dispatch = useDispatch();
    const navigate = useNavigate()


    const handleSubmit = async (e) => {
        e.preventDefault();
        dispatch(loginStart());
        try {
            const response = await axios.post(LOGIN_URL,
                { userName : user, password : pwd }
            );
            DataHandler.setToSession("username", user);
            DataHandler.setToSession("password", pwd);
            dispatch(loginSuccess(response.data));
            if (currentUser) {
                navigate('/home')
            }

        } catch (err) {
            console.log(err);
            setErrMsg("Credentails are invalid. Try Again");
            dispatch(loginFailure());

        }
    }

    return (
        <section className="custom-section1 center">
                <section className='custom-container'>
                    <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive">{errMsg}</p>
                    <h1 >Sign In</h1>
                    <form  onSubmit={handleSubmit}>
                        <label htmlFor="username">Username:</label>
                        <input
                            type="text"
                            id="username"
                            ref={userRef}
                            autoComplete="off"
                            onChange={(e) => setUser(e.target.value)}
                            value={user}
                            required
                        />

                        <label htmlFor="password">Password:</label>
                        <input
                            type="password"
                            id="password"
                            onChange={(e) => setPwd(e.target.value)}
                            value={pwd}
                            required
                        />
                        <button>Sign In</button>
                    </form>
                    <p>
                        Need an Account?<br />
                        <span className="line">
                            {/*put router link here*/}
                            <a href="/register">Sign Up</a>
                        </span>
                    </p>
                </section>
        </section>
    )
}

export default Login
