$(function () {
    $(".head ul>li").hover(function () {
        var a = $(this).children().length;
        if (a != 1) {
            $(this).children("div").stop().slideToggle(200).end().siblings().children("div").hide()
        } else {
            $(this).children("div").hide()
        }
    });
    $("a.er1").mouseover(function () {
        $(this).siblings("p").slideDown(100)
    }).mouseout(function () {
        $(this).siblings("p").slideUp(100)
    });
    $(".gotop a").hover(function () {
        var a = $(this).hasClass("dh");
        if (a == true) {
            $(this).find("dt").hide().siblings("dd").fadeIn().parents("a").siblings("p").show().animate({left: "-110px"})
        } else {
            $(this).find("dt").hide().siblings("dd").fadeIn().parents("a").siblings("p").hide().animate({left: "-130px"})
        }
    }, function () {
        $(this).find("dt").fadeIn().siblings("dd").hide().parents("a").siblings("p").hide()
    });
    $(window).scroll(function () {
        var a = $(window).scrollTop();
        if (a > 100) {
            $(".toptop").fadeIn()
        } else {
            $(".toptop").fadeOut()
        }
        $(".toptop").click(function () {
            $(window).scrollTop(0)
        })
    });
    $("#login").click(function () {
        $(".login").show();
        $(".msk").show()
    });
    $("#reg").click(function () {
        $(".reg").show();
        $(".msk").show()
    });
    $(".off").click(function () {
        $(".login").hide();
        $(".reg").hide();
        $(".msk").hide()
    });
    $(".goReg").click(function () {
        $(".login").hide();
        $(".reg").show()
    });
    $(".goLogin").click(function () {
        $(".reg").hide();
        $(".login").show()
    })
});