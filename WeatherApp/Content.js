import React from 'react';
import UilReact from '@iconscout/react-unicons/icons/uil-react'
import TopButtons from './componenets/TopButtons';
import Inputs from './componenets/Inputs';
import TimeAndLocation from './componenets/TimeAndLocation';
import Details from './componenets/Details';
import Forecast from './componenets/Forecast';

function Content() {
  return (
    <div className="mx-auto max-w-screen-md mt-4 py-5 px-32 bg-gradient-to-br from-cyan-200 to-blue-700 h-fit shadow-xl
    shadow-gray-400">
      <TopButtons />
      <Inputs />

      <TimeAndLocation />
      <Details />

      <Forecast title = "Hourly Forecast" />
      <Forecast title = "Daily Forecast" />
    </div>
  );
  
}

export default Content;
