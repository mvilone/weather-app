import './App.css';
import TopButtons from "./TopButtons";
import Inputs from "./Inputs";
import TimeAndLocation from "./TimeAndLocation";
import Details from "./Details";
import Forecast from "./Forecast";
import Login from "./Login";
import Register from "./Register";
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';

function App() {
  return (
    <Router basename="/mvilone/weather-ap">
      <div className="app-container">
        <nav className="navbar">
          <div className="nav-title">The Weather App</div>
          <div className="nav-links">
            <Link to="/content">Content</Link>
            <Link to="/login">Login</Link>
            <Link to="/register">Register</Link>
          </div>
        </nav>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/content" element={
            <div className="main-container">
              <TopButtons />
              <Inputs />
              <TimeAndLocation />
              <Details />
              <Forecast title="Hourly Forecast" />
              <Forecast title="Daily Forecast" />
            </div>
          } />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
