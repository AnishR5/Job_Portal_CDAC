import React,{useState} from 'react'
import axios from 'axios';
import { NavLink,Link } from 'react-router-dom';

export default function Login() {

    const [userType, setUserType] = useState('jobseeker'); // Default user type
    const url = "http://localhost:7070/jobseeker/signin";
    function login () {
  /*     axios.post(url, {
        userName: "AnishR5",
      password: "abc"
      }).then((response) => {
        console.log(response);
      }); */
    }
  return (
    <div className="form">
     <form method="get">
       <div className="input-container">
         <label>Username </label>
         <input type="text" name="uname" required />
        
       </div>
       <div className="input-container">
         <label>Password </label>
         <input type="password" name="pass" required />
         
       </div>
       <div className="button-container">
         <input type="submit" onClick={login()}/>
       </div>
       <div>
        New User?<NavLink to={`/${userType}/registration`} >SignUp</NavLink>
        {/* <a href={`/${userType}/registration`}>
            SignUp 
          </a> */}
       </div>
     </form>
   </div>

  )
}
