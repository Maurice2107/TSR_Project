import React from 'react';
import moment from "moment";


function getIsLunch(){
    let now = moment();
    let start = moment();
    start.set('hour', 10);
    start.set('minute',0);
    start.set('second',0);

    let end = moment();
    end.set('hour', 16);
    end.set('minute', 0);
    end.set('second',0);

    console.log(now.format('DD/MM/YYYY HH:mm:ss'))
    console.log(start.format('DD/MM/YYYY HH:mm:ss'))
    console.log(end.format('DD/MM/YYYY HH:mm:ss'))
    return now.isBetween(start, end, "minute",[]);
}

function MenuCard(props) {
    const item = props.item;
    const isLunch = getIsLunch();
    var formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',

        // These options are needed to round to whole numbers if that's what you want.
        //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
        //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
    });


    return (
        <div className="col g-4">
            <div className="card">
                <img src={item.image_url} className="card-img-top" height="300px" alt={item.name} />
                <div className="card-body">
                    <h5 className="card-title">{item.name}</h5>
                    <h6 className="card-subtitle">
                        {formatter.format(isLunch ? item.price.lunch  : item.price.dinner)} &nbsp; &nbsp;
                        {isLunch ? <span className="badge bg-danger">LUNCH SPECIAL</span> : ""}
                    </h6>
                    <p className="card-text">{item.description}</p>

                </div>
            </div>
        </div>
    );
}

export default MenuCard;