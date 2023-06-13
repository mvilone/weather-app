import React from 'react'
import {Link} from "react-router-dom"
import "./styles.css"

 
function NavBar() {
  const path = window.location.pathname
  return <nav className='nav'>
    <a href="/" className = "site-title">The Weather App</a>
    <ul>
      <li>
        <a href = "/content">Content</a>
      </li>
      <li>
        <a href = "/login">Login</a>
      </li>
      <li>
        <a href = "/register">Register</a>
      </li>
    </ul>
  </nav> 
}

export default NavBar;