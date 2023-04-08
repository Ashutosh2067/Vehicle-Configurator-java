import axios from 'axios';
import './App.css';
import Button from 'react-bootstrap/Button';
import { useLayoutEffect, useState, useEffect } from "react";
import { Nav, Navbar, Container, NavDropdown, Col, Row } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import Dropdown from 'react-bootstrap/Dropdown';
import { useHistory } from 'react-router-dom';

export default function DefaultConfig(params) {

  const [name, setname] = useState('');
  const [image, setImagePath] = useState('');
  const [model, setModel] = useState([]);
  const [price, setPrice] = useState();

  const { selectedOption3 } = useParams()
  const { quantity } = useParams()

  const [DefConfi, setDefConfi] = useState([]);
  const [selectedOption, setSelectedOption] = useState('');
  const [selectedOption1, setSelectedOption1] = useState('');





  useEffect(() => {
    fetch(`http://localhost:8080/MfgMaster/getMfgNameAndModelName/${selectedOption3}`)
      .then((response) => response.json())
      .then((data) => {
        setModel(data);
        setname(data[0].mfg_name + "-" + data[0].model_name);
        setPrice(data[0].basic_price)
        setImagePath(data[0].image_path)
      })
      .catch((error) => console.log(error));
  }, [selectedOption3]);


  useEffect(() => {
    fetch(`http://localhost:8080/Component/AllCompByModelId/${selectedOption3}`)
      .then((response) => response.json())
      .then((data) => setDefConfi(data))
      .catch((error) => console.log(error));

  }, [selectedOption]);


  return (
    <>
      <Container fluid className="pos" style={{ marginTop: '220px', backgroundImage: "url('/images/DefaultBackground.jpg')", backgroundSize: 'cover' }}>
        <Row>
          <Col md={{ span: 10, offset: 1 }}>
            <h1 className="mb-4" style={{color:'white'}}>Default Configuration</h1>
            <table>
              <tbody>
                <tr>
                  <td rowspan="2">
                    <div class="box">
                      <div class="overlay"></div>
                      <h3>Core Feature</h3>
                      <ul>
                        {DefConfi.filter(p => p.vehicleDetails.some((q) => q.compType == 'C')).map((c) => (
                          <li key={c.compId}>
                            
                            {c.compName}
                          </li>
                        ))}
                      </ul>
                    </div>
                    <div class="box">
                      <div class="overlay"></div>
                      <h3>Interior Feature</h3>
                      <ul>
                        {DefConfi.filter(p => p.vehicleDetails.some((q) => q.compType == 'I')).map((i) => (
                          <li key={i.compId}>
                            
                            {i.compName}
                          </li>
                        ))}
                      </ul>
                    </div>

                    {model.modelname}

                  </td>
                  <td align='center'>
                    {<img src={image} alt="My Image" style={{ width: '400px', height: 'auto', float: 'left', marginRight: '20px',  marginTop: '250px' }} />}
                    {<h3 style={{ marginTop: '80px' }}>{name}</h3>}
                  </td>
                  <td rowspan="2">
                    <div class="box">
                      <div class="overlay"></div>
                      <h3>Standard Feature</h3>
                      <ul>
                        {DefConfi.filter(p => p.vehicleDetails.some((q) => q.compType == 'S')).map((s) => (
                          <li key={s.compId}>
                            
                            {s.compName}
                          </li>
                        ))}
                      </ul>
                    </div>


                    <div class="box">
                      <div class="overlay"></div>
                      <h3>Exterior Feature</h3>
                      <ul>
                        {DefConfi.filter(p => p.vehicleDetails.some((q) => q.compType == 'E')).map((e) => (
                          <li key={e.compId}>
                            {e.compName}
                          </li>
                        ))}
                      </ul>
                    </div>

                  </td>
                </tr>
              </tbody>
            </table>
          </Col>
        </Row>
        <div className="text-center">
          <table md={{ span: 10, offset: 2 }} className="table">
            <thead>
              {<tr>
                <th>Add Taxes</th>
                <th>
                  Base Price: {price} <br />
                  S.T. @12%: {((price) * 0.12)}
                </th>

                <th>Quantity:{quantity}</th>
              </tr>}
            </thead>
            <tbody>
              <tr>
                <td><b>Total</b></td>
                {
                  <td><b>{(price * quantity) + ((price * quantity) * 0.12)} - include tax</b></td>
                }
                <td>

                </td>
              </tr>
            </tbody>
          </table>
          <br />
          <table className="border-less table">
            <thead>
              <tr>
                <th>
                  <Button href={`/Invoice/${name}/${quantity}/${(price * quantity) + ((price * quantity) * 0.12)}/${selectedOption3}`} variant="success">
                    Confirm
                  </Button>
                </th>
                <th>
                  <Button
                    href={`/Configure/${selectedOption3}/${quantity}`}
                    variant="primary"
                    disabled={!selectedOption3}
                  >
                    Configure
                  </Button>
                </th>
                <th>
                  <Button href="/Segment" variant="danger">
                    Modify
                  </Button>
                </th>
              </tr>
            </thead>
          </table>
        </div>
      </Container>
    </>

  );
}