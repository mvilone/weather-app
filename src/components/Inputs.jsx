import { useState, useEffect } from "react";
import {BiSearch, BiCurrentLocation} from "react-icons/bi";

const Inputs = ({setWeatherData}) => {
  console.log("Inputs component mounted");
  console.log("typeof setWeatherData:", typeof setWeatherData);
  const [city, setCity] = useState("");
  const handleSearchClick = async () => {
    console.log("city: ", city);
    try{
      let response;
      if(!city){
        response = await fetch("http://localhost:8080/city/getCity");
        console.log("1");
      }
      else{
        response = await fetch(`http://localhost:8080/city/getCity?name=${encodeURIComponent(city)}`);
        console.log("2");
      }
      if(!response.ok){
        throw new Error("Failed to fetch weather data");
      }
      const data = await response.json();
      console.log("Data:", JSON.stringify(data, null, 2));
      setWeatherData(data);
    }
    catch (err){
      console.error("Error fetching data:", err.message);
    }
  };
  
  useEffect(() => {
      if (!city) {
        handleSearchClick();
      }
  }, []); 

  return (
    <div className="flex flex-row justify-center my-6">
      <div className="flex flex-row w-3/4 items-center justify-center space-x-4">
        <input type="text" placeholder="search by city..." value={city} onChange={(e) => setCity(e.target.value)}
        className="bg-white text-black p-2 rounded-md w-full max-w-xs shadow-md focus:outline-none 
        text-xl font-light capitalize placeholder:lowercase" />
        <BiSearch size = {30} className="cursor-pointer transition ease-out hover:scale-125" onClick={handleSearchClick}/>
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