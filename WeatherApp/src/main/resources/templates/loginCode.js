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

  //initialize firebase
  firebase.initializeApp(firebaseConfig);

  //reference database
  var loginDB = firebase.database().ref("CS321-firebase");

  document.getElementById('login').addEventListener('submit',submitForm);

  function submitForm(e){
    e.preventDefault();

    var emailid = getElementVal('emailid');
    var password = getElementVal('password');

    saveLogin(emailid, password)

    //enable alert
    document.querySelector(".alert").style.display = "block";

    //remove alert
    setTimeout(() => {
    document.querySelector(".alert").style.display = "none";
    }, 3000);

    //reset the form
    document.getElementById('login').reset();

  }

  const saveLogin = (emailid, password) => {
    var newLogin = loginDB.push();

    newLogin.set({
        emailid : emailid,
        password : password,
    });
  };

  const getElementVal = (id) => {
    return document.getElementById(id).value;
  }