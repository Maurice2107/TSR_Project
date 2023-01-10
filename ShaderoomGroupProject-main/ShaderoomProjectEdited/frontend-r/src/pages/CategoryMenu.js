import React, {useEffect, useState} from 'react';
import Menu from "../components/Menu";
import {useParams} from "react-router-dom";
import axios from "axios";
import MenuCard from "../components/MenuCard";
import "../App.css";

function CategoryMenu(props) {

    const {topic} = useParams();
    const [name, setName] = useState("");
    const [items, setItems] = useState([]);

    let firebaseResponse = localStorage.getItem("firebaseResponse");
    firebaseResponse = (firebaseResponse ? JSON.parse(firebaseResponse): "");

    useEffect(()=>{
        let headers = {"Authorization": "Bearer " + firebaseResponse.token}
       /* axios.get("http://localhost:8080/api/menu/category/" + id, {headers: headers})
            .then((response)=>{
                setItems(response.data);
            }).catch(err => console.log(err))*/
        axios.get("http://localhost:8080/api/chat/" + topic , {headers: headers})
            .then(response => {
                setItems(response.data);
            })
            .catch(err => console.log(err))
    },[])


    return (
        <>
            <Menu />
            <div className="container">
                <h2 className="display-2">Chat Room</h2>
                <div className="row row-cols-lg-3 row-cols-sm-2">
                    <div className="chat">
                    {
                        items.map((item, i)=>{
                            return (
                                <div className="item" key={i}>
                                <img src={item.author.image}/>
                            <br/>
                            <p>{item.title}</p>
                            <p>{item.createdAt}</p>
                            <p>{item.objectId}</p>
                            <p>{item.content}</p>
                                    </div>

                            )
                        })
                    }




                    <hr/>
                    <form action="/chat">
                    <textarea rows="4" cols="50" maxLength="50"> Type your reponse...</textarea>
                    </form>
                    <br/>
                    <button type="button">Send</button>


                </div>



            </div>
            </div>

        </>
    );
}

export default CategoryMenu;