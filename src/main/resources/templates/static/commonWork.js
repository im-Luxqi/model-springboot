$(window).load(function () {


    $('#print').on("click", function () {
        var type = "pdf",jasperName = "test1",nickName = "第er";
        window.location.href = "/user/print?type=" + type
            + "&jasperName=" + jasperName
            + "&nickName=" + nickName;
    });


    $("#button1").on("click",function () {
        messengerModal("up_right","ice");
     /*   var msg = "dasdasd";

        Messenger().post({
            message: msg,
            type: 'error',
            showCloseButton: true
        });*/
        var msg;
        msg = Messenger().post("My Message");
        msg.update("I changed my mind, this is my message");
        msg.hide();

    });

    $("#button2").on("click",function () {
        messengerModal("up_right","air");
        var msg = "dasdasd";

        Messenger().post({
            message: msg,
            type: 'error',
            showCloseButton: true
        });



    });
    $("#button3").on("click",function () {
        messengerModal("up_right","block");
        var msg = "dasdasd";

        Messenger().post({
            message: msg,
            type: 'error',
            showCloseButton: true
        });



    });

    $("#button4").on("click",function () {
        messengerModal("up_right","future");
        var msg = "dasdasd";

        Messenger().post({
            message: msg,
            type: 'error',
            showCloseButton: true
        });



    });

    $("#button5").on("click",function () {
        messengerModal("up_right","flat");
        var msg = "dasdasd";

        Messenger().post({
            message: msg,
            type: 'error',
            showCloseButton: true
        });



    });

});

function showErrorMessage(msg){


}

function progressMessage(){
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
}

function showSuccess(msg){
    Messenger().post(msg);
}