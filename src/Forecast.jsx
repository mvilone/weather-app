import React from "react";

function Forecast() {
  const forecastData = [
    { day: "Mon", temp: "21°C" },
    { day: "Tue", temp: "22°C" },
    { day: "Wed", temp: "24°C" },
    { day: "Thu", temp: "23°C" },
    { day: "Fri", temp: "20°C" }
  ];

  return (
    <div className="text-white py-4">
      <h2 className="text-lg font-semibold mb-2">5-Day Forecast</h2>
      <div className="grid grid-cols-5 gap-4">
        {forecastData.map((day, index) => (
          <div key={index} className="bg-gray-800 rounded-lg p-2 text-center shadow">
            <p>{day.day}</p>
            <p className="font-medium">{day.temp}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Forecast;
