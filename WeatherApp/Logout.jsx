import { initializeApp } from "https://www.gstatic.com/firebasejs/9.22.2/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.22.2/firebase-analytics.js";
import { getAuth, createUserWithEmailAndPassword, signInWithEmailAndPassword, signOut } from "https://www.gstatic.com/firebasejs/9.22.2/firebase-auth.js";
import React, { useState } from "react";
import { auth } from "/Users/lloydamaranto/Desktop/git/CS321-Group-5/WeatherApp/cs321/src/firebase.js";
const firebaseConfig = {
  apiKey: "<REMOVED>",
  authDomain: "weatherapp-bb11c.firebaseapp.com",
  databaseURL: "https://weatherapp-bb11c-default-rtdb.firebaseio.com",
  projectId: "weatherapp-bb11c",
  storageBucket: "weatherapp-bb11c.appspot.com",
  messagingSenderId: "770085319311",
  appId: "1:770085319311:web:e64c780a6619418f21b6fa",
  measurementId: "G-S452XRH8M6"
};

const Logout = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);
  const auth = getAuth();

  const logout = (e) => {
    e.preventDefault();
    signOut(auth)
      .then(() => {
        console.log('Sign-out successful.');
        alert('Sign-out successful.');
        document.getElementById('logout').style.display = 'block';
      })
      .catch((error) => {
        console.log('An error happened.');
      });
  };
  /*
   //----- Logout code start
    document.getElementById("logout").addEventListener("click", function() {
        signOut(auth).then(() => {
            // Sign-out successful.
            console.log('Sign-out successful.');
            alert('Sign-out successful.');
            document.getElementById('logout').style.display = 'none';
          }).catch((error) => {
            // An error happened.
            console.log('An error happened.');
          });
    });
    //----- End*/

  return (
    <div className="navbar-collapse collapse">
      <ul className="nav navbar-nav navbar-right">
        <li>
          <a href="#" id="logout" style={{ display: "none" }}>
            Log Out
          </a>
        </li>
      </ul>
    </div>

  );
};

export default Logout;