import React, {useState} from "react";

function Register () {
    const [email, setEmail] = useState();
    const [pass, setPass] = useState();
    const [name,setName] = useState();
    
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }

    return (
        <div className="auth-form-container">
            <form className = "register-form" onSubmit={handleSubmit}>
                <label htmlFor="name">Full Name</label>
                <input value={name} 
                    name="name" 
                    onChange={(e) => setName(e.target.value)} 
                    id = "name" 
                    placeholder="             Full Name"/>
                <label htmlFor="email">Email: </label>
                <input value = {email} 
                    type="email" 
                    onChange={(e) => setEmail(e.target.value)} 
                    placeholder="    Enter your email here." 
                    id="email" 
                    name="email"
                    />
                <label htmlFor="password">Password: </label>
                <input value = {pass} 
                    type="password" 
                    onChange={(e) => setPass(e.target.value)} 
                    placeholder="Enter your password here." 
                    id="password" 
                    name="password"/>
                <button type = "submit">Log In</button>
            </form>
        <buttonlr className = "Link=Button" onClick={() => this.props.onFormSwitch("login")}> Already have an account? Log In Here.</buttonlr>
        </div>
    )
}

export default Register