import React from 'react';
import {Link} from "react-router-dom";

function Menu(props) {
    return (
        <nav className="navbar navbar-expand-lg navbar-light">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/home">
                    <img src="http://localhost:3000/img/logo.png" alt="" width="100" height="60"/>
                </Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                         <li className="nav-item"><Link className="nav-link" to="/menu">HOME</Link></li>
                        <li className="nav-item"><Link className="nav-link" to="/cart">CHAT</Link></li>
                        <li className="nav-item"><Link className="nav-link" to="/profile">ACCOUNT SETTING</Link></li>
                    </ul>
                </div>
            </div>

        </nav>
    );
}

export default Menu;
