import React from 'react';
import NavBar from './NavBar';
import '../css/HomeComponent.css'

export default function HomeComponent() {
  return (
    <div>
      <NavBar />
      <div className="home-content">
        <h1>Welcome to Our Job Portal</h1>
        <p>Find your dream job here. Explore opportunities from top companies.</p>
      </div>
    </div>
  );
}
