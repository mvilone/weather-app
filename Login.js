import React, {useState} from "react";


function Login () {
    const [email, setEmail] = useState();
    const [pass, setPass] = useState();
    

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }

    return (
        <div className="auth-form-container">
            <form className = "login-form" onSubmit={handleSubmit}>
                <label htmlFor="email">Email: </label>
                <input value = {email} 
                    type="email" 
                    placeholder="Enter your email here." 
                    onChange={(e) => setEmail(e.target.value)} 
                    id="email" n
                    ame="email"
                />
                <label htmlFor="password">Password: </label>
                <input value = {pass} 
                    type="password" 
                    onChange={(e) => setPass(e.target.value)} 
                    placeholder="Enter your password here." 
                    id="password" 
                    name="password"
                />
                <button type = "submit">Log In</button>
            </form>
            <buttonlr className = "Link=Button" onClick={() => this.props.onFormSwitch("register")}> Need to create an account? Register Here! </buttonlr>
        </div>
    )
}

export default Login;