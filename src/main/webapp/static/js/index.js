let content = document.getElementById('cards');

function getParkings() {
    fetch('data/parkings.json')
        .then(result => result.json())
        .then(data => {
            console.log(data);
            printParkings(data);
    })
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
                        <li class="list-group-item">Horario: ${parking.horario}</li>
                        <li class="list-group-item">Precio: ${parking.precio} €/hora</li>
                        <li class="list-group-item">Tipo: ${parking.tipo}</li>
                    </ul>
                    <div class="card-body d-flex justify-content-center">
                        <button class="btn btn-primary">Comprar ticket</button>
                    </div>
                </div>
        `
    }
}

