$(function () {
    $(".choice .default").click(function () {
        $(this).siblings("ul").toggle();
        $(this).toggleClass("on")
    });
    $(".choice .select li").click(function () {
        var c = $(this).text();
        $(".choice .default").text(c).removeClass("on");
        $(this).parent("ul").slideUp("fast")
    });
    $(".proList li").on("mouseenter", function () {
        var c = "";
        c = '<p class="quick">快速浏览</p>';
        $(this).css("border", "1px solid #000").append(c);
        $(".quick").on("click", function () {
            $(".mask").show();
            $(".proDets").show()
        });
        $(".btns .cart").click(function () {
            if ($(".categ p").hasClass("on")) {
                $(".proDets").hide();
                $(".mask").hide()
            }
        })
    });
    $(".proList li").on("mouseleave", function () {
        $(this).find("p").remove();
        $(this).css("border", "1px solid #fff")
    });
    $(".off").click(function () {
        $(".mask").hide();
        $(".proDets").hide();
        $(".pleaseC").hide()
    });
    $(".proIntro .smallImg p img").hover(function () {
        $(this).parents(".smallImg").find("span").remove();
        var d = $(this).position().left;
        var c = $(this).attr("alt");
        $(this).parent("p").addClass("on");
        $(this).parents(".smallImg").append("<span>" + c + "</span>");
        $(".smallImg").find("span").css("left", d)
    }, function () {
        $(this).parents(".smallImg").find("span").remove();
        $(this).parent("p").removeClass("on")
    });
    $(".proIntro .smallImg img").click(function () {
        var c = $(this).attr("data-src");
        $(this).parents(".proCon").find(".proImg").children(".det").attr("src", c).css({
            width: "580px",
            height: "580px"
        });
        $(this).parents(".proCon").find(".proImg").children(".list").attr("src", c).css({
            width: "360px",
            height: "360px"
        });
        $(this).parents(".smallImg").find("span").remove();
        $(this).parent("p").addClass("on").siblings().removeClass("on");
        $(this).off("mouseleave").parent("p").siblings().find("img").on("mouseleave", function () {
            $(this).parents(".smallImg").find("span").remove();
            $(this).parent("p").removeClass("on")
        })
    });
    $(".btns a").click(function () {
        if ($(".categ p").hasClass("on")) {
            if ($(this).children().hasClass("buy")) {
                $(this).attr("href", "order.html")
            }
            $(".proIntro").css("border", "none");
            $(".num .please").hide()
        } else {
            $(".proIntro").css("border", "1px solid #c10000");
            $(".num .please").show()
        }
    });
    $(".smallImg > img").mouseover(function () {
        $(this).css("border", "1px solid #c10000").siblings("img").css("border", "none");
        var c = $(this).attr("data-src");
        $(this).parent().siblings(".det").attr("src", c).css({width: "580px", height: "580px"});
        $(this).parent().siblings(".list").attr("src", c).css({width: "360px", height: "360px"})
    });
    $(".msgTit a").click(function () {
        var c = $(this).index();
        $(this).addClass("on").siblings().removeClass("on");
        $(".msgAll").children("div").eq(c).show().siblings().hide()
    });
    $(".addre").click(function () {
        $(this).addClass("on").siblings().removeClass("on")
    });
    $(".way img").click(function () {
        $(this).addClass("on").siblings().removeClass("on")
    });
    $(".dis span").click(function () {
        $(this).addClass("on").siblings().removeClass("on")
    });
    $(".addre").on("click", ".setDefault", function () {
        $(this).next().remove();
        $(this).parent("p").prev().append('<span class="default">[默认地址]</span>').parents(".addre").addClass("on").siblings().removeClass("on").find(".default").remove().end().find(".tit p").eq(1).prepend('<a href="#" class="setDefault">设为默认</a><span>|</span>');
        $(this).parent("p").prev().parents(".addre").prependTo(".addres");
        $(this).remove()
    });
    var a = $(".ok span").text();

    function b() {
        a--;
        $(".ok span").text(a);
        if (a == 0) {
            window.location.href = ("myorderq.html")
        }
    }

    setInterval(b, 1000);
    $(".next").click(function () {
        $(".two").show();
        $(".one").hide();
        $(".forCon ul li").eq(1).addClass("on").siblings("li").removeClass("on")
    })
});