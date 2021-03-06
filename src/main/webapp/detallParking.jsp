<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="./common/header.jsp" %>

<div class="row media mt-3">
    <img src="img/${parking.imatge}" id="imgParking" class="col-md-4 rounded img-fluid image " alt="...">
    <div id="infoParking" class="media-body col-md-3 mt-3">
        <h5 class="mt-0">${parking.municipi}</h5>
        <p>Direccion: ${parking.direccio}</p>
        <p>Plazas disponibles: ${parking.numPlaces} plazas</p>
        <p>Horario: ${parking.horaInici}-${parking.horaFi}</p>
        <p>Precio: ${parking.preuHora}€/hora</p>
    </div>


    <form id="reserveForm" class="d-flex justify-content-center col-md-5">
        <div class="form-group">
            <p class="text-center h3">Ticket</p>
            <label for="horaReserva">Elige a que hora quieres la reserva:</label>
            <input type="time" id="horaReserva" name="horaReserva" min="${parking.horaInici}" max="${parking.horaFi}" step="3600" required>
            <br>
            <label for="tiempoReserva">Elige cuantas horas quieres reservar:</label>
            <select name="tiempoReserva" onchange="calculatePrice(${parking.preuHora})" id="tiempoReserva">
                <option value="1" selected>1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">Reservar todo el dia</option>
            </select>
            <br>
            <label for="matricula">Matricula:</label>
            <input type="text" class="form-control" id="matricula" name="matricula" placeholder="0000XYZ">
            <br>
            <label for="descuentoAplicado">Descuento:</label>
            <select name="select" onchange="calculatePrice(${parking.preuHora})" id="descuentoAplicado">
                <option value="1" selected>Sin descuento</option>
                <option value="0.95">Todas las plazas ocupadas -5%</option>
                <option value="0.9">Vehículo electrico -10%</option>
            </select>
            <br>
            <label for="precio">Precio(€):</label>
            <input type="number" class="form-control euro" step="0.01" id="precio" name="precio" value="${parking.preuHora}" readonly>
            <br>
            <button type="button" class="btn btn-primary">Reservar plaza</button>
        </div>
    </form>
</div>

<%@include file="./login.jsp" %>

<%@include file="./common/footer.jsp" %>