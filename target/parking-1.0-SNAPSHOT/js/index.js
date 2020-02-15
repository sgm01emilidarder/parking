function calculatePrice(price){
    $("#precio").val((price * $("#tiempoReserva").val() * $("#descuentoAplicado").val()).toFixed(1));
}

function checkUser(){
    let pageContext = document.getElementById("loginForm");
    let username = document.getElementById('user').value;
    let password = document.getElementById('pass').value;
    $.ajax({
        type : "POST",
        url : pageContext + "/client?action=login&userUsername=" + username +"&userPass=" + password,
        timeout : 100000,
        success : function() {
            console.log("SUCCESS: ");
            document.getElementById('loginForm').submit();
        },
        error : function(e) {
            console.log("ERROR: ", e);
            document.getElementById('alertMessage').className="alert alert-danger";
        },
        done : function() {
            console.log("DONE");
        }
    });
}
