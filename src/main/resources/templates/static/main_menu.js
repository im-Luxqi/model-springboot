$(document).ready(function () {

    $("#photo").on("click",function () {
        $("#menuForm").attr("action","/user/dashboard2")
        $("#menuForm").submit();
    });

    $("#canvas-text").on("click",function () {
        $("#menuForm").attr("action","/user/canvasText")
        $("#menuForm").submit();
    });

});