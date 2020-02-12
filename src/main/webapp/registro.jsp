<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="./common/header.jsp" %>


<div class="row">
    <form class="mx-auto col-4">
        <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" aria-describedby="emailHelp">

            <label for="llinatge1">Llinatge1</label>
            <input type="text" class="form-control" id="llinatge1" name="llinatge1" aria-describedby="emailHelp">

            <label for="llinatge2">Llinatge 2</label>
            <input type="text" class="form-control" id="llinatge2" name="llinatge2" aria-describedby="emailHelp">
        </div>
        <div class="form-group">
            <label for="inputEmail1">Email</label>
            <input type="email" class="form-control" id="inputEmail1" name="email" aria-describedby="emailHelp">

            <label for="inputPassword1">Contrasenya</label>
            <input type="password" class="form-control" id="inputPassword1" name="contrasenya">
            <small id="passHelp" class="form-text text-muted">Repeteix la contrasenya.</small>
            <input type="password" class="form-control" id="inputPassword2" name="contrasenya">
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