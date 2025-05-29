import './App.css';
import React, {useState} from 'react';
import Login from './Login';
import Register from './Register';
import Content from './Content'; 
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import NavBar from './NavBar';


function App() {
  const [currentForm, setCurrentForm] = useState("login");
  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }
  let component
  switch (window.location.pathname) {
    case "/":
      component = <Login />
      break
    case "/login":
      component = <Login />
      break
    case "/register":
      component = <Register />
      break
    case "/content":
      component = <Content />
    }
  return (
    <>
      <NavBar />
      <div className='container'> {component} </div>
    </>
  );  
}

export default App;
