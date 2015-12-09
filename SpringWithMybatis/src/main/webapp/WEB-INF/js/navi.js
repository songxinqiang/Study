/**
 * 这个文件是左边菜单导航会引用的JS脚本文件，依赖于jQuery-1.11.x。
 * 这个文件的代码在DOM树准备完成后执行，但是有可能会有部分页面资源（如图片）还没有准备好。<br>
 * by.宋信强-不断完善
 */
$(function() {
    // 不出现滚动条
    $("body").css("overflow", "hidden");
    // 菜单点击处理页面加载
    $(".menu").click(function() {
        showWaiting();
        $("#main_frame", window.parent.document).attr("src", content + $(this).attr("id"));
        $(".menu").removeClass("active_menu");
        $(this).addClass("active_menu");
    });
    $(".top_menu").click(function() {
        showWaiting();
        $("#menu_frame").attr("src", content + $(this).attr("id"));
        $("#main_frame").attr("src", content + $(this).attr("def"));
        $(".top_menu").removeClass("active_top_menu");
        $(this).addClass("active_top_menu");
    });
    // 应用生效
    $("#apply_btn").click(function() {
        showWaiting();
        $.getJSON(content + "/system/apply", function(json) {
            hideWaiting();
            $("#apply_btn").hide();
            setCheckJob();
        });
    });

    // 弹出框的关闭
    $("#close_add_edit").click(function() {
        $(".add_edit_wrapper").hide();
        $("#zzbg").hide();
    });

    // 左边菜单和右边日志的隐藏和显示
    $(".top_main_navi_hide_btn").click(function() {
        $(".top_main_navi").hide();
        $(".top_main_navi_show_btn").show();
        $(window).resize();
    });
    $(".top_main_log_hide_btn").click(function() {
        $(".top_main_log").hide();
        $(".top_main_log_show_btn").show();
        $(window).resize();
    });
    $(".top_main_navi_show_btn").click(function() {
        $(".top_main_navi").show();
        $(".top_main_navi_show_btn").hide();
        $(window).resize();
    });
    $(".top_main_log_show_btn").click(function() {
        $(".top_main_log").show();
        $(".top_main_log_show_btn").hide();
        $(window).resize();
    });
});

/**
 * 用户浏览器窗口尺寸变化时自适应 高度：顶部logo：63，顶部导航：38，底部版权：38，“向左边收起”：52
 * 宽度：左边菜单：140，右边日志：240，左右两边的“显示”按钮22（左右各有），中间iframe的边框2（左右两边均有，就是4）
 * 宽度要根据菜单和日志的是否显示来计算宽度
 */
var fitSize = function() {
    var mainHeight = $(window).height() - 63 - 38 - 38;
    var width_menu_log = 140 + 240;
    var width_menu = 140 + 22;
    var width_log = 22 + 240;
    var width_none = 22 + 22;
    $("#main_frame").width(function() {
        var wrapperWidth = 0;
        var menu = $(".top_main_navi").is(":hidden");
        var log = $(".top_main_log").is(":hidden");
        if (menu && log) {
            wrapperWidth = width_none;
        } else if (menu) {
            wrapperWidth = width_log;
        } else if (log) {
            wrapperWidth = width_menu;
        } else {
            wrapperWidth = width_menu_log;
        }
        return $(window).width() - wrapperWidth - 4;
    });
    $("#main_frame,.top_main").height(function() {
        return mainHeight;
    });
    $("iframe[name='menu_frame'],iframe[name='log_frame']").height(function() {
        return mainHeight - 52;
    });
}

// 查询是否需要点击“应用”按钮
var _job_id;
var setCheckJob = function() {
    _job_id = setInterval(function() {
        $.getJSON(content + "/system/checkapply", function(json) {
            shouldApply = json.result;
            if (shouldApply) {
                $("#apply_btn").css("display", "block");
                // 在“需要”点击按钮之后，就不需要继续查询了
                clearInterval(_job_id);
            } else {
                $("#apply_btn").css("display", "none");
            }
        });
    }, 2 * 1000);
}
