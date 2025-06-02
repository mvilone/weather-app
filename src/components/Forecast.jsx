import React from 'react'
import { useEffect, useState } from 'react';

const Forecast = ({weatherData}) => {
  const data = [1, 2, 3, 4, 5];
  const getShortWeekday = (dateString, timeZone) => {
    const formatter = new Intl.DateTimeFormat('en-US', {
      weekday: 'short',
      timeZone: timeZone,
    });

    // Interpret date as local time (NOT UTC)
    const localDateString = `${dateString}T00:00:00`;
    const date = new Date(localDateString);

    return formatter.format(date);
  };









  const fetchForecast = async () => {
      try{
        // Extract the key info
        //console.log("Forecast response:", JSON.stringify(weatherData, null, 2));
        console.log(getShortWeekday("2025-06-02", "Asia/Tokyo")); // should print "Tue"
        const futureFiveDays = weatherData.futureFiveDays
        const timeZone = weatherData.tz_id
        console.log("timeZone: ", timeZone);
        futureFiveDays.forEach(day => {
          const weekday = getShortWeekday(day.date, timeZone);
          console.log(`Day: ${weekday}, Max Temp: ${day.maxtemp_c}°C, Date: ${day.date}`);
        });
        console.log("Future Five Days", futureFiveDays);

      }
      catch (err){
        console.error("Error fetching data:", err.message);
      }
    };
    useEffect(() => {
      if(weatherData){
        fetchForecast(); //  call it on component load
      }
    }, [weatherData]);
  return (
    <div>
      <div className="flex items-center justify-start mt-6">
        <p className="font-medium uppercase">Five Day Forecast</p>
      </div>
      <hr className="my-1" />
      <div className="flex items-center justify-between">
        {data.map((data, index) =>(
          <div key={index} 
          className="flex flex-col items-center justify-center">
            <p className="font-light text-sm">Wed</p>
            <img src="http://openweathermap.org/img/wn/01d@2x.png" 
            alt="weather icon"
            className="w-12 my-1"
            />
            <p className="font-medium">12°</p>
          </div>
        ))}
      </div>
    </div>
  )
}

export default Forecast