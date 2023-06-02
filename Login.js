import React,{useState} from "react";
function Login () {
    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);

    }

    return (
        <form onSubmit={handleSubmit}>
            <label for="email">Email: </label>
            <input value = {email} type="email" placeholder="Enter your email here." id="email" name="email"/>
            <label for="password">Password: </label>
            <input value = {pass} type="password" placeholder="Enter your password here." id="password" name="password"/>
            <button type = "submit">Log In</button>
        </form>
    )
}

export default Login