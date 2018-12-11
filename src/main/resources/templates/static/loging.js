$(document).ready(function() {

    //Iconic form validation sample
    $('#form_iconic_validation').validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: false,
        ignore: "",
        rules: {
            nickname: {
                minlength: 2,
                required: true
            },
            username: {
                required: true,
                email: true
            },
            password: {
                minlength: 6,
                required: true
            },
            confirmPassword: {
                minlength: 6,
                required: true,
                equalTo: "#password"
            },
            six:{
                required: true
            }
        },
        messages: {
            nickname: "请输入您的昵称",
            username: {
                required: "请输入用户名",
                minlength: "用户名必须为邮箱样式"
            },
            password: {
                required: "请输入密码",
                minlength: "密码长度不能小于 6 个字母"
            },
            confirmPassword: {
                required: "请输入密码",
                minlength: "密码长度不能小于 6 个字母",
                equalTo: "两次密码输入不一致"
            },
            six: "请选择您的性别",
        },

        invalidHandler: function (event, validator) {
            //display error alert on form submit
        },

        errorPlacement: function (error, element) { // render error placement for each input type
            var icon = $(element).parent('.input-with-icon').children('i');
            var parent = $(element).parent('.input-with-icon');
            icon.removeClass('fa fa-check').addClass('fa fa-exclamation');
            parent.removeClass('success-control').addClass('error-control');
        },

        highlight: function (element) { // hightlight error inputs
            var parent = $(element).parent();
            parent.removeClass('success-control').addClass('error-control');
        },

        unhighlight: function (element) { // revert the change done by hightlight

        },

        success: function (label, element) {
            var $error = $(element).closest("form").find(".validation_form");
            var icon = $(element).parent('.input-with-icon').children('i');
            var parent = $(element).parent('.input-with-icon');
            icon.removeClass("fa fa-exclamation").addClass('fa fa-check');
            parent.removeClass('error-control').addClass('success-control');

            // error.appendTo($error);
        },

        submitHandler: function (form) {
            form.submit();
            // $(form).ajaxSubmit();
        }

    });
    $('.select2', "#form_iconic_validation").change(function () {
        $('#form_iconic_validation').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
    });





});

