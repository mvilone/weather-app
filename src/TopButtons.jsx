import React from "react";

function TopButtons() {
  const cities = ["New York", "London", "Tokyo", "Sydney", "Paris"];

  return (
    <div className="flex justify-center gap-4 py-4">
      {cities.map((city, index) => (
        <button
          key={index}
          className="bg-gray-700 text-white px-4 py-2 rounded hover:bg-gray-600"
        >
          {city}
        </button>
      ))}
    </div>
  );
}

export default TopButtons;
