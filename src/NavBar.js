import React from 'react'
import {Link} from "react-router-dom"
 
function NavBar() {
  return (
    <ul>
        <li><Link to="/">Login</Link></li>
        <li><Link to="/Content">Content</Link></li>
        <li><Link to="/Register">Register</Link></li>

    </ul>
  )
}

export default NavBar