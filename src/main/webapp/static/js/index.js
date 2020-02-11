function getParkings() {
    fetch('data/parkings.json')
        .then(result => result.json())
        .then(data => {
            console.log(data);
            printParkings(data);
    })
}

function printParkings(parkings) {
    for (let parking of parkings){
        console.log(parking);
    }
}

