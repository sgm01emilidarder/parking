<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="./common/header.jsp" %>


<div class="row">
    <form class="mx-auto col-4">
        <div class="form-group">
            <label for="mail">Email</label>
            <input type="email" class="form-control" id="mail" name="mail">

            <label for="inputPassword1">Contrasenya</label>
            <input type="password" class="form-control" id="inputPassword1" name="contrasenya">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<a href="./registro.jsp">No tens compte?</a>

<%@include file="./common/footer.jsp" %>