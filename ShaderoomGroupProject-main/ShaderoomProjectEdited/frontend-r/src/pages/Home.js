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
                <h2 className="display-2">Select a Headline</h2>
                <div className="row row-cols-lg-4 row-cols-sm-2">



                                <div className="col g-4" >
                                    <div className="card"  >

                                        <div className="card-body">
                                            <a href="https://www.cnbc.com">
                                                <img src="https://thumbs.dreamstime.com/b/political-news-gold-d-words-dark-digital-background-41801097.jpg" className="card-img-top" />
                                            </a>
                                            <p>
                                                <Link className="nav-link" to="/chat">CLICK HERE TO CHAT</Link>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                    <div className="col g-4" >
                        <div className="card"  >

                            <div className="card-body">
                                <a href="https://www.etonline.com/news">
                                    <img src="https://deadline.com/wp-content/uploads/2019/08/e-news-logo-featured.jpg" className="card-img-top" />
                                </a>
                                <p>
                                    <Link className="nav-link" to="/chat">CLICK HERE TO CHAT</Link>
                                </p>

                            </div>
                        </div>
                    </div>
                    <div className="col g-4" >
                        <div className="card"  >

                            <div className="card-body">
                                <a href="https://timesofindia.indiatimes.com/world">
                                    <img src="https://thumbs.dreamstime.com/b/international-news-red-bubble-background-isolated-143222466.jpg" className="card-img-top" />
                                </a>
                                <p>
                                    <Link className="nav-link" to="/chat">CLICK HERE TO CHAT</Link>
                                </p>

                            </div>
                        </div>
                    </div>
                    <div className="col g-4" >
                        <div className="card"  >

                            <div className="card-body">
                                <a href="https://www.usnews.com/news/health-news">
                                    <img src="https://previews.123rf.com/images/iqoncept/iqoncept1705/iqoncept170500109/78287404-health-news-headlines-newspaper-information-3d-illustration.jpg" className="card-img-top" />
                                </a>
                                <p>
                                    <Link className="nav-link" to="/chat">CLICK HERE TO CHAT</Link>
                                </p>

                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </>
    );
}

export default Home;
