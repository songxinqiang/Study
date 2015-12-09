/**
 * 进行界面上的检查操作
 * by.宋信强-不断完善
 */
/**
 * 当前应用的访问根地址
 */
var hostPath = window.location.protocol + "//" + window.location.host;
/**
 * 去掉字符串开头和结尾的空格
 */
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

// 弹出框的默认宽度和高度
var default_width = 700;
var default_height = 500;
$(function() {
    // 编辑和添加的弹出页面点击“取消”
    $(".add_edit_cancel").click(function() {
        closeEditAddForm();
        hideWaiting();
    });
    // “全选”checkbox
    $(".list_checkall").click(function() {
        $(".list_checkbox").prop("checked", $(this).is(":checked"));
    });
    // 子复选框勾选情况对全选勾选框的影响
    $(".list_checkbox").click(function() {
        // 有一个没有选中则取消全选
        if (!this.checked) {
            $(".list_checkall").prop("checked", false);
            return;
        }
        // 选中的数目和总数目相等，加上全选
        var chsub = $(".list_checkbox").length;
        var checkedsub = $(".list_checkbox:checked").length;
        if (checkedsub == chsub) {
            $(".list_checkall").prop("checked", true);
        }
    });
    // 添加、编辑的混合多选操作
    $("#mu_add").click(function() {
        if (!$(".select_available option").is(":selected")) {
            alert(lan_select_item);
        } else {
            $(".select_available option:selected").appendTo(".select_chosen");
        }
    });
    $("#mu_remove").click(function() {
        if (!$(".select_chosen option").is(":selected")) {
            alert(lan_select_item);
        } else {
            $(".select_chosen option:selected").appendTo(".select_available");
        }
    });
    $(".select_available").dblclick(function() {
        $("option:selected", this).appendTo(".select_chosen");
    });
    $(".select_chosen").dblclick(function() {
        $("option:selected", this).appendTo(".select_available");
    });
    $(".trim_text").each(function() {
        var $item = $(this);
        trimText($item);
    });
});

// 过长文本的自动部分隐藏
var trimText = function($item, content) {
    var len = $item.attr("len");
    if (content == undefined) {
        var content = $item.text();
    }
    if (content.length > len) {
        $item.attr("title", content);
        $item.text(content.substring(0, len - 1) + "...");
    } else {
        $item.text(content);
    }
}

// 关闭“添加”和“编辑”的弹出框
var closeEditAddForm = function() {
    $("#close_add_edit", window.parent.document).click();
    showWaiting();
}

// 显示出添加和编辑的弹出显示框，根据指定的显示内容页面地址和窗口标题，指定的路径会加上当前页面控制器的前缀
var showEditAddForm = function(path, title) {
    // 路径添加前缀
    path = hostPath + content + ctl + path;
    // 设置页面路径和窗口标题
    $("#add_edit_iframe", window.parent.document).attr("src", path);
    $(".add_edit_title", window.parent.document).text(title);
    // 在窗口正式显示前先“等待”
    showWaiting();
    // 窗口尺寸
    if (typeof (size_width) != "undefined") {
        $(".add_edit_wrapper", window.parent.document).css("width", size_width);
    } else {
        $(".add_edit_wrapper", window.parent.document).css("width", default_width);
    }
    if (typeof (size_height) != "undefined") {
        $(".add_edit_wrapper", window.parent.document).css("height", size_height);
    } else {
        $(".add_edit_wrapper", window.parent.document).css("height", default_height);
    }
}

// 显示“等待”
var showWaiting = function() {
    $("#zzbg", window.parent.document).show();
    $("#wait_div", window.parent.document).show();
    $(".add_edit_wrapper", window.parent.document).hide();
}

// 隐藏“等待”
var hideWaiting = function() {
    $("#zzbg", window.parent.document).hide();
    $("#wait_div", window.parent.document).hide();
}

// 显示弹出窗口和“夹层”
var showPopup = function() {
    $("#zzbg", window.parent.document).show();
    $("#wait_div", window.parent.document).hide();
    $(".add_edit_wrapper", window.parent.document).show();
}

/*
 * 检测字符串是否是由数字构成的，只有在检测的字符串是数字并且在指定大小内的时候返回true
 */
var checkIsNumber = function(text, min, max) {
    var reg_number = /^\d+$/;
    if (reg_number.test(text)) {
        var number = Number(text);
        if (min != undefined && max != undefined) {
            return number >= min && number <= max;
        }
    }
    return false;
}

// 检查字符串是否符合IP的格式
var checkIP = function(ip) {
    var reg_ip = /^((\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.){3}(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
    return reg_ip.test(ip);
}

// 检查字符串是否符合网络掩码的格式
var checkNetmask = function(mask) {
    var mask_reg = /^(254|252|248|240|224|192|128|0)\.0\.0\.0|255\.(254|252|248|240|224|192|128|0)\.0\.0|255\.255\.(254|252|248|240|224|192|128|0)\.0|255\.255\.255\.(254|252|248|240|224|192|128|0)$/;
    return mask_reg.test(mask);
}

// 检查字符串是否符合MAC地址的格式
var checkMAC = function(mac) {
    var mac_reg = /^([A-Fa-f0-9]{2}:){5}[A-Fa-f0-9]{2}$/;
    return mac_reg.test(mac);
}
