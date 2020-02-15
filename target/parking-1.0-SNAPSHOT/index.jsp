<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="./common/header.jsp" %>

<div class="row mt-3">
    <c:forEach var="parking" items="${parkings}">
        <div class="card col-4" style="width: 18rem;">
            <img src="img/${parking.imatge}" class="imagen rounded mt-2" alt="...">
            <div class="card-body">
                <h5 class="card-title text-center">${parking.municipi}</h5>
                <p class="card-text text-center">${parking.direccio}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><b>Horario:</b> ${parking.horaInici}-${parking.horaFi}</li>
                <li class="list-group-item"><b>Precio:</b> ${parking.preuHora} €/hora</li>
                <li class="list-group-item"><b>Tipo:</b> ${parking.tipus}</li>
                <li class="list-group-item"><b>Plazas disponibles:</b> ${parking.numPlaces}</li>
            </ul>
            <div class="card-body d-flex justify-content-center">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/parking?idParking=${parking.id}">Reservar Plaza</a>
            </div>
        </div>
    </c:forEach>
</div>

<%@include file="./common/footer.jsp" %>