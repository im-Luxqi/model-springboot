$(document).ready(function () {

    $("#photo").on("click",function () {
        $("#menuForm").attr("action","/user/dashboard")
        $("#menuForm").submit();
    });

    $("#canvas-text").on("click",function () {
        $("#menuForm").attr("action","/user/canvasText")
        $("#menuForm").submit();
    });

    $("#canvas-game-fiveChess").on("click",function () {
        $("#menuForm").attr("action","/user/canvasGameFiveChess")
        $("#menuForm").submit();
    });

    $("#canvas-game-tank").on("click",function () {
        $("#menuForm").attr("action","/user/canvasGameTank")
        $("#menuForm").submit();
    });
    $("#canvas-game-snake").on("click",function () {
        $("#menuForm").attr("action","/user/canvasGameSnake")
        $("#menuForm").submit();
    });

    $("#canvas-smallBall").on("click",function () {
        $("#menuForm").attr("action","/user/canvasSmallBall")
        $("#menuForm").submit();
    });

    $("#canvas-heart").on("click",function () {
        $("#menuForm").attr("action","/user/canvasHeart")
        $("#menuForm").submit();
    });

    $("#canvas-loveTime").on("click",function () {
        $("#menuForm").attr("action","/user/canvasLoveTime")
        $("#menuForm").submit();
    });

    $("#jasper").on("click",function () {
        $("#menuForm").attr("action","/user/jasper")
        $("#menuForm").submit();
    });

});