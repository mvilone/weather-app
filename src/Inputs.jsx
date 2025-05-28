import React from "react";

function Inputs() {
  return (
    <div className="flex justify-center py-4">
      <input
        type="text"
        placeholder="Enter city..."
        className="p-2 rounded-l-md border-none w-1/2"
      />
      <button className="p-2 bg-blue-500 text-white rounded-r-md hover:bg-blue-600">
        Search
      </button>
    </div>
  );
}

export default Inputs;
