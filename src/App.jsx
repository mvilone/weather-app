import { useState, useEffect } from "react";
import Forecast from "./components/Forecast";
import Inputs from "./components/Inputs";
import TimeAndLocation from "./components/TimeAndLocation";
import TempAndDetails from "./components/TempAndDetails";
import TopButtons from "./components/TopButtons";
import History from "./components/History";

const App = () => {
  const [weatherData, setWeatherData] = useState(null);

  useEffect(() => {
    console.log("WeatherData updated:", weatherData);
  }, [weatherData]);

  return (
    <div className="mx-auto max-w-screen-lg mt-4 py-5 px-32 bg-gradient-to-br shadow-xl shadow-gray-400 from-cyan-600 to-blue-700">
      <TopButtons />
      <Inputs setWeatherData={setWeatherData} />
      <TimeAndLocation weatherData={weatherData} />
      <TempAndDetails weatherData={weatherData} />
      <Forecast weatherData={weatherData} />
      <History weatherData={weatherData} />
      <Forecast weatherData={weatherData} />
    </div>
  );
};

export default App;
