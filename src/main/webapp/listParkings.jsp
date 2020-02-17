<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./common/header.jsp" %>
<hr>
<section>
    <div class="container">
        <div class="row mb-3">
            <div class="col-md-4">
                <button data-toggle="modal" data-target="#addParkingModal" class="btn btn-secondary btn-block"
                >
                    <i class="fas fa-plus"></i> Agregar Parking
                </button>
            </div>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/parking?action=list" class="btn btn-secondary btn-block">
                    <i class="fas fa-eye"></i> Ver Parkings
                </a>
            </div>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/client?action=list" class="btn btn-secondary btn-block">
                    <i class="fas fa-eye"></i> Ver Clientes
                </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">

            <div class="card" id="productsContent">
                <div class="card-header">
                    <h4>Listado de Parkings</h4>
                </div>
                <table class="table table-striped">
                    <thead class="table-secondary">
                    <tr>
                        <th>Municipio</th>
                        <th>Plazas</th>
                        <th>Direccion</th>
                        <th>Horario</th>
                        <th>Precio</th>
                        <th>Imagen</th>
                        <th>Nombre imagen</th>
                        <th>Tipo</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="parking" items="${parkings}" varStatus="status">
                        <tr>
                            <td>${parking.municipi}</td>
                            <td>${parking.numPlaces}</td>
                            <td>${parking.direccio}</td>
                            <td>${parking.horaInici}-${parking.horaFi}</td>
                            <td>${parking.preuHora}</td>
                            <td><img src="img/${parking.imatge}" alt="" style="width: 3vw; height: 3vw"></td>
                            <td>${parking.imatge}</td>
                            <td>${parking.tipus}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/parking?action=edit&idParking=${parking.id}"
                                   class="btn btn-secondary">
                                    <i class="fas fa-angle-double-right"></i> Editar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</section>

<%@include file="./common/footer.jsp" %>