<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="./common/header.jsp" %>

<div class="row">
    <nav class=" col-12 navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="./index.jsp">Parking Manager</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <a class="btn btn-outline-success my-2 my-sm-0" href="login.jsp" role="button">Log In</a>
            </form>
        </div>
    </nav>
</div>
<hr>


<div class="row media">
    <img src="./img/palma.jpg" class="col-4 rounded" alt="...">
    <div class="media-body">
        <h5 class="mt-0">Nombreparking</h5>
        <p>info</p>
        <p>info</p>
        <p>info</p>
    </div>


    <p class="text-center h3">Ticket</p>

    <form class="d-flex justify-content-center">
        <div class="form-group">
            <label for="matricula">Matricula</label>
            <input type="text" class="form-control" id="matricula" name="matricula" placeholder="0000XYZ">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="descompte" id="nodescompte" value="nodescompte"
                       checked>
                <label class="form-check-label" for="nodescompte">
                    Sense descompte aplicable
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="descompte" id="places" value="places">
                <label class="form-check-label" for="places">
                    Totes les plaçes ocupades -5%
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="descompte" id="electric" value="electric">
                <label class="form-check-label" for="electric">
                    Vehicle eléctric -10%
                </label>
            </div>
        </div>
    </form>
</div>
<%@include file="./common/footer.jsp" %>