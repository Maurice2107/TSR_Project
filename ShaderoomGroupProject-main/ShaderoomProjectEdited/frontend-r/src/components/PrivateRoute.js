import React, {useContext} from 'react';
import {AuthContext} from "../context/AuthContext";
import {Navigate} from "react-router-dom";

function PrivateRoute({children})
{
    const {currentUser, setCurrentUser} = useContext(AuthContext);
    if(currentUser.length == 0 && localStorage.getItem("user") != null)
        setCurrentUser(localStorage.getItem("user"))
    if(currentUser != null && currentUser.length > 0 )
        localStorage.setItem("user", JSON.stringify(currentUser));

    return currentUser ? children : <Navigate to="/home" replace={true} />

}
export default PrivateRoute;