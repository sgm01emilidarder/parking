<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="addParkingModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Parking</h5>
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
            </div>

            <form action="${pageContext.request.contextPath}/parking?action=insert" method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-row">
                    <div class="form-group col-6">
                        <label for="municipi">Municipio</label>
                        <input type="text" class="form-control" name="municipi" id="municipi"
                               placeholder="municipio" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="numPlaces">Numero de plazas</label>
                        <input type="number" class="form-control" min="1" step="1" name="numPlaces" id="numPlaces" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="direccio">Dirección</label>
                        <input type="text" class="form-control" name="direccio" id="direccio"
                               placeholder="direccion" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="horaInici">Hora apertura</label>
                        <input type="time" class="form-control" name="horaInici" id="horaInici" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="horaFi">Hora cierre</label>
                        <input type="time" class="form-control" name="horaFi" id="horaFi" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="preuHora">Precio Hora</label>
                        <input type="number" class="form-control" name="preuHora" id="preuHora" step="0.01" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="imatge">Imagen</label>
                        <input type="text" class="form-control" name="imatge" id="imatge" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="tipus">Tipo</label>
                        <select class="form-control" name="tipus" id="tipus">
                            <option value="cubierto">cubierto</option>
                            <option value="asfaltado">asfaltado</option>
                            <option value="tierra">tierra</option>
                        </select>
                    </div>
                </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>