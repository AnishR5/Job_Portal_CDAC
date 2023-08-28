import React from 'react';
import '../css/Footer.css'

function Footer() {
  return (
    <footer className="footer">
      <div className="container">
        <div className="row">
          <div className="col-lg-6">
            <h3>About Us</h3>
            <p>Your company's description and mission can go here.</p>
          </div>
          <div className="col-lg-3">
            <h3>Quick Links</h3>
            <ul className="list-unstyled">
              <li><a href="/">Home</a></li>
              <li><a href="/about">About</a></li>
              <li><a href="/services">Services</a></li>
              <li><a href="/contact">Contact</a></li>
            </ul>
          </div>
          <div className="col-lg-3">
            <h3>Contact Us</h3>
            <p>Email: anishrachcha@gmail.com</p>
            <p>Phone: +91 9423749050</p>
          </div>
        </div>
        <div className="row">
          <div className="col-lg-12 text-center">
            <p>&copy; {new Date().getFullYear()} Pg-Dac Group-9. All Rights Reserved.</p>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
