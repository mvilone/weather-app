import React from 'react';
import WeatherImage from './weather-placeholder.png'; // add an image to src folder

function Content() {
  return (
    <div>
      <h2>Weather Overview</h2>
      <img src={WeatherImage} alt="Weather" style={{ width: '100%', maxWidth: '600px' }} />
    </div>
  );
}

export default Content;
