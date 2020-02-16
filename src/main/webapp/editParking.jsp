<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./common/header.jsp" %>

<div class="row my-5">
    <div class="col-12 bg-light p-2 rounded">
        <h3 class="text-center text-secondary">EDITAR PARKING</h3>
        <form name="frm-parking" action="${pageContext.request.contextPath}/parking" method="POST" class="was-validated">
            <input id="input-action" type="hidden" name="action" value="update"/>
            <input type="hidden" name="idParking" value="${parking.id}"/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="municipi">Municipio</label>
                    <input type="text" class="form-control" name="municipi" id="municipi"
                           placeholder="municipio" value="${parking.municipi}"
                           required>
                </div>
                <div class="form-group col-md-6">
                    <label for="numPlaces">Numero de plazas</label>
                    <input type="number" class="form-control" name="numPlaces" id="numPlaces"
                           value="${parking.numPlaces}" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="direccio">Dirección</label>
                    <input type="text" class="form-control" name="direccio" id="direccio"
                           placeholder="direccion" value="${parking.direccio}"
                           required>
                </div>
                <div class="form-group col-md-6">
                    <label for="horaInici">Hora apertura</label>
                    <input type="time" class="form-control" name="horaInici" id="horaInici"
                            value="${parking.horaInici}"
                           required>
                </div>
                <div class="form-group col-md-6">
                    <label for="horaFi">Hora cierre</label>
                    <input type="time" class="form-control" name="horaFi" id="horaFi"
                           value="${parking.horaFi}"
                           required>
                </div>
                <div class="form-group col-md-6">
                    <label for="preuHora">Precio Hora</label>
                    <input type="number" class="form-control" name="preuHora" id="preuHora"
                           value="${parking.preuHora}" step="0.01" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="imatge">Imagen</label>
                    <input type="text" class="form-control" name="imatge" id="imatge"
                           value="${parking.imatge}" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="tipus">Tipo</label>
                    <select class="form-control"  name="tipus" id="tipus">
                        <option value="cubierto">cubierto</option>
                        <option value="asfaltado">asfaltado</option>
                        <option value="tierra">tierra</option>
                    </select>
                </div>
            </div>
            <div class="d-flex flex-row-reverse">
                <button id="btn-delete" class="btn btn-danger ml-3">Eliminar parking</button>
                <button type="submit" class="btn btn-secondary">Modificar parking</button>
            </div>
        </form>

    </div>
</div>

<hr>
<nav class="navbar navbar-light bg-light d-flex justify-content-center">
  <span class="navbar-text">
    Parking Manager©
  </span>
</nav>

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
        document.forms["frm-parking"].submit();
    }
</script>
</body>
</html>