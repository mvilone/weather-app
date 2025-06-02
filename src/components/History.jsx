import React from 'react'
import { useEffect, useState } from 'react';

const History = ({weatherData}) => {
  const data = [1, 2, 3, 4, 5];
  const [pastDays, setPastDays] = useState([]);
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









  const fetchHistory = async () => {
      try{
        // Extract the key info
        //console.log("Forecast response:", JSON.stringify(weatherData, null, 2));
        console.log(getShortWeekday("2025-06-02", "Asia/Tokyo")); // should print "Tue"
        const pastFiveDays = weatherData.pastFiveDays
        const timeZone = weatherData.tz_id
        console.log("timeZone: ", timeZone);
        const pastDays = pastFiveDays.map(day => {
          const weekday = getShortWeekday(day.date, timeZone);
          return {
            weekday,
            maxtemp_c: day.maxtemp_c
          };
        });
        setPastDays(pastDays);
        console.log("Past Five Days", pastFiveDays);

      }
      catch (err){
        console.error("Error fetching data:", err.message);
      }
    };
    useEffect(() => {
      if(weatherData){
        fetchHistory(); //  call it on component load
      }
    }, [weatherData]);
  return (
    <div>
      <div className="flex items-center justify-start mt-6">
        <p className="font-medium uppercase">Past Five Days</p>
      </div>
      <hr className="my-1" />
      <div className="flex items-center justify-between">
        {pastDays.map((day, index) =>(
          <div key={index} 
          className="flex flex-col items-center justify-center">
            <p className="font-light text-sm">{day.weekday}</p>
            <img src="http://openweathermap.org/img/wn/01d@2x.png" 
            alt="weather icon"
            className="w-12 my-1"
            />
            <p className="font-medium">{Math.round(day.maxtemp_c)}°</p>
          </div>
        ))}
      </div>
    </div>
  )
}

export default History