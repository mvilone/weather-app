import React from "react";

function Details() {
  return (
    <div className="text-white py-4 px-6 bg-gray-800 rounded-lg shadow-md">
      <p className="text-lg font-semibold mb-2">Weather Details</p>
      <div className="grid grid-cols-2 gap-4">
        <div>
          <p className="text-sm">Feels Like:</p>
          <p className="text-md font-medium">24°C</p>
        </div>
        <div>
          <p className="text-sm">Humidity:</p>
          <p className="text-md font-medium">68%</p>
        </div>
        <div>
          <p className="text-sm">Wind:</p>
          <p className="text-md font-medium">14 km/h</p>
        </div>
        <div>
          <p className="text-sm">Pressure:</p>
          <p className="text-md font-medium">1013 hPa</p>
        </div>
      </div>
    </div>
  );
}

export default Details;
