import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import React from 'react';
import { Navbar, Nav, Container, Form, InputGroup } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch } from '@fortawesome/free-solid-svg-icons';

export default function NavigationBar() {

  
  return (
    <Navbar collapseOnSelect expand="lg" variant="dark" fixed="top" className="navbar-transparent Nav" >
    <Container>
      <Navbar.Brand href="/" className="d-flex align-items-center">
        <img
          src={"/images/Logo1.jpg"}
          height="40"
          className="d-inline-block align-top me-2"
          alt="India Fleet Services Logo"
        />
        <span className="text-light fw-bold">India Fleet Services</span>
      </Navbar.Brand>
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
        <Nav className="ms-auto">
          <Nav.Link href="/" className="nav-link-hover">Home</Nav.Link>
          <Nav.Link href="/Login" className="nav-link-hover">Login</Nav.Link>
          <Nav.Link href="/Segment" className="nav-link-hover">Segment</Nav.Link>
          <Nav.Link href="/AboutUs" className="nav-link-hover">About</Nav.Link>
          <Nav.Link href="/Registration" className="nav-link-hover">Registration</Nav.Link>
          <Nav.Link href="/ContactUs" className="nav-link-hover">Contact</Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Container>
  </Navbar>
  );
}