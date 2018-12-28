$(window).load(function () {

    $('#print').on("click", function () {
        var type = "pdf",jasperName = "test1",nickName = "第er";
        window.location.href = "/user/print?type=" + type
            + "&jasperName=" + jasperName
            + "&nickName=" + nickName;
    });
});