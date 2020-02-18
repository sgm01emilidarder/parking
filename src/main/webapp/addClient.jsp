<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="addClientModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
            </div>

            <form action="${pageContext.request.contextPath}/client?action=insert" method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-row">
                        <div class="form-group col-6">
                            <label for="nom">Nombre(usuario)</label>
                            <input type="text" class="form-control" name="nom" id="nom"
                                   placeholder="nombre" required>
                        </div>
                        <div class="form-group col-6">
                            <label for="llinatges">Apellidos</label>
                            <input type="text" class="form-control" name="llinatges" id="llinatges"
                                   required>
                        </div>
                        <div class="form-group col-6">
                            <label for="contrasenya">Contraseña</label>
                            <input type="password" class="form-control" name="contrasenya" id="contrasenya"
                                    required>
                        </div>
                        <div class="form-group col-6">
                            <label for="matricula1">Matricula 1</label>
                            <input type="text" class="form-control" id="matricula1" name="matricula"
                                   placeholder="0000XYZ" required>
                        </div>
                        <div class="form-group col-6">
                            <label for="matricula2">Matricula 2</label>
                            <input type="text" class="form-control" id="matricula2" name="matricula2"
                                   placeholder="0000XYZ">
                        </div>
                        <div class="form-group col-6">
                            <label for="matricula3">Matricula 3</label>
                            <input type="text" class="form-control" id="matricula3" name="matricula3"
                                   placeholder="0000XYZ">
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