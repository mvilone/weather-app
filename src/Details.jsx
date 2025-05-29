import React from "react";

function Details() {
  return (
    <div className="text-white py-6">
      <p>Clear Skies</p>
      <div className="flex justify-around items-center mt-4">
        <p>🌡️ 34°C (Feels like 32°C)</p>
        <p>💧 Humidity: 65%</p>
        <p>💨 Wind Speed: 11 m/h</p>
      </div>
    </div>
  );
}

export default Details;
