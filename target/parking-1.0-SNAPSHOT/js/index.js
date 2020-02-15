function calculatePrice(price){
    $("#precio").val((price * $("#tiempoReserva").val() * $("#descuentoAplicado").val()).toFixed(1));
}