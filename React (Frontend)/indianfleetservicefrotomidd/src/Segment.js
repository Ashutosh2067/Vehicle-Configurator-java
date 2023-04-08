import axios from 'axios';
import React from 'react';
import { useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Nav, Navbar, Container, NavDropdown, Col, Row } from 'react-bootstrap';
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  useParams,
  Link,
} from "react-router-dom";
import Display from './Display';
import DefaultConfig from './DefaultConfig';

export default function Segment(props) {

  const [options1, setOptions1] = useState([]);
  const [options2, setOptions2] = useState([]);
  const [options3, setOptions3] = useState([]);
  const [selectedOption1, setSelectedOption1] = useState('');
  const [selectedOption2, setSelectedOption2] = useState('');
  const [selectedOption3, setSelectedOption3] = useState('');

  const [quantity, setQuantity] = useState('');
  const [min, setMin] = useState('');


  useEffect(() => {
    fetch("http://localhost:8080/Segment/Allseg")
      .then((response) => response.json())
      .then((data) => setOptions1(data))
      .catch((error) => console.log(error));
  }, [selectedOption1]);


  useEffect(() => {
    if (selectedOption1) {
      fetch("http://localhost:8080/MfgMaster/AllMfgById/" + selectedOption1)
        .then((response) => response.json())
        .then((data) => setOptions2(data))
        .catch((error) => console.log(error));
    }
  }, [selectedOption1]);

  useEffect(() => {
    if (selectedOption2) {
      console.log(selectedOption2);
      fetch("http://localhost:8080/ModelMaster/AllModel/" + selectedOption2)
        .then((response) => response.json())
        .then((data) => setOptions3(data))
        .catch((error) => console.log(error));
    }
  }, [selectedOption2]);



  const handleOption1Change = (event) => {
    setSelectedOption1(event.target.value);
  }

  const handleOption2Change = (event) => {
    setSelectedOption2(event.target.value);

  }

  const handleOption3Change = (event) => {
    setSelectedOption3(event.target.value);
    setMin(options3.filter(p => (p.modelId == event.target.value))[0].minQty);
  }


  const handleInputChange = (event) => {
    const value = event.target.value;

    // Custom validation to check if value is between 10 and 50 characters
    if (parseInt(value) < 10 || parseInt(value) > 50) {
      event.target.setCustomValidity('Tag number should be between 10 and 50 characters.');
    } else {
      event.target.setCustomValidity('');
    }

    setQuantity(value);
  }

  return (
    <>
      <Container className="pos shadow">
        <Row>
          <Col md={{ span: 6, offset: 3 }}>
            <Form.Label>
              <label>
                <h3><b><u>Choose Car Details</u></b></h3>
              </label>
            </Form.Label>
            <Form.Group className="mb-3">
              <Form.Label className="fw-bold">Segment</Form.Label>
              <Form.Select className="form-select" value={selectedOption1} onChange={handleOption1Change} required>
                <option>--Select--</option>
                {options1.map(p => (
                  <option key={p.segId} value={p.segId}>{p.segName}</option>
                ))}
              </Form.Select>

              <Form.Label className="fw-bold">Manufacturer</Form.Label>
              <Form.Select className="form-select" value={selectedOption2} onChange={handleOption2Change} required>
                <option>--Select--</option>
                {options2.map(option => (
                  <option key={option.mfgId} value={option.mfgId}>{option.mfgName}</option>
                ))}
              </Form.Select>

              <Form.Label className="fw-bold">Model</Form.Label>
              <Form.Select className="form-select" value={selectedOption3} onChange={handleOption3Change} required>
                <option>--Select--</option>
                {options3.map(option => (
                  <option key={option.modelId} value={option.modelId}>{option.modelName}</option>
                ))}
              </Form.Select>

              <Form.Label className="fw-bold">Quantity</Form.Label>
              <input type="number" className="form-control" value={quantity} placeholder={min}
                onChange={handleInputChange} pattern="[0-9]{10,50}" required />

            </Form.Group>
            <Button href={`/DefaultConfig/${selectedOption3}/${quantity}`} className="btn btn-primary" disabled={!selectedOption1 || !selectedOption2 || !selectedOption3 || !quantity || quantity < min}>Next</Button>
          </Col>

          <Col md={{ span: 3 }} className="text-end">
            <div className="position-fixed bottom-0 end-1">
              <video className="w-100" src="/images/SegPage.webm" autoPlay muted></video>
            </div>
          </Col>
        </Row>
      </Container>
    </>


  );
}
