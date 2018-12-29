$(function () {
    var extraClasses = {
        up_left: "messenger-fixed messenger-on-top messenger-on-left",
        up_center: "messenger-fixed messenger-on-top",
        up_right: "messenger-fixed messenger-on-top messenger-on-right",
        down_left: "messenger-fixed messenger-on-bottom messenger-on-left",
        down_center: "messenger-fixed messenger-on-bottom",
        down_right: "messenger-fixed messenger-on-bottom messenger-on-right"
    };
    var theme = {
        ice: "ice",
        air: "air",
        block: "block",
        future: "future",
        flat: "flat"
    };

    window.messengerModal = function (exclass, theme) {
        var modal;
        switch (exclass) {
            case "up_left":
                modal = extraClasses.up_left;
                break;
            case "up_center":
                modal = extraClasses.up_center;
                break;
            case "up_right":
                modal = extraClasses.up_right;
                break;
            case "down_left":
                modal = extraClasses.down_left;
                break;
            case "down_center":
                modal = extraClasses.down_center;
                break;
            case "down_right":
                modal = extraClasses.down_right;
                break;
        }
        // console.log(modal);
        Messenger.options = {
            extraClasses: modal,
            theme: theme
        };
    }


});