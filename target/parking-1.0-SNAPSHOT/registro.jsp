<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="common/header.jsp"/>

<div class="row">
    <nav class=" col-12 navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">Parking Manager</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Link <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log In</button>
            </form>
        </div>
    </nav>
</div>
<hr>
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
            <label class="form-check-label" for="exampleCheck1">He llegit i accept els <a href="#">tèrmins i condicions.</a></label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<jsp:include page="common/footer.jsp"/>