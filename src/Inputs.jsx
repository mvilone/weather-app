import React from "react";

function Inputs() {
  return (
    <div className="flex justify-center my-6">
      <div className="flex w-3/4 items-center justify-center space-x-4">
        <input
          type="text"
          placeholder="Enter city..."
          className="text-xl font-light p-2 w-full shadow-xl focus:outline-none capitalize placeholder:lowercase"
        />
        <button className="bg-blue-500 text-white px-4 py-2 rounded">Search</button>
      </div>
    </div>
  );
}

export default Inputs;
