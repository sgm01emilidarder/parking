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
                        <button class="btn btn-primary" href="detallParking.html" onclick="printParkingById(${parking.id})">Comprar ticket</button>
                    </div>
                </div>
        `
    }
}

function printParkingById(id){

}

