<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
    <title>Parking Manager</title>
</head>
<body class="container">
<input type="hidden" id="pageContext" value="${pageContext.request.contextPath}">
<div class="row">
    <nav class=" col-12 navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Parking Manager</a>
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

            <form class="form-inline my-2 my-lg-0" onsubmit="return false">
                <input class="form-control mr-sm-2" type="search" id="cerca" name="cerca" placeholder="Cerca" aria-label="Cerca">
                <button class="btn btn-outline-primary my-2 my-sm-0" onclick="cercar(cerca.value)" type="button">Cercar</button>
            </form>
            <c:if test="${user.nom==null}">
                <span id="login"><button class="btn btn-outline-success m-2 my-2 my-sm-0" data-toggle="modal" data-target="#loginModal">Log In</button></span>
            </c:if>
            <c:if test="${user!=null}">
                <div class="btn-group">
                    <button class="btn btn-outline-success m-2 my-2 my-sm-0" id="dropdownMenuButton" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false"><c:out value="${user.nom}"/> <i
                            class="fas fa-user"></i></button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item " <%--href="${pageContext.request.contextPath}/reserva?action=list&idCustomer=${usuari.id}"--%>>Mis reservas</a>
                        <form action="${pageContext.request.contextPath}/client?action=close" method="POST">
                            <button type="submit" class="dropdown-item text-danger">Cerrar Sesion</button>
                        </form>
                    </div>
                </div>
            </c:if>

        </div>
    </nav>
</div>