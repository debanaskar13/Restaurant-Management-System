import "./login.scss";
import { LoginSocialGoogle } from "reactjs-social-login";
import { GoogleLoginButton } from "react-social-login-buttons";
import { Link, useNavigate } from 'react-router-dom';
import { EmailSharp, Lock, Person2Rounded } from "@mui/icons-material";
import { useEffect, useRef, useState } from "react";
import axios from "../../api/Axios";
import {LOGIN_URL} from "../../api/ApiUrl";
import { showToastMessage } from "../../utils/Utils";
import {ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";



function Login() {

  const navigate = useNavigate();

  const emailRef = useRef();
  const errRef = useRef();

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();


  useEffect(() => {
    emailRef.current.focus();
  }, []);



  const handleLogin = async (e) => {
    e.preventDefault();

    if(email && password){

      const body = JSON.stringify({email:email,password:password});
      
      try{
        const response = await axios.post(LOGIN_URL,body,{
          headers:{
            "Content-Type": "application/json"
          }
        })
  
        showToastMessage.success("Welcome Back !!");

        setTimeout( ()=> {navigate("/home")},6000 );

      }catch(error){
        console.log(error)
        showToastMessage.failure("Invalid Credentials");
      }

    }else{

      showToastMessage.failure("Please fill all fields");
    }



  }

  return (
    <>
    <ToastContainer />
      <div className='container'>
        <div className="login-card">
          <div className="header">
            <div className="header-icon">
              <Person2Rounded className="person-icon" />
            </div>
            <div className="text-sign-in">
              <span className="before-sign-in"></span>
              Sign In
              <span className="before-sign-in"></span>
            </div>
          </div>

          <div className="user_input">
            <form onSubmit={handleLogin}>
              <div className="input-container">
                <EmailSharp className="input-icon" />
                <input ref={emailRef} type="email" id="email" onChange={e => setEmail(e.target.value)} placeholder="Email" required/>
              </div>
              <div className="input-container">
                <Lock className="input-icon" />
                <input type="password" id="password" onChange={e => setPassword(e.target.value)} placeholder="Password" required/>
              </div>
              <div>
                <button type="submit" className="login-btn">Login</button>
              </div>

            </form>
          </div>

          <div className="remember-forgot">
            <div className="remember-me">
              <input type="checkbox" id="remember_me" /> Remember Me
            </div>
            <div className="forgot-password"><a href="#">Forgot Password?</a></div>
          </div>

          <div className="new-account">
            <hr className="line-break" />
            <div>Not a member?  <Link to={"/signup"}>Create Account </Link></div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Login