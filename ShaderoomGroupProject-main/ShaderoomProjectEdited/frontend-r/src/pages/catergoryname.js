import React, {useEffect, useState} from 'react';
import $ from "jquery";
import Menu from "../components/Menu";
import axios from "axios";
import {Link, Navigate, useParams} from "react-router-dom";
import "../App.css"

function Catergory(props) {
    const [categories, setCategories] = useState([]);
    const { catergoryname } = useParams()

    let firebaseResponse = localStorage.getItem("firebaseResponse");
    firebaseResponse = (firebaseResponse ? JSON.parse(firebaseResponse): "");

    useEffect(()=>{
        $("body").removeClass("login");
        //let headers = {"Authorization": "Bearer " + firebaseResponse.token}
        console.log("executed")
        axios.get("https://newsapi.org/v2/top-headlines?country=us&category="+catergoryname+"&apiKey=b6ab0e218d7b4f31a20894660e7af11e")
            .then((response) =>{
                // console.log(response);
                setCategories(response.data.articles);
            })
            .catch((err)=>{
                console.log(err);

            })
    },[])
    return (
        <>
            <Menu/>
            <div className="container">
                <h2 className="display-2">Select a Headline</h2>
                {
                    categories.map((category, i) => (

                        <div className="category" key={i}>
                            <img src={category.urlToImage}/>
                            <br/>
                            <p>{category.title}</p>
                            <p>{category.author}</p>
                            <p>{category.description}</p>
                            <a href={category.url}>Link to Article</a>
                            <hr/>

                        </div>


                    ))
                }
            </div>

        </>
    );
}

export default Catergory;
