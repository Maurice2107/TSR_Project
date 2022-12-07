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
                            <a data-toggle="pill" className={basicActive === 'me' ? "nav-link active" : "nav-link"}  href="#me" onClick={() => handleBasicClick('me')} >About Me</a>
                            <a data-toggle="pill" className={basicActive === 'pay' ? "nav-link active" : "nav-link"}  href="#pay" onClick={() => handleBasicClick('pay')} >Payment Methods</a>
                            <a data-toggle="pill" className={basicActive === 'history' ? "nav-link active" : "nav-link"} href="#history" onClick={() => handleBasicClick('history')} >Order History</a>

                        </nav>
                    </div>
                    <div className="col tab-content">
                        <div id="me"   className={basicActive === 'me' ? 'tab-pane active' : "tab-pane fade in"}>
                            <h2 className="display-2">About Me</h2>
                        </div>
                        <div id="pay" className={basicActive === 'pay' ? 'tab-pane active' : "tab-pane fade in"}>
                            <h2 className="display-2">Payment Methods</h2>
                        </div>
                        <div id="history" className={basicActive === 'history' ? 'tab-pane active' : "tab-pane fade in"}>
                            <h2 className="display-2">Order History</h2>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Profile;