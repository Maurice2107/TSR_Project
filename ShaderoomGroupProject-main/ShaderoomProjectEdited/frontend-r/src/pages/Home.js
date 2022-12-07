import React, {useEffect, useState} from 'react';
import $ from "jquery";
import Menu from "../components/Menu";
import axios from "axios";
import {Link, Navigate} from "react-router-dom";

function Home(props) {
    const [categories, setCategories] = useState([]);

    let firebaseResponse = localStorage.getItem("firebaseResponse");
    firebaseResponse = (firebaseResponse ? JSON.parse(firebaseResponse): "");

    useEffect(()=>{
        $("body").removeClass("login");
        let headers = {"Authorization": "Bearer " + firebaseResponse.token}
        /*axios.get("http://localhost:8080/api/category/",{headers: headers})
            .then((response) =>{
                // console.log(response);
                setCategories(response.data);
            })
            .catch((err)=>{
                console.log(err);

            })*/
    },[])
    return (
        <>
            <Menu/>
            <div className="container">
                <div className="row row-cols-lg-4 row-cols-sm-2">



                                <div className="col g-4" >
                                    <div className="card"  >
                                        <img src="https://via.placeholder.com/150" className="card-img-top" />
                                        <div className="card-body">
                                            <p className="card-text">hello</p>
                                                <h6 className="title" style={{textAlign:"center", margin: "20px"}}> My
                                                    Title
                                                </h6>

                                        </div>
                                    </div>
                                </div>

                </div>
            </div>

        </>
    );
}

export default Home;