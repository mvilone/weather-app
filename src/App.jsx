import { useState, useEffect } from "react";
import Forecast from "./components/Forecast";
import Inputs from "./components/Inputs";
import TimeAndLocation from "./components/TimeAndLocation";
import TempAndDetails from "./components/TempAndDetails";
import TopButtons from "./components/TopButtons";
import History from "./components/History";
import HourlyC from "./components/HourlyC";

const App = () => {
  const [weatherData, setWeatherData] = useState(null);
  const [tempType, setTempType] = useState("C");

  useEffect(() => {
    console.log("WeatherData updated:", weatherData);
  }, [weatherData]);

  const [city, setCity] = useState("");
  const handleSearchClick = async (cityName) => {
    const targetCity = cityName ?? city;
    console.log("city: ", city);
    console.log("city button", cityName);
    try{
      let response;
      if(!targetCity){
        response = await fetch("http://localhost:8080/city/getCity");
        console.log("1");
      }
      else{
        response = await fetch(`http://localhost:8080/city/getCity?name=${encodeURIComponent(targetCity)}`);
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

  return (
    <div className="mx-auto max-w-screen-lg mt-4 py-5 px-32 bg-gradient-to-br shadow-xl shadow-gray-400 from-cyan-600 to-blue-700">
      <TopButtons setCity={setCity} handleSearchClick={handleSearchClick} />
      <Inputs setCity={setCity} city={city} handleSearchClick={handleSearchClick} setWeatherData={setWeatherData} setTempType={setTempType}/>
      <TimeAndLocation weatherData={weatherData} />
      <TempAndDetails weatherData={weatherData} tempType={tempType}/>
      <HourlyC weatherData={weatherData} tempType={tempType}/>
      <History weatherData={weatherData} tempType={tempType}/>
      <Forecast weatherData={weatherData} tempType={tempType}/>
    </div>
  );
};

export default App;
