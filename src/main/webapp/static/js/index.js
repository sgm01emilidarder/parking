let content = document.getElementById('cards');
let parkings;
let usuaris;

function getParkings() {
    fetch('data/parkings.json')
        .then(result => result.json())
        .then(data => {
            console.log(data);
            printParkings(data);
            putParkingsOnVariable(data);
        })
}

function putParkingsOnVariable(data) {
    parkings = data;
}

function printParkings(parkings) {
    content.innerHTML = '';
    for (let parking of parkings) {
        content.innerHTML += `
                <div class="card col-4" style="width: 18rem;">
                    <img src="../img/${parking.imagen}" class="imagen rounded mt-2" alt="..." >
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

function getParkingById(id) {
    localStorage.setItem("parking", JSON.stringify(parkings[id]));
}

function printParking() {
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
    if (nom !== "") {
        let filtreParkings = parkings.filter(function(e) {
            return e.municipio.toLowerCase().indexOf(nom.toLowerCase()) > -1;
        });
        printParkings(filtreParkings);
    } else{
        getParkings();
    }
}
function getUsers() {
    fetch('data/usuarios.json')
        .then(result => result.json())
        .then(data => {
            console.log(data);
            putUsersOnVariable(data);
            loginController();
        })
}

function putUsersOnVariable(users) {
    usuaris = users;
}

function loginController() {
    let content = document.getElementById('login');
    let user = document.getElementById('user').value;
    let pass = document.getElementById('pass').value;
    let filteredUser = usuaris.filter(e => e.usuario === user && e.password === pass);
    if (filteredUser.length){
        content.innerHTML = `
            <div class="dropdown">
                <button class="btn btn-outline-success m-2 my-2 my-sm-0" id="login" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${user}</button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Mis reservas</a>
                    <a class="dropdown-item text-danger" onclick="closeUserSession()" href="#">Cerrar sesión</a>
                 </div>
            </div>
        `
        $("#loginModal").modal('hide');
        localStorage.setItem("user", JSON.stringify(user));
    }
}

function checkConnectedUser(){
    let content = document.getElementById('login');
    let user;
    if (JSON.parse(localStorage.getItem("user"))){
        user = JSON.parse(localStorage.getItem("user"));
        content.innerHTML = `
        <div class="dropdown">
            <button class="btn btn-outline-success m-2 my-2 my-sm-0" id="login" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${user}</button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Mis reservas</a>
                <a class="dropdown-item text-danger" onclick="closeUserSession()" href="#">Cerrar sesión</a>
             </div>
        </div>
        `
    } else{
        content.innerHTML = `
            <button class="btn btn-outline-success m-2 my-2 my-sm-0" data-toggle="modal" data-target="#loginModal">Log In</button>
        `
    }
}

function closeUserSession(){
    localStorage. removeItem("user");
    checkConnectedUser();
    window.location.replace("index.html");
}

function checkConnectedUserForReserve(){
    if (!JSON.parse(localStorage.getItem("user"))){
        message("Es necesario iniciar sesión para reservar plaza");
    } else {
        document.getElementById('reserveForm').submit();
    }
}

function message(msg) {
    $("#modalMsg").html(msg);
    $("#myModal").modal("show");
};