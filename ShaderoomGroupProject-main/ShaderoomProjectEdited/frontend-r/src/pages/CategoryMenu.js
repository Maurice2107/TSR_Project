import React, {useEffect, useState} from 'react';
import Menu from "../components/Menu";
import {useParams} from "react-router-dom";
import axios from "axios";
import MenuCard from "../components/MenuCard";
import "../App.css";

function CategoryMenu(props) {

    const {id} = useParams();
    const [name, setName] = useState("");
    const [items, setItems] = useState([]);

    let firebaseResponse = localStorage.getItem("firebaseResponse");
    firebaseResponse = (firebaseResponse ? JSON.parse(firebaseResponse): "");

    useEffect(()=>{
        let headers = {"Authorization": "Bearer " + firebaseResponse.token}
        axios.get("http://localhost:8080/api/menu/category/" + id, {headers: headers})
            .then((response)=>{
                setItems(response.data);
            }).catch(err => console.log(err))
        axios.get("http://localhost:8080/api/category/" + id , {headers: headers})
            .then(response => {
                setName(response.data.name);
            })
            .catch(err => console.log(err))
    },[])


    return (
        <>
            <Menu />
            <div className="container">
                <h2 className="display-2">Chat Room</h2>
                <div className="row row-cols-lg-3 row-cols-sm-2">
                    {
                        items.map((item)=>{
                            return (<MenuCard item={item} isLunch={false} />)
                        })
                    }
                </div>
                <div className="chat">
                <div className="container">
                    <img src="https://media.licdn.com/dms/image/C5603AQELg9mdtS6HUw/profile-displayphoto-shrink_800_800/0/1663702118178?e=1677110400&v=beta&t=GNt_fFKSR-hOAdF4mRqP2FuYUuqNaJyo6qOoHFc0kEQ" alt="Avatar"/>
                        <p>Hello. How are you today? Have you caught up with today's headlines?</p>
                        <span className="time-right">11:00</span>
                </div>

                <div className="container darker">
                    <img src="https://media.licdn.com/dms/image/C5603AQEJcPSt9FntFQ/profile-displayphoto-shrink_800_800/0/1655087567162?e=2147483647&v=beta&t=9vrGQTLilEX-Af-hWXzSl6d5gg28pLau8fzwSwqm2jk" alt="Avatar" className="right"/>
                        <p>Hey! I'm fine. Thanks for asking, and Yes I have. These topics sure are very intriduging!</p>
                        <span className="time-left">11:01</span>
                </div>

                <div className="container">
                    <img src="https://media.licdn.com/dms/image/C5603AQELg9mdtS6HUw/profile-displayphoto-shrink_800_800/0/1663702118178?e=1677110400&v=beta&t=GNt_fFKSR-hOAdF4mRqP2FuYUuqNaJyo6qOoHFc0kEQ" alt="Avatar"/>
                        <p>Agreed! So, what's your viewpoint on the entertaiment headlines?</p>
                        <span className="time-right">11:02</span>
                </div>

                <div className="container darker">
                    <img src="https://media.licdn.com/dms/image/C5603AQEJcPSt9FntFQ/profile-displayphoto-shrink_800_800/0/1655087567162?e=2147483647&v=beta&t=9vrGQTLilEX-Af-hWXzSl6d5gg28pLau8fzwSwqm2jk" alt="Avatar" className="right"/>
                        <p>There's so many differet articles that my viewpoints are elsewhere!</p>
                        <span className="time-left">11:05</span>
                    <br/>
                </div>
                    <hr/>
                    <form action="/chat">
                    <textarea rows="4" cols="50" maxLength="50"> Type your reponse...</textarea>
                    </form>
                    <br/>
                    <button type="button">Send</button>
                    </div>

                </div>





        </>
    );
}

export default CategoryMenu;