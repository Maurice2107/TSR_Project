import React, {useContext, useEffect, useRef, useState} from 'react';
import {AuthContext} from "../context/AuthContext";
import { useNavigate} from "react-router-dom";

function SignIn(props) {
    const context = useContext(AuthContext);
    const emailRef = useRef("");
    const passwordRef = useRef("");
    const [errors, setErrors] = useState([]);
    let navigate = useNavigate();

    useEffect(()=>{
        window.document.body.classList.add("login");

    })

    async function handleSubmit(event){

        event.preventDefault();

        await context.signIn(emailRef.current.value, passwordRef.current.value);

        if(context.currentUser != null)
        {
            context.setErrors(null, false);
            navigate("/home");

        }
        else {
            setErrors(context.errors);
        }
    }
    return (
        <div className="container-fluid">
            <div className=" row justify-content-start">
                <div className="col-md-4 col-sm-10 p-0">
                    <div className="card bg-secondary bg-opacity-25  vh-100">
                        <div className="card-body text-white">
                            <h2 className="text-center mb-4">ShadeRoom News Login</h2>
                            {
                                errors && errors.length > 0 ?
                                    <div className="alert alert-danger">{errors[0].err.message}</div>
                                    :""
                            }

                            <form onSubmit={handleSubmit}>
                                <div className="form-group mb-3" id="email">
                                    <label>Email</label>
                                    <input className="form-control" type="email" required ref={emailRef}/>
                                </div>
                                <div className="form-group mb-3" id="password">
                                    <label>Password</label>
                                    <input className="form-control" type="password" required ref={passwordRef}/>
                                </div>
                                <button className="w-100 btn btn-outline-light" type="submit" >Sign In</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default SignIn;