import React from 'react'
import { NavLink } from 'react-router-dom'


export default function NavBar() {
  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <NavLink className="navbar-brand" to="/home">
    Home
  </NavLink>
  <button
    className="navbar-toggler"
    type="button"
    data-toggle="collapse"
    data-target="#navbarNav"
    aria-controls="navbarNav"
    aria-expanded="false"
    aria-label="Toggle navigation"
  >
    <span className="navbar-toggler-icon" />
  </button>
  <div className="collapse navbar-collapse" id="navbarNav">
    <ul className="navbar-nav">
      <li className="nav-item">
        <NavLink className="nav-link" to="/jobseeker">
          Job Seeker
        </NavLink>
      </li>
      <li className="nav-item">
        <NavLink className="nav-link" to="/jobprovider">
          Job Provider
        </NavLink>
      </li>
      <li className="nav-item dropdown">
              <NavLink
                className="nav-link dropdown-toggle"
                to="#"
                id="userDropdown"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                User
              </NavLink>
              <div
                className="dropdown-menu"
                aria-labelledby="userDropdown"
              >
                <NavLink className="dropdown-item" to="/login">
                  Login
                </NavLink>
                <NavLink className="dropdown-item" to="/register">
                  Register
                </NavLink>
              </div>
            </li>
      
    </ul>
  </div>
</nav>

      
    </div>
  )
}
