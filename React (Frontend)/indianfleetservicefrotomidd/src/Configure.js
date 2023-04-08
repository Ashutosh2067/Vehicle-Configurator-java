import axios from 'axios';
import Button from 'react-bootstrap/Button';
import { useState, useEffect } from "react";
import { Nav, Navbar, Container, NavDropdown, Col, Row } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import Dropdown from 'react-bootstrap/Dropdown';
import Form from 'react-bootstrap/Form'

export default function Configure() {

  const {selectedOption3} = useParams();
  const {quantity} = useParams()
 
  
  const [modelname, setModelname] = useState('');
  const [image, setImagePath] = useState('');
  const [model, setModel] = useState([]);
  const [basicprice, setBasicPrice] = useState();
  const [price, setPrice] = useState(null);


  const [modelDetails, setMode] = useState([])
  const [corefeat, setCore] = useState([])
  const [AlterComp, setAlteComp] = useState([])
  const [opt1, setAlteOpt1] = useState('')
  const [confItem, setConfi] = useState('')
  
  

  useEffect(() => {
    fetch(`http://localhost:8080/MfgMaster/getMfgNameAndModelName/${selectedOption3}`)
      .then((response) => response.json())
      .then((data) => {
        setModel(data);
        setModelname(data[0].mfg_name+"-"+data[0].model_name);
        setBasicPrice(data[0].basic_price)
        setImagePath(data[0].image_path)
        setPrice((data[0].basic_price)*quantity+(data[0].basic_price)*0.12*quantity);
      })
      .catch((error) => console.log(error));
  }, [selectedOption3]);



  useEffect(() => {
    fetch(`http://localhost:8080/Component/AlterComp/${selectedOption3}`)
      .then(response => response.json())
      .then(data => setAlteComp(data))
      .catch(error => console.error(error));

      setConfi(AlterComp.filter(obj => obj.deltaPrice == 0).reduce((acc, curr) => {   
        acc[curr.compID] = curr.altCompId; 
        return acc;
      }, {}));

  }, [setAlteOpt1]);
  

  

  const TypeS = AlterComp.filter(obj => obj.altCompType == 'S')
  console.log("TypeS")
  console.log(TypeS)
  const TypeSWithZero = TypeS.filter(obj => obj.deltaPrice == 0)
  console.log("TypeSWithZero")
  console.log(TypeSWithZero)

  

  //   THIS IS DICTIONARY CREATION(DUPLICATE KEY NOT ALLOWED) 
  //  IN WHICH COMPONENTS HAVING DELTA_PRICE ZERO  ARE STORED.

  const handOnclick = (event) => 
  {
    const { name, value } = event.target;
    confItem[name] = value;
    console.log(confItem);
  }


// changing value of delta-price = 0 component(18,22,28) 
//with the selected altcomponent id
  
  const TypeI = AlterComp.filter(obj => obj.altCompType == 'I')
  const TypeIWithZero = TypeI.filter(obj => obj.deltaPrice == 0)
 

  const TypeE = AlterComp.filter(obj => obj.altCompType == 'E')
  const TypeEWithZero = TypeE.filter(obj => obj.deltaPrice == 0)


// for calculating delta prices of selected component 
  function handleClick() {
    const standAltCompId = Object.entries(confItem).map(([key, value]) => { return parseInt(value) });
    const sumStandDeltaPrices = TypeS
      .filter(S => standAltCompId.includes(S.altCompId))
      .reduce((acc, S) => acc + S.deltaPrice, 0);

    console.log(sumStandDeltaPrices);


    const exteAltCompId = Object.entries(confItem).map(([key, value]) => { return parseInt(value) });
    const sumExteDeltaPrices = TypeE
      .filter(E => exteAltCompId.includes(E.altCompId))
      .reduce((acc, S) => acc + S.deltaPrice, 0);

    console.log(sumExteDeltaPrices);

    const inteAltCompId = Object.entries(confItem).map(([key, value]) => { return parseInt(value) });
    const sumInteDeltaPrices = TypeI
      .filter(I => inteAltCompId.includes(I.altCompId))
      .reduce((acc, S) => acc + S.deltaPrice, 0);

    console.log(sumInteDeltaPrices);

    
// final price calculation delta+ Standerd Price     
    const finalPrice = eval(`${sumStandDeltaPrices}+${sumExteDeltaPrices}+${sumInteDeltaPrices}+${basicprice}*${quantity}+${0.12 * basicprice}*${quantity}`);
    setPrice(finalPrice);

  }


  return (
    <Container style={{ marginTop: '70px' }}>
      <Row>
        <Col>
        <h3 style={{color:'black'}}>{modelname}</h3>  
          <img src={image} alt="My Image" style={{ 
          width: '600px', 
          height: 'auto', 
          float: 'left', 
          marginRight: '20px'
        }} />
        
          
          <Form.Group>
  <Form.Label style={{color:'black'}}>Final Price After Configure</Form.Label>
  <Form.Control type="text" value={price} readOnly />
</Form.Group>

          <table className="border-less table">
      <thead>
        <tr>
          
          <th>
            <Button href={`/Invoice/${modelname}/${quantity}/${price}/${selectedOption3}`} variant="success" disabled={!price}>
              Confirm
            </Button>
          </th>
          <th>
            <Button
              href={`/DefaultConfig/${selectedOption3}/${quantity}` }
              variant="primary"
              disabled={!selectedOption3}
            >
              Previous
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
        </Col>
        <Col style={{marginTop: '30px', color:'black'}}>
          <Form onChange={handleClick}>
            <legend>Configurable Item</legend>
            <Form onChange={handOnclick}>
            <h5>Standard Features</h5>
            {TypeSWithZero.length > 0 ? (
              <>
                {TypeSWithZero.map(p => (
                  <Form.Group key={p.compID}>
                    <Form.Label>{p.compID}{p.compName}</Form.Label>
                    <Form.Control as="select" name={p.compID}>
                      <option value="" disabled selected>Select an option</option>
                      {TypeS.filter(obj => obj.compID == p.compID).map(s => (
                        <option key={s.compID} value={s.altCompId}>
                         {s.compName}
                         {s.altCompId}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>
                ))}
              </>
            ) : (
              <p>No Configurable item</p>
            )}

            <h5>Interior Features</h5>
            {TypeI.length > 0 ? (
              TypeIWithZero.map(p => (
                <Form.Group key={p.compID}>
                  <Form.Label>{p.compName}</Form.Label>
                  <Form.Control as="select" name={p.compID} >
                    <option value="" disabled selected>Select an option</option>
                    {TypeI.filter(obj => obj.compID == p.compID).map(i => (
                      <option key={i.compID} value={i.altCompId}>
                        {i.compName}
                      </option>
                    ))}
                  </Form.Control>
                </Form.Group>
              ))
            ) : (
              <p>No Configurable item</p>
            )}

            <h5>Exterior Features</h5>
            {TypeEWithZero.length > 0 ? (
              TypeEWithZero.map(p => (
                <Form.Group key={p.compID}>
                  <Form.Label>{p.compName}</Form.Label>
                  <Form.Control as="select" name={p.compID}>
                    <option value="" disabled selected>Select an option</option>
                    {TypeE.filter(obj => obj.compID == p.compID).map(e => (
                      <option key={e.altCompId} value={e.altCompId}>
                        {e.compName}
                      </option>
                    ))}
                  </Form.Control>
                </Form.Group>
              ))
            ) : (
              <p style={{ color: "red" }}>No Configurable item</p>
            )}

            <br></br>
            </Form>
          </Form>
        </Col>
      </Row>
    </Container>

  );
}


