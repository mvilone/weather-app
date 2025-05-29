import React from "react";

function Forecast({ title }) {
  const times = ["5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM"];

  return (
    <div>
      <p className="text-white font-medium uppercase">{title}</p>
      <div className="flex justify-between text-white mt-2">
        {times.map((time) => (
          <div key={time} className="text-center">
            <p>{time}</p>
            <p>🌤️</p>
            <p>22°</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Forecast;
