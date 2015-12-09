/**
 * 这个文件是系统登录页面会引用的JS脚本文件，依赖于jQuery-1.11.x。 by.宋信强-不断完善
 */
$(function() {
    $("#uname").focus();
    // 用户在输完密码之后按下“Enter”键即发起身份验证，不用去鼠标点击“登录”
    $(window).keypress(function(event) {
        event = event.which;
        if (event == 13) {
            $("#login").click();
        }
    });
    $("#login").click(function() {
        showWaiting();
        var uname = $("#uname").val();
        var password = $("#password").val();
        if (uname == "" || password == "") {
            hideWaiting();
            alert(lan_input_uname_pwd);
            return;
        }
        $.post(content + "/system/login", {
            uname : uname,
            password : password
        }, function(data) {
            data = $.parseJSON(data);
            if (data.result) {
                window.location.href = content + "/system/index";
            } else {
                hideWaiting();
                alert(lan_login_fail);
            }
        });
    });
    $("select").val(_lan).change(function() {
        var lan = $(this).val();
        window.location.href = content + "/system/lan/" + lan;
    });
});

var fitSize = function() {
    var _height = $(window).height();
    var _width = $(window).width();
    var $input = $(".login_input_wrapper");
    var $head = $(".login_head");
    $input.css({
        "top" : _height * 0.25,
        "right" : _width * 0.15
    });
    $head.css("left", _width * 0.23);
}
