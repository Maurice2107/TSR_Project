import React, {useEffect, useState} from 'react';
import Menu from "../components/Menu";
import {useParams} from "react-router-dom";
import axios from "axios";
import MenuCard from "../components/MenuCard";

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
                <h2 className="display-2">{name}</h2>
                <div className="row row-cols-lg-3 row-cols-sm-2">
                    {
                        items.map((item)=>{
                            return (<MenuCard item={item} isLunch={false} />)
                        })
                    }
                </div>
            </div>
        </>
    );
}

export default CategoryMenu;