import React, {useContext} from 'react';
import {AuthContext} from "../context/AuthContext";
import {Navigate} from "react-router-dom";

function PrivateRoute({children})
{
    const {currentUser} = useContext(AuthContext);
console.log(currentUser)
    if(currentUser != null && currentUser.length > 0 )
        localStorage.setItem("user", JSON.stringify(currentUser));

    return currentUser && currentUser.length > 0 ? children : <Navigate to="/login" replace={true} />

}
export default PrivateRoute;