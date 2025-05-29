import './App.css';
import Login from './Login';
import Register from './Register';
import Content from './Content';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import NavBar from './NavBar';

function App() {
  return (
    <Router basename="/mvilone/weather-ap">
      <div className="App">
        <NavBar />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/content" element={<Content />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
