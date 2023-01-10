import React, {useEffect, useState} from 'react';
import $ from "jquery";
import Menu from "../components/Menu";
import axios from "axios";
import {Link, Navigate} from "react-router-dom";

function Home(props) {
    const [categories, setCategories] = useState([]);

    let firebaseResponse = localStorage.getItem("firebaseResponse");
    firebaseResponse = (firebaseResponse ? JSON.parse(firebaseResponse): "");

    useEffect(()=> {
        $("body").removeClass("login");
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
                                            <Link to="/category/business">
                                                <img src="https://hbr.org/resources/images/article_assets/2022/08/Hero-Image.png" className="card-img-top" />
                                            </Link>
                                            <p>
                                                <Link className="nav-link" to="/chat">Business Chat</Link>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                    <div className="col g-4" >
                        <div className="card"  >

                            <div className="card-body">
                                <Link to="/category/entertainment">
                                    <img src="https://d5zukw8vdn04n.cloudfront.net/wp-content/uploads/2020/10/shutterstock_1149399851.jpg" className="card-img-top" />
                                </Link>
                                <p>
                                    <Link className="nav-link" to="/chat">Entertainment Chat</Link>
                                </p>

                            </div>
                        </div>
                    </div>
                    <div className="col g-4" >
                        <div className="card"  >

                            <div className="card-body">
                                <Link to="/category/sports">
                                    <img src="https://media.springernature.com/w580h326/nature-cms/uploads/collections/Hero_image_1200x675_pixels_2-5273134ecbb5c94f78bbc87366502385.jpg" className="card-img-top" />
                                </Link>
                                <p>
                                    <Link className="nav-link" to="/chat">Sports Chat</Link>
                                </p>

                            </div>
                        </div>
                    </div>
                    <div className="col g-4" >
                        <div className="card"  >

                            <div className="card-body">
                                <Link to="/category/technology">
                                    <img src="https://www.state.gov/wp-content/uploads/2019/04/Science-Technology-shutterstock_449187505.jpg" className="card-img-top" />
                                </Link>
                                <p>
                                    <Link className="nav-link" to="/chat">Technology Chat</Link>
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
