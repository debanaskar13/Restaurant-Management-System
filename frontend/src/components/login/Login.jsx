import "./login.scss";
import {LoginSocialGoogle} from "reactjs-social-login";
import {GoogleLoginButton} from "react-social-login-buttons";
import {Link, useNavigate} from 'react-router-dom';
import { EmailSharp, Lock, Person2Rounded } from "@mui/icons-material";
import { useState } from "react";



function Login() {

  const [email,setEmail] = useState();
  const [password,setPassword] = useState();

  const handleLogin = (e) => {
    e.preventDefault();
    console.log(email,password)
  }

  return (
    <>
      <div className='container'>
        <div className="login-card">
          <div className="header">
            <div className="header-icon">
              <Person2Rounded className="person-icon"/>
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
                <EmailSharp className="input-icon"/>
                <input type="text" id="username" onChange={e => setEmail(e.target.value)} placeholder="Email"/>
              </div>
              <div className="input-container">
                <Lock className="input-icon" />
                <input type="password" id="password" onChange={e => setPassword(e.target.value)} placeholder="Password"/>
              </div>
              <div>
                <button type="submit" className="login-btn">Login</button>
              </div>

            </form>
          </div>

          <div className="remember-forgot">
            <div className="remember-me">
              <input type="checkbox" id="remember_me"/> Remember Me
            </div>
            <div className="forgot-password"><a href="#">Forgot Password?</a></div>
          </div>

          <div className="new-account">
            <hr className="line-break"/>
            <div>Not a member?  <Link to={"/signup"}>Create Account </Link></div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Login