import React,{useState} from 'react'

export default function Login() {

    const [userType, setUserType] = useState('jobseeker'); // Default user type

  return (
    <div className="form">
     <form method="post">
       <div className="input-container">
         <label>Username </label>
         <input type="text" name="uname" required />
        
       </div>
       <div className="input-container">
         <label>Password </label>
         <input type="password" name="pass" required />
         
       </div>
       <div className="button-container">
         <input type="submit" />
       </div>
       <div>
        New User?<a href={`/${userType}/registration`}>
            SignUp 
          </a>
       </div>
     </form>
   </div>

  )
}
