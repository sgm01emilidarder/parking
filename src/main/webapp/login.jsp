<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="./common/header.jsp" %>


<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <h3 class="text-center text-secondary">AUTENTIFICACIÓN</h3>
                <div id="alertMessage" class="alert alert-danger d-none">Usuario o contraseña incorrectos</div>
                <form id="loginForm">
                    <div class="form-group">
                        <label for="user">Usuario</label>
                        <input type="text" name="userUsername" class="form-control" id="user" placeholder="usuario">
                    </div>
                    <div class="form-group">
                        <label for="pass">Contraseña</label>
                        <input type="password" name="userPass" class="form-control" id="pass" placeholder="contraseña">
                    </div>
                    <div class="col mb-4">
                        <button type="button" onclick="getUsers()" class="btn btn-success float-right">Iniciar sesion</button>
                        <small class="">¿No tienes una cuenta?, crea una <a href="./crearCompte.html">aquí</a>.</small>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="./common/footer.jsp" %>