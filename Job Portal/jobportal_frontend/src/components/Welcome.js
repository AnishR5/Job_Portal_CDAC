import React from 'react'
import { NavLink } from 'react-router-dom';

export default function Welcom() {
  return (
    <div>Welcome
       <NavLink to="/job/jobs">Jobs</NavLink>
    </div>
  )
}
