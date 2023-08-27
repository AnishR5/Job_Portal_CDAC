import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

export default function JPNavBar() {
  return (
    <div>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="/">Job Portal</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/jobprovider/home">Home</Nav.Link>
            <Nav.Link href="/jobprovider/insertjob">Post Job</Nav.Link>
            <Nav.Link href='/jobprovider/update'>Update</Nav.Link>
          </Nav>
          <Navbar.Collapse className="justify-content-end">
            <Nav.Link href="/logout">SignOut</Nav.Link>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
}
