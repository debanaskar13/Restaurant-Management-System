import "./login.scss";
import {LoginSocialGoogle} from "reactjs-social-login";
import {GoogleLoginButton} from "react-social-login-buttons";
import {useNavigate} from 'react-router-dom';
import { Person2Rounded } from "@mui/icons-material";



function Login() {

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
            <form>
              <input type="text" id="username" placeholder="Username"/>
              <input type="password" id="password" placeholder="Password"/>
              <div>
                <button className="login-btn">Login</button>
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
            <div>Not a member?  <a href="/signup">Create Account </a></div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Login