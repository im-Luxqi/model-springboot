$(document).ready(function () {
    var ctx = "/big-world";
    console.log(ctx);
    $("#photo").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/dashboard")
        $("#menuForm").submit();
    });

    $("#canvas-text").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/canvasText")
        $("#menuForm").submit();
    });

    $("#canvas-game-fiveChess").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/canvasGameFiveChess")
        $("#menuForm").submit();
    });

    $("#canvas-game-tank").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/canvasGameTank")
        $("#menuForm").submit();
    });
    $("#canvas-game-snake").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/canvasGameSnake")
        $("#menuForm").submit();
    });

    $("#canvas-smallBall").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/canvasSmallBall")
        $("#menuForm").submit();
    });

    $("#canvas-heart").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/canvasHeart")
        $("#menuForm").submit();
    });

    $("#canvas-loveTime").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/canvasLoveTime")
        $("#menuForm").submit();
    });

    $("#commonWork").on("click",function () {
        $("#menuForm").attr("action",ctx+"/user/commonWork")
        $("#menuForm").submit();
    });

});