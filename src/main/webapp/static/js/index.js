let content = document.getElementById('cards');
let parkings;

function getParkings() {
    fetch('data/parkings.json')
        .then(result => result.json())
        .then(data => {
            console.log(data);
            printParkings(data);
            putParkingsOnVariable(data);
    })
}

function putParkingsOnVariable(data){
    parkings = data;
}

function printParkings(parkings) {
    content.innerHTML = '';
    for (let parking of parkings){
        content.innerHTML += `
                <div class="card col-4" style="width: 18rem;">
                    <img src="../img/${parking.imagen}" class="card-img-top imagen" alt="..." >
                    <div class="card-body">
                        <h5 class="card-title text-center">${parking.municipio}</h5>
                        <p class="card-text text-center">${parking.direccion}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Horario:</b> ${parking.horario}</li>
                        <li class="list-group-item"><b>Precio:</b> ${parking.precioHora} €/hora</li>
                        <li class="list-group-item"><b>Tipo:</b> ${parking.tipo}</li>
                    </ul>
                    <div class="card-body d-flex justify-content-center">
                        <a class="btn btn-primary" onclick="getParkingById(${parking.id})" href="detallParking.html">Comprar ticket</a>
                    </div>
                </div>
        `
    }
}

function getParkingById(id){
    localStorage.setItem("parking", JSON.stringify(parkings[id]));
}

function printParking(){
    let parking = JSON.parse(localStorage.getItem("parking"));
    let imgParking = document.getElementById('imgParking');
    imgParking.src = "../img/" + parking.imagen;

    let infoParking = document.getElementById('infoParking');
    infoParking.innerHTML = `
       <h5 class="mt-0">${parking.municipio}</h5>
        <p>Direccion: ${parking.direccion}</p>
        <p>Plazas disponibles: ${parking.numPlazas} plazas</p>
        <p>Horario: ${parking.horario}</p>
        <p>Precio: ${parking.precioHora}€/hora</p>
    `;
}

function cercar(nom) {
    let filtreParkings = parkings.filter(e => e.municipio.localeCompare(nom));
    printParkings(filtreParkings);
}