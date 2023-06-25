// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.22.2/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.22.2/firebase-analytics.js";
import { getAuth, createUserWithEmailAndPassword, signInWithEmailAndPassword, signOut } from "https://www.gstatic.com/firebasejs/9.22.2/firebase-auth.js";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
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

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const auth = getAuth();