<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="./common/header.jsp" %>


<div class="row media">
    <img src="./img/palma.jpg" class="col-4 rounded" alt="...">
    <div class="media-body">
        <h5 class="mt-0">Nombreparking</h5>
        <p>info</p>
        <p>info</p>
        <p>info</p>
    </div>


    <form class="d-flex justify-content-center col-5">
        <div class="form-group">
        <p class="text-center h3">Ticket</p>
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
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@include file="./common/footer.jsp" %>