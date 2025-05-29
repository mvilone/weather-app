import React from "react";

function TopButtons() {
  const cities = ["London", "US", "Korea", "Asia", "Mexico"];

  return (
    <div className="flex items-center justify-around my-6">
      {cities.map((city) => (
        <button key={city} className="text-white text-lg font-medium">
          {city}
        </button>
      ))}
    </div>
  );
}

export default TopButtons;
