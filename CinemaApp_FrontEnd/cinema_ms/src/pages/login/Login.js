import { useRef, useState, useEffect, useContext } from 'react';
import { useNavigate } from "react-router-dom";
import AuthContext from "./context/AuthProvider";
import "./Login.css"
import axios from './api/axios';
const LOGIN_URL = '/login';



const Login = () => {

    const navigate = useNavigate();
    const { setAuth } = useContext(AuthContext);
    
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

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post(LOGIN_URL,
                { userName : user, password : pwd }
            );
            console.log(JSON.stringify(response?.data));
            //console.log(JSON.stringify(response));
            const accessToken = response?.data?.accessToken;
            const roles = response?.data?.roles;
            navigate('/home');
            // setAuth({ user, pwd, roles, accessToken });
            // setUser('');
            // setPwd('');
            // setSuccess(true);
        } catch (err) {
            if (!err?.response) {
                console.log(err.response)
                setErrMsg('No Server Response');
            } else if (err.response?.status === 400) {
                setErrMsg('Missing Username or Password');
            } else if (err.response?.status === 401) {
                setErrMsg('Unauthorized');
            } else {
                setErrMsg('Login Failed');
            }
            errRef.current.focus();
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
