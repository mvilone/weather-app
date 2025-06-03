import React, { useEffect, useState } from 'react';

const HourlyC = ({ weatherData, tempType }) => {
  const [hourly, setHourly] = useState([]);

  const convertTo12HourFormat = (time24) => {
    const [hour, minute] = time24.split(':').map(Number);
    const ampm = hour >= 12 ? 'PM' : 'AM';
    const hour12 = hour % 12 === 0 ? 12 : hour % 12;
    return `${hour12}:${minute.toString().padStart(2, '0')} ${ampm}`;
  };

  const fetchHourlyC = async () => {
    try {
      if (weatherData?.currentweather?.currentDay?.twenty4Hours) {
        const hours = weatherData.currentweather.currentDay.twenty4Hours;

        const sortedHours = hours
          .map(hour => {
            const timePart = hour.time.split(' ')[1];
            const hourId = parseInt(timePart.split(':')[0], 10);
            return { ...hour, hour_id: hourId };
          })
          .sort((a, b) => a.hour_id - b.hour_id);

        const result = sortedHours.map(hour => {
          const timePart = hour.time.split(' ')[1];
          const formattedTime = convertTo12HourFormat(timePart);
          return {
            formattedTime,
            temp_c: hour.temp_c,
            temp_f: hour.temp_f,
          };
        });


        setHourly(result);
      }
    } catch (err) {
      console.error("Error fetching hourly data:", err.message);
    }
  };

  useEffect(() => {
    if (weatherData) fetchHourlyC();
  }, [weatherData, tempType]);

  return (
    <div className="mt-6">
      {/* Title */}
      <div className="flex items-center justify-start">
        <p className="text-white text-lg font-semibold uppercase">Today’s Weather (Hourly)</p>
      </div>
      <hr className="border-white opacity-30 my-2" />

      {/* Scrollable hourly content */}
      <div className="overflow-x-auto custom-scrollbar">
        <div className="flex gap-x-6 min-w-max pb-1">
          {hourly.map((hour, index) => (
            <div key={index} className="flex flex-col items-center text-white text-center min-w-[70px]">
              {/* Time */}
              <div className="text-base font-medium">
                {hour.formattedTime.split(':')[0]}:{hour.formattedTime.split(':')[1].split(' ')[0]}
              </div>

              {/* AM/PM */}
              <div className="text-sm mb-1">{hour.formattedTime.split(' ')[1]}</div>

              {/* Dot */}
              <div className="w-5 h-5 bg-orange-500 rounded-full mb-1" />

              {/* Temperature */}
              <div className="text-lg font-semibold">{Math.round(tempType === "F" ? hour.temp_f : hour.temp_c)}°</div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default HourlyC;
