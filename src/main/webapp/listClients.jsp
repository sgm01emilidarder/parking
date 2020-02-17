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
                        <th>Nom</th>
                        <th>Llinatges</th>
                        <th>Username</th>
                        <th>Matricula 1</th>
                        <th>Matricula 2</th>
                        <th>Matricula 3</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="usuario" items="${usuarios}" varStatus="status">
                        <tr>
                            <td>${usuario.nom}</td>
                            <td>${usuario.llinatges}</td>
                            <td>${usuario.usuari}</td>
                            <td>${usuario.nom}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/usuario?action=edit&idUsuario=${usuario.id}"
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