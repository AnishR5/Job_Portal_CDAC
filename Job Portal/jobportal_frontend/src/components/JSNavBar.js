import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function JSNavBar() {
    const navigate =useNavigate()
    
  return (
    <div>
    <Navbar bg="dark" data-bs-theme="dark">
      <Container>
        <Navbar.Brand href="/">Job Portal</Navbar.Brand>
        <Nav className="me-auto">
        <Nav.Link href="/jobseeker/home">Home</Nav.Link>
        <Nav.Link href="/job/jobs">All Jobs</Nav.Link>
        </Nav>
        <Navbar.Collapse className="justify-content-end">
          <Nav.Link href='/logout'>SignOut</Nav.Link>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  </div>
  )
}
