import TopButtons from './TopButtons';
import Inputs from './Inputs';
import TimeAndLocation from './TimeAndLocation';
import Details from './Details';
import Forecast from './Forecast';

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
