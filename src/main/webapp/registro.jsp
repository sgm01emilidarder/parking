<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="./common/header.jsp" %>


<div class="row">
    <form class="mx-auto col-4" action="${pageContext.request.contextPath}/client?action=create" method="POST">
        <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" required>

            <label for="llinatges">Llinatges</label>
            <input type="text" class="form-control" id="llinatges" name="llinatges" placeholder="Llinatges" required>

            <label for="matricula1">Matricula 1</label>
            <input type="text" class="form-control" id="matricula1" name="matricula" placeholder="0000XYZ" required>
            
            <label for="matricula2">Matricula 2</label>
            <input type="text" class="form-control" id="matricula2" name="matricula" placeholder="0000XYZ">

            <label for="matricula3">Matricula 3</label>
            <input type="text" class="form-control" id="matricula3" name="matricula" placeholder="0000XYZ">

            <label for="inputPassword1">Contrasenya</label>
            <input type="password" class="form-control" id="inputPassword1" name="contrasenya" required>
            <small id="passHelp" class="form-text text-muted">Repeteix la contrasenya.</small>
            <input type="password" class="form-control" id="inputPassword2" name="contrasenya" required>
        </div>

        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">He llegit i accept els <a href="#">tèrmins i
                condicions.</a></label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%@include file="./common/footer.jsp" %>