import {BiSearch, BiCurrentLocation} from "react-icons/bi";

const Inputs = () => {
  return (
    <div className="flex flex-row justify-center my-6">
      <div className="flex flex-row w-3/4 items-center justify-center space-x-4">
        <input type="text" placeholder="search by city..." 
        className="bg-white text-black p-2 rounded-md w-full max-w-xs shadow-md focus:outline-none 
        text-xl font-light capitalize placeholder:lowercase" />
        <BiSearch size = {30} className="cursor-pointer transition ease-out hover:scale-125"/>
        <BiCurrentLocation size = {30} className="cursor-pointer transition ease-out hover:scale-125"/>
      </div>
      <div className="flex flex-row w-1/4 items-center justify-center">
      <button className="text-2xl font-medium transition ease-out hover:scale-125">°C</button>
      <p className="text2xl font-medium mx-1">|</p>
      <button className="text-2xl font-medium transition ease-out hover:scale-125">°F</button>
      </div>
    </div>
  );
};

export default Inputs;