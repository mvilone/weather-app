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
const SignUp = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);

  const auth = getAuth();

  const signUp = (e) => {
    e.preventDefault();
    createUserWithEmailAndPassword(auth, email, password)
      .then((userCredential) => {
        console.log(userCredential);
        alert("Registration successfully!!");
      })
      .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        console.log(error);
        alert(error);

      });
  };

  return (
    <div className="sign-in-container">
      <form onSubmit={signUp}>
        <h1>Create Account</h1>
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
        <button type="submit">Sign Up</button>
      </form>
    </div>
  );
};

export default SignUp;