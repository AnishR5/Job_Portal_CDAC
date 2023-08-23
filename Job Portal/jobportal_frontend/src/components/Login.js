import React, { useState } from 'react';
import axios from 'axios';
import { NavLink, useNavigate } from 'react-router-dom';

export default function Login() {
  const [userType, setUserType] = useState('jobseeker'); // Default user type
  const navigate = useNavigate(); // Get the navigate function

  const url = "http://localhost:7070/jobseeker/signin";

  const login = async (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const userName = formData.get('uname');
    const password = formData.get('pass');

    try {
      const response = await axios.post(url, {
        userName: userName,
        password: password
      });
      console.log(response);

      // Redirect to /jobseeker/welcome after successful login
      navigate('/jobseeker/welcome');
    } catch (error) {
      console.error(error);
      // Handle error
    }
  };

  return (
    <div className="form">
      <form onSubmit={login}>
        <div className="input-container">
          <label>Username</label>
          <input type="text" name="uname" required />
        </div>
        <div className="input-container">
          <label>Password</label>
          <input type="password" name="pass" required />
        </div>
        <div className="button-container">
          <button type="submit">Login</button>
        </div>
        <div>
          New User?<NavLink to={`/${userType}/registration`}>SignUp</NavLink>
        </div>
      </form>
    </div>
  );
}
