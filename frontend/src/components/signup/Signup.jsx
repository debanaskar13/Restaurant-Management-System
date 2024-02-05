import { CancelRounded, Check, CheckCircle, CheckCircleRounded, Email, EmailRounded, InfoRounded, Lock, PasswordRounded, Person2Rounded, Person3Outlined, Person3Rounded, Visibility, VisibilityOff, X } from "@mui/icons-material";
import "./signup.scss";

import { Link , useNavigate } from "react-router-dom";
import { useEffect, useRef, useState } from "react";
import axios from "../../api/Axios";
import {ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import {showToastMessage} from "../../utils/Utils";
import { ErrorIcon, VisibilityIcon } from "../component_util/ComponentUtil";

const USER_REGEX = /^[a-zA-Z][a-zA-Z0-9- ]{3,23}$/;
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;
const EMAIL_REGEX = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/

function Signup() {

    const navigate = useNavigate();


    const userRef = useRef();
    const errRef = useRef();

    const [user, setUser] = useState('');
    const [validName, setValidName] = useState(false);
    const [userFocus, setUserFocus] = useState(false);

    const [email, setEmail] = useState('');
    const [validEmail, setValidEmail] = useState(false);
    const [emailFocus, setEmailFocus] = useState(false);


    const [pwd, setPwd] = useState('');
    const [validPwd, setValidPwd] = useState(false);
    const [pwdFocus, setPwdFocus] = useState(false);

    const [matchPwd, setMatchPwd] = useState('');
    const [validMatchPwd, setValidMatchPwd] = useState(false);
    const [matchPwdFocus, setMatchPwdFocus] = useState(false);

    const [agreeCheck, setAgreeCheck] = useState(false);
    const [pwdHidden,setPwdHidden] = useState(true);
    const [matchPwdHidden,setMatchPwdHidden] = useState(true);

    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        userRef.current.focus();
    }, []);

    useEffect(() => {
        const result = USER_REGEX.test(user);
        setValidName(result);
    }, [user]);

    useEffect(() => {
        const result = EMAIL_REGEX.test(email);
        setValidEmail(result);
    }, [email]);

    useEffect(() => {
        const result = PWD_REGEX.test(pwd);
        setValidPwd(result);
        const match = pwd === matchPwd;
        setValidMatchPwd(match);
    }, [pwd, matchPwd]);


    useEffect(() => {
        setErrMsg('');
    }, [user, email, pwd, matchPwd]);


    const handleSubmit = async (e) => {
        e.preventDefault();

        const validName = USER_REGEX.test(user);
        const validEmail = EMAIL_REGEX.test(email);
        const validPwd = PWD_REGEX.test(pwd);
        const validMatchPwd = pwd === matchPwd;

        if (!validName || !validEmail || !validPwd || !validMatchPwd || !agreeCheck) {
            setErrMsg("Please check your input!");
            return;
        }

        const body = {
            email: email,
            password: pwd,
            firstName: user.split(' ')[0],
            lastName: user.split(' ')[1]
        }
        let message;

        try {
            const response = (await axios.post("/auth/register", JSON.stringify(body), {
                headers: {
                    "Content-Type": "application/json"
                }
            }));

            message = "Registered Successfully Please Login";

            showToastMessage.success(message);
            setSuccess(true);

            setTimeout(navigate,6000, "/login");

        } catch (error) {

            message = error.response.data.detail;

            showToastMessage.failure(message);
        }

    }

    return (

        <>
            <ToastContainer />
            <section className='container'>
                <p ref={errRef} className={errMsg ? "errMsg" : "offscreen"} aria-live="assertive" >{errMsg}</p>
                <div className="login-card">
                    <div className="header">
                        <div className="header-icon">
                            <Person2Rounded className="person-icon" />
                        </div>
                        <div className="text-sign-in">
                            <span className="before-sign-in"></span>
                            Sign Up
                            <span className="before-sign-in"></span>
                        </div>
                    </div>

                    <div className="user_input">

                        <form onSubmit={handleSubmit}>

                            {/* Name Field */}

                            <div className="input-container">
                                <Person3Outlined className="input-icon" />
                                <input
                                    ref={userRef}
                                    type="text"
                                    id="name"
                                    placeholder="Name"
                                    autoComplete="off"
                                    onChange={(e) => setUser(e.target.value)}
                                    value={user}
                                    aria-invalid={validName ? "false" : "true"}
                                    aria-describedby="usernamenote"
                                    onFocus={() => setUserFocus(true)}
                                    onBlur={() => setUserFocus(false)}
                                />

                                <ErrorIcon checkIconValidation={validName} cancelIconValidation={validName || !user}/>
                            </div>
                            <div className="err_deatils">
                                <p id="usernamenote" className={userFocus && user && !validName ? "instructions" : "offscreen"}>
                                    <InfoRounded className="err_icon" />
                                    <span>Started with character.<br />
                                        Length should be 3 to 23  characters.</span>
                                </p>
                            </div>

                            {/* Email Field */}

                            <div className="input-container">
                                <EmailRounded className="input-icon" />
                                <input
                                    type="email"
                                    id="email"
                                    placeholder="Email"
                                    autoComplete="off"
                                    onChange={(e) => setEmail(e.target.value)}
                                    value={email}
                                    required
                                    aria-invalid={validEmail ? "false" : "true"}
                                    aria-describedby="emailnote"
                                    onFocus={() => setEmailFocus(true)}
                                    onBlur={() => setEmailFocus(false)}
                                />

                                <ErrorIcon checkIconValidation={validEmail} cancelIconValidation={validEmail || !email}/>

                            </div>
                            <div className="err_deatils">
                                <p id="emailnote" className={emailFocus && email && !validEmail ? "instructions" : "offscreen"}>
                                    <InfoRounded className="err_icon" />
                                    <span>Must be an email</span>
                                </p>
                            </div>

                            {/* Password Field */}

                            <div className="input-container">
                                <Lock className="input-icon" />
                                <input
                                    type={pwdHidden ? "password" : "text"}
                                    id="password"
                                    placeholder="Password"
                                    onChange={(e) => setPwd(e.target.value)}
                                    value={pwd}
                                    required
                                    aria-invalid={validPwd ? "false" : "true"}
                                    aria-describedby="pwdnote"
                                    onFocus={() => setPwdFocus(true)}
                                    onBlur={() => setPwdFocus(false)}
                                />
                                {/* -------------------------- */}

                                <VisibilityIcon passwordHidden={pwdHidden} setPasswordHidden={setPwdHidden} />

                                <ErrorIcon checkIconValidation={validPwd} cancelIconValidation={validPwd || !pwd}/> 
                                
                            </div>
                            <div className="err_deatils">
                                <p id="pwdnote" className={pwdFocus && !validPwd ? "instructions" : "offscreen"}>
                                    <InfoRounded className="err_icon" />
                                    8 to 24 characters.<br />
                                    Must include uppsercase and lowercase , a number and a special character.<br />
                                    Allowed special characters: <span aria-label="exclamation mark">!</span>
                                    <span aria-label="at symbol">@</span><span aria-label="hashtag">#</span>
                                    <span aria-label="dollar sign">$</span><span aria-label="percent">%</span>
                                </p>
                            </div>

                            {/* Confirm Password Field */}

                            <div className="input-container">
                                <Lock className="input-icon" />
                                <input
                                    type={ matchPwdHidden ? "password" : "text"}
                                    id="confirm_password"
                                    placeholder="Confirm Password"
                                    onChange={(e) => setMatchPwd(e.target.value)}
                                    value={matchPwd}
                                    required
                                    aria-invalid={validMatchPwd ? "false" : "true"}
                                    aria-describedby="confirmpwdnote"
                                    onFocus={() => setMatchPwdFocus(true)}
                                    onBlur={() => setMatchPwdFocus(false)}
                                />

                                <VisibilityIcon passwordHidden={matchPwdHidden} setPasswordHidden={setMatchPwdHidden} />

                                <ErrorIcon checkIconValidation={validMatchPwd && matchPwd} cancelIconValidation={validMatchPwd || !matchPwd}/>

                            </div>
                            <div className="err_deatils">
                                <p id="confirmpwdnote" className={matchPwdFocus && !validMatchPwd ? "instructions" : "offscreen"}>
                                    <InfoRounded className="err_icon" />
                                    Must match the first password input field.
                                </p>
                            </div>
                            <div className="terms-and-conditions">
                                <input
                                    type="checkbox"
                                    value={agreeCheck}
                                    id="terms"
                                    onClick={(e) => setAgreeCheck(!agreeCheck)}

                                /> I read and agree to <a href="#">Terms & Conditions</a>
                            </div>
                            <div>
                                <button
                                    disabled={!validName || !validEmail || !validPwd || !validMatchPwd || !agreeCheck ? true : false}
                                    className="login-btn"
                                >
                                    Create Account
                                </button>
                            </div>
                        </form>
                    </div>

                    <div className="new-account">
                        <hr className="line-break" />
                        <div>Already have an account?  <Link to={"/login"}>Log in </Link></div>
                    </div>
                </div>
            </section>
        </>
    )
}



export default Signup