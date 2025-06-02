import { FaThermometerEmpty } from "react-icons/fa"
import {BiSolidDropletHalf} from "react-icons/bi"
import {FiWind} from "react-icons/fi"
import { GiSunrise, GiSunset } from "react-icons/gi"
import { MdKeyboardArrowUp, MdKeyboardArrowDown } from "react-icons/md"
import { useEffect, useState } from 'react';
const TempAndDetails = ({weatherData}) => {
  const [tempC, setTempC] = useState(null);
  const [feelsLike, setFeelsLike] = useState(null);
  const [humidity, setHumidity] = useState(null);
  const [windKph, setWindKph] = useState(null);
  const [minTempC, setMinTempC] = useState(null);
  const [maxTempC, setMaxTempC] = useState(null);
  const [sunrise, setSunrise] = useState(null);
  const [sunset, setSunSet] = useState(null);
  const fetchTimeAndDetails = async () => {
      try{
        // Extract the key info
        const tempC = weatherData.currentweather?.current?.temp_c;
        const tempF = weatherData.currentweather?.current?.temp_f;
        const feelsLike = weatherData.currentweather?.current?.feelslike_c;
        const humidity = weatherData.currentweather?.current?.humidity;
        const windKph = weatherData.currentweather?.current?.wind_kph;
        const astro = weatherData?.currentweather?.currentDay?.astro;
        const sunrise = astro?.sunrise;
        const sunset = astro?.sunset;
        const twenty4Hours = weatherData?.currentweather?.currentDay?.twenty4Hours;
        if (twenty4Hours) {
          const temps = Object.values(twenty4Hours)
          .map(hour => hour.temp_c)
          .filter(temp => typeof temp === 'number');
          const maxTempC = Math.max(...temps);
          const minTempC = Math.min(...temps);
          setMinTempC(minTempC);
          setMaxTempC(maxTempC);
          console.log("Max Temp (°C):", maxTempC);
          console.log("Min Temp (°C):", minTempC);
        }


        setTempC(tempC);
        setFeelsLike(feelsLike);
        setHumidity(humidity);
        setWindKph(windKph);
        setSunrise(sunrise);
        setSunSet(sunset);
        console.log("tempC:", tempC);
        console.log("tempF:", tempF);
        console.log("Feels Like (°C):", feelsLike);
        console.log("Humidity (%):", humidity);
        console.log("Wind Speed (kph):", windKph);

      }
      catch (err){
        console.error("Error fetching data:", err.message);
      }
    };
    useEffect(() => {
      if(weatherData){
        fetchTimeAndDetails(); // ✅ call it on component load
      }
    }, [weatherData]);
  const verticalDetails = [
    {
      id:1,
      Icon: FaThermometerEmpty,
      title: "Real Feel",
      value: feelsLike !== null ? `${feelsLike}°` : "Loading..."
    },
    {
      id:2,
      Icon: BiSolidDropletHalf,
      title: "Humidity",
      value: humidity !== null ? `${humidity}%` : "Loading..."
    },
    {
      id:3,
      Icon: FiWind,
      title: "Wind",
      value: windKph !== null ? `${windKph} km/h` : "Loading..."
    }
  ];

  const horizontalDetails = [
    {
      id:1,
      Icon: GiSunrise,
      title: "Sunrise",
      value: sunrise !== null ? `${sunrise}` : "Loading..."
    },
    {
      id:2,
      Icon: GiSunset,
      title: "Sunset",
      value: sunset !== null ? `${sunset}` : "Loading..."
    },
    {
      id:3,
      Icon: MdKeyboardArrowUp,
      title: "High",
      value: maxTempC !== null ? `${maxTempC}°` : "Loading..."
    },
    {
      id:4,
      Icon: MdKeyboardArrowDown,
      title: "Low",
      value: minTempC !== null ? `${minTempC}°` : "Loading..."
    }
  ];

  return (
    <div>
      <div className="flex items-center justify-center py-6 text-xl text-cyan-300">
        <p>Rain</p>
      </div>
      <div className="flex flex-row items-center justify-between py-3">
        <img src="http://openweathermap.org/img/wn/01d@2x.png" 
        alt="weather icon"
        className="w-20"
        />
        <p className="text-5xl">{tempC !== null ? `${tempC}°` : "Loading..."}</p>
        <div className="flex flex-col space-y-3 items-start">
          {
            verticalDetails.map(({id, Icon, title, value}) => (
            <div key={id} className="flex font-light text-sm items-center justify-center">
              <Icon size={18} className="mr-1"/>
              {`${title}: `} <span className="font-medium ml-1">{value}</span>
              </div>

            ))
          }



        </div>
      </div>
      <div className="flex flex-row items-center justify-center space-x-10 text-sm py-3">
        {
          horizontalDetails.map(({id, Icon, title, value}) => (
            <div key = {id} className="flex flex-row items-center">
              <Icon size={30} />
              <p className="font-light ml-1">
                {`${title}: `} <span className="font-medium ml-1">{value}</span>
              </p>
            </div>
          ))
        }

      </div>



    </div>
  )
}

export default TempAndDetails