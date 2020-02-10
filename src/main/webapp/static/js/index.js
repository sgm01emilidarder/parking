function getParking() {
    fetch('data/parkings.json')
        .then(result => result.json())
        .then(data => {
        printParkings(data)
    })
}

function printParkings(parkings) {

}