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
const SignIn = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);
  const auth = getAuth();

  const signIn = (e) => {
    e.preventDefault();
    signInWithEmailAndPassword(auth, email, password)
      .then((userCredential) => {
        console.log(userCredential);
        alert(email +" Login successfully!!!");
        //document.getElementById('logout').style.display = 'block';
      })
      .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        console.log(error);
        alert(error);
      });
  };
  const logout = (e) => {
      e.preventDefault();
      signOut(auth).then(() => {

          console.log('Sign-out successful.');
          alert('Sign-out successful.');
          document.getElementById('logout').style.display = 'none';
        }).catch((error) => {
          console.log('An error happened.');
        });
    };

  return (
    <div className="sign-in-container">
      <form onSubmit={signIn}>
        <h1>Log In to your Account</h1>
        <input
          type="email"
          placeholder="Enter your email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        ></input>
        <input
          type="password"
          placeholder="Enter your password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        ></input>
        <button type="submit">Log In</button>
      </form>
       <form onSubmit = {logout}>
            <ul className="nav navbar-nav navbar-right">
                <li>
                  <a href="#" id="logout" style={{ display: "none" }}>
                    Log Out
                  </a>
                </li>
              </ul>
              <button type="submit">Logout </button>
          </form>


   </div>






  );
};

export default SignIn;