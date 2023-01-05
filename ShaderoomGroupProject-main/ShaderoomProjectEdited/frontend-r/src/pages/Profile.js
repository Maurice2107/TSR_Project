import React, {useState} from 'react';
import Menu from "../components/Menu";
import $ from "jquery"

function Profile(props) {
    const [basicActive, setBasicActive] = useState('me');

    ;
    const handleBasicClick = (value) => {
        if (value === basicActive) {
            return;
        }

        setBasicActive(value)
    };
    return (
        <>
            <Menu />
            <div className="container mt-3">
                <div className="row">
                    <div className="col-2">
                        <nav className="nav nav-pills flex-column">
                            <a data-toggle="pill" className={basicActive === 'me' ? "nav-link active" : "nav-link"}  href="#me" onClick={() => handleBasicClick('me')} >About Us</a>
                            <a data-toggle="pill" className={basicActive === 'history' ? "nav-link active" : "nav-link"} href="#history" onClick={() => handleBasicClick('history')} >Contact Us</a>

                        </nav>
                    </div>
                    <div className="col tab-content">
                        <div id="me"   className={basicActive === 'me' ? 'tab-pane active' : "tab-pane fade in"}>
                            <h2 className="display-2">About ShadeRoom News</h2>
                            <p>The ShadeRoom News is A social media forum website that discusses news, gossip, and lifestyle for men and women ages 18 - 35.</p>
                        </div>
                        <div id="history" className={basicActive === 'history' ? 'tab-pane active' : "tab-pane fade in"}>
                            <h2 className="display-2">Contact Us</h2>
                            <form>
                                <div className="form-group mb-3" id="email">
                                    <label>Email</label>
                                    <input className="form-control" type="email" />
                                </div>
                                <div className="form-group mb-3" id="password">
                                    <label>Contact Number</label>
                                    <input className="form-control" type="password" />
                                </div>
                                <button className="w-100 btn btn-outline-light" type="submit" >Contact Us</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Profile;