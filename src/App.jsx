import Forecast from "./components/Forecast"
import Inputs from "./components/Inputs"
import TimeandLocation from "./components/TimeandLocation";
import TempAndDetails from "./components/TempAndDetails";
import TopButtons from "./components/TopButtons"
const App = () => {
  return (
    <div className="mx-auto max-w-screen-lg mt-4 py-5 px-32 bg-gradient-to-br
    shadow-xl shadow-gray-400 from-cyan-600 to-blue-700">
      <TopButtons />
      <Inputs />
      <TimeandLocation />
      <TempAndDetails />
      <Forecast />
      <Forecast />
    </div>
  )
};

export default App