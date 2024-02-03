import { EmailRounded, Lock, PasswordRounded, Person2Rounded, Person3Outlined, Person3Rounded } from "@mui/icons-material";
import "./signup.scss";


function Signup() {
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
                Sign Up
                <span className="before-sign-in"></span>
                </div>
            </div>

            <div className="user_input">
                <form>
                    <div className="input-container">
                        <Person3Outlined className="input-icon" />
                        <input type="text" id="name" placeholder="Name"/>
                    </div>
                    <div className="input-container">
                        <EmailRounded className="input-icon" />
                        <input type="email" id="email" placeholder="Email"/>
                    </div>
                    <div className="input-container">
                        <Lock className="input-icon" />
                        <input type="password" id="password" placeholder="Password"/>
                    </div>
                    <div className="terms-and-conditions">
                        <input type="checkbox" id="terms" /> I read and agree to <a href="#">Terms & Conditions</a>
                    </div>
                    <div>
                        <button className="login-btn">Create Account</button>
                    </div>
                </form>
            </div>

            <div className="new-account">
                <hr className="line-break"/>
                <div>Already have an account?  <a href="/login">Log in </a></div>
            </div>
            </div>
        </div>
    </>
  )
}

export default Signup