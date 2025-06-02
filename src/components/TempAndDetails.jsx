import { FaThermometerEmpty } from "react-icons/fa"
import {BiSolidDropletHalf} from "react-icons/bi"
import {FiWind} from "react-icons/fi"
import { GiSunrise, GiSunset } from "react-icons/gi"
import { MdKeyboardArrowUp, MdKeyboardArrowDown } from "react-icons/md"
import { useEffect, useState } from 'react';
const TempAndDetails = ({weatherData, tempType}) => {
  const [temp, setTemp] = useState(null);
  const [feelsLike, setFeelsLike] = useState(null);
  const [humidity, setHumidity] = useState(null);
  const [wind, setWind] = useState(null);
  const [minTemp, setMinTemp] = useState(null);
  const [maxTemp, setMaxTemp] = useState(null);
  const [sunrise, setSunrise] = useState(null);
  const [sunset, setSunSet] = useState(null);
  const [speed_unit, setSpeedUnit] = useState(null);
  const fetchTimeAndDetails = async () => {
      try{
        // Extract the key info
        let temp;
        let feelsLike;
        let wind;
        if(tempType == "C"){
          temp = weatherData.currentweather?.current?.temp_c;
          feelsLike = weatherData.currentweather?.current?.feelslike_c;
          wind = weatherData.currentweather?.current?.wind_kph;
          setSpeedUnit("km/h");

        }
        else{
          temp = weatherData.currentweather?.current?.temp_f;
          feelsLike = weatherData.currentweather?.current?.feelslike_f;
          wind = weatherData.currentweather?.current?.wind_mph;
          setSpeedUnit("mph");
        }
        const humidity = weatherData.currentweather?.current?.humidity;
        const astro = weatherData?.currentweather?.currentDay?.astro;
        const sunrise = astro?.sunrise;
        const sunset = astro?.sunset;
        const twenty4Hours = weatherData?.currentweather?.currentDay?.twenty4Hours;
        if (twenty4Hours) {
          const temps = Object.values(twenty4Hours)
          .map(hour => tempType === "C" ? hour.temp_c : hour.temp_f)
          .filter(temp => typeof temp === 'number');
          const maxTemp = Math.max(...temps);
          const minTemp = Math.min(...temps);
          setMinTemp(minTemp);
          setMaxTemp(maxTemp);
          console.log("Max Temp (°C):", maxTemp);
          console.log("Min Temp (°C):", minTemp);
        }


        setTemp(temp);
        setFeelsLike(feelsLike);
        setHumidity(humidity);
        setWind(wind);
        setSunrise(sunrise);
        setSunSet(sunset);
        console.log("temp:", temp);
        console.log("Feels Like (°C):", feelsLike);
        console.log("Humidity (%):", humidity);
        console.log("Wind Speed (kph):", wind);

      }
      catch (err){
        console.error("Error fetching data:", err.message);
      }
    };
    useEffect(() => {
      if(weatherData){
        fetchTimeAndDetails(); // ✅ call it on component load
      }
    }, [weatherData, tempType]);
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
      value: wind !== null ? `${wind} ${speed_unit}` : "Loading..."
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
      value: maxTemp !== null ? `${maxTemp}°` : "Loading..."
    },
    {
      id:4,
      Icon: MdKeyboardArrowDown,
      title: "Low",
      value: minTemp !== null ? `${minTemp}°` : "Loading..."
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
        <p className="text-5xl">{temp !== null ? `${temp}°` : "Loading..."}</p>
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