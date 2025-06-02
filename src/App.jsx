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

  return (
    <div className="mx-auto max-w-screen-lg mt-4 py-5 px-32 bg-gradient-to-br shadow-xl shadow-gray-400 from-cyan-600 to-blue-700">
      <TopButtons />
      <Inputs setWeatherData={setWeatherData} setTempType={setTempType}/>
      <TimeAndLocation weatherData={weatherData} />
      <TempAndDetails weatherData={weatherData} tempType={tempType}/>
      <HourlyC weatherData={weatherData} tempType={tempType}/>
      <History weatherData={weatherData} tempType={tempType}/>
      <Forecast weatherData={weatherData} tempType={tempType}/>
    </div>
  );
};

export default App;
