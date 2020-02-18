<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./common/header.jsp" %>

<div class="row my-5">
    <div class="col-12 bg-light p-2 rounded">
        <h3 class="text-center text-secondary">EDITAR CLIENTE</h3>
        <form name="frm-client" action="${pageContext.request.contextPath}/client" method="POST" class="was-validated">
            <input id="input-action" type="hidden" name="action" value="update"/>
            <input type="hidden" name="idUsuario" value="${usuario.id}"/>
            <div class="form-row">
                <div class="form-group col-6">
                    <label for="nom">Nombre(usuario)</label>
                    <input type="text" class="form-control" name="nom" id="nom"
                           placeholder="nombre" value="${usuario.nom}" required>
                </div>
                <div class="form-group col-6">
                    <label for="llinatges">Apellidos</label>
                    <input type="text" class="form-control" name="llinatges" id="llinatges" value="${usuario.llinatges}"
                           required>
                </div>
                <div class="form-group col-6">
                    <label for="contrasenya">Contraseña</label>
                    <input type="password" class="form-control" name="contrasenya" id="contrasenya"
                           required>
                </div>
                <c:forEach var="vehicle" items="${usuario.vehicles}" varStatus="status">
                    <div class="form-group col-6">
                        <label for="matricula1">Matricula ${status.count}</label>
                        <input type="text" class="form-control" id="matricula1" name="matricula"
                               placeholder="0000XYZ" value="${vehicle.matricula}">
                    </div>
                </c:forEach>
            <div class="d-flex flex-row-reverse">
                <button id="btn-delete" class="btn btn-danger ml-3">Eliminar cliente</button>
                <button type="submit" class="btn btn-secondary">Modificar cliente</button>
            </div>
        </form>

    </div>
</div>


<script src="js/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="js/index.js"></script>
<script type="text/javascript">
    let btnDelete = document.getElementById("btn-delete");
    btnDelete.onclick = function(){
        document.getElementById("input-action").value ="delete";
        document.forms["frm-client"].submit();
    }
</script>
</body>
</html>