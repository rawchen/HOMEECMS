$(function () {
    $(window).scroll(function () {
        var a = $(window).scrollTop();
        if (a > 60) {
            $(".head").addClass("ding").css({background: "rgba(255,255,255," + a / 300 + ")"})
        } else {
            $(".head").removeClass("ding").css({background: "#fff"})
        }
    })
});