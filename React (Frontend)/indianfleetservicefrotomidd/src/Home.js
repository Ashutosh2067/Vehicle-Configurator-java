import React from "react";
import { MDBContainer } from "mdb-react-ui-kit";
import { Carousel,Ratio,Container,Col,Row,Card,Button,ButtonGroup } from "react-bootstrap";

export default function Home()
{

  const heading = document.getElementById('heading');
const text = document.getElementById('text');

setInterval(() => {
  const randomColor = Math.floor(Math.random()*16777215).toString(16);
  heading.style.color = "#" + randomColor;
  text.style.color = "#" + randomColor;
}, 1000);

    return(
      <div className="wrapper">
      <div className="content">
        <h1  >Welcome to our Indian Fleet Services</h1>
        
      </div>
      <Carousel>
        <Carousel.Item>
          <Ratio aspectRatio={50}>
            <video
              className="slider-video w-100"
              src="images\HomeVideo.mp4"
              loop
              autoPlay
              muted
              id="bg-video"
            >
              <source src="images\HomeVideo.mp4" type="video/mp4" />
            </video>
          </Ratio>
        </Carousel.Item>
      </Carousel>
    </div>

    )
}