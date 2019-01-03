$(window).load(function () {


    $('#print').on("click", function () {
        var type = "pdf",jasperName = "test1",nickName = "第er";
        window.location.href = "/user/print?type=" + type
            + "&jasperName=" + jasperName
            + "&nickName=" + nickName;
    });


    $("#button1").on("click",function () {
        messengerModal("up_right","flat");

        var i = 0;
        Messenger().run({
            errorMessage: 'Error destroying alien planet',
            successMessage: 'Alien planet destroyed!',
            action: function(opts) {
                if (++i < 3) {
                    return opts.error({
                        status: 500,
                        readyState: 0,
                        responseText: 0
                    });
                } else {
                    return opts.success();
                }
            }
        });
    });

});

