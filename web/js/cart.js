$(function () {
    $(".num .sub").click(function () {
        var c = parseInt($(this).siblings("span").text());
        if (c <= 1) {
            $(this).attr("disabled", "disabled")
        } else {
            c--;
            $(this).siblings("span").text(c);
            
          //  alert($(this).siblings("span").attr('datasrc'));
            if( $(this).siblings("span").attr('datasrc')) {
            	var url = "cartshopnumadd?count="+c+"&esid="+$(this).siblings("span").attr('datasrc');
            	$.get(url, function(){});
            }
            var d = $(this).parents(".number").prev().text().substring(1);
            $(this).parents(".th").find(".sAll").text("￥" + (c * d).toFixed(2));
            a();
            b()
        }
    });
    $(".num .add").click(function () {
        var c = parseInt($(this).siblings("span").text());
        if (c >= 5) {
            confirm("限购5件")
        } else {
            c++;
            $(this).siblings("span").text(c);
            
            if( $(this).siblings("span").attr('datasrc')) {
            	var url = "cartshopnumadd?count="+c+"&esid="+$(this).siblings("span").attr('datasrc');
            	$.get(url, function(){});
            }
            
            var d = $(this).parents(".number").prev().text().substring(1);
            $(this).parents(".th").find(".sAll").text("￥" + (c * d).toFixed(2));
            a();
            b()
        }
    });

    function a() {
        var c = 0;
        var d = $(".th input[type='checkbox']:checked").length;
        if (d == 0) {
            $("#all").text("￥" + parseFloat(0).toFixed(2))
        } else {
            $(".th input[type='checkbox']:checked").each(function () {
                var e = $(this).parents(".pro").siblings(".sAll").text().substring(1);
                c += parseFloat(e);
                $("#all").text("￥" + c.toFixed(2))
            })
        }
    }

    function b() {
        var e = 0;
        var c = $(".th input[type='checkbox']:checked").parents(".th").find(".num span");
        var d = c.length;
        if (d == 0) {
            $("#sl").text(0)
        } else {
            c.each(function () {
                e += parseInt($(this).text());
                $("#sl").text(e)
            })
        }
        if ($("#sl").text() > 0) {
            $(".count").css("background", "#c10000")
        } else {
            $(".count").css("background", "#8e8e8e")
        }
    }

    $("input[type='checkbox']").on("click", function () {
        var f = $(this).is(":checked");
        var e = $(this).hasClass("checkAll");
        if (f) {
            if (e) {
                $("input[type='checkbox']").each(function () {
                    this.checked = true
                });
                b();
                a()
            } else {
                $(this).checked = true;
                var c = $("input[type='checkbox']:checked").length;
                var d = $("input").length - 1;
                if (c == d) {
                    $("input[type='checkbox']").each(function () {
                        this.checked = true
                    })
                }
                b();
                a()
            }
        } else {
            if (e) {
                $("input[type='checkbox']").each(function () {
                    this.checked = false
                });
                b();
                a()
            } else {
                $(this).checked = false;
                var c = $(".th input[type='checkbox']:checked").length;
                var d = $("input").length - 1;
                if (c < d) {
                    $(".checkAll").attr("checked", false)
                }
                b();
                a()
            }
        }
    });
    $(".btns .cart").click(function () {
        if ($(".categ p").hasClass("on")) {
            var c = parseInt($(".num span").text());
            var d = parseInt($(".goCart span").text());
            $(".goCart span").text(c + d)
        }
    });
    $(".del").click(function () {
        if ($(this).parent().parent().hasClass("th")) {
            $(".mask").show();
            $(".tipDel").show();
            
            var url = "cartshopdel?esid="+$(this).attr('datasrc');
            $.get(url, function(data){});
            
            
            index = $(this).parents(".th").index() - 1;
            $(".cer").click(function () {
                $(".mask").hide();
                $(".tipDel").hide();
                $(".th").eq(index).remove();
                $(".cer").off("click");
                if ($(".th").length == 0) {
                    $(".table .goOn").show()
                }
            })
        } else {
            if ($(".th input[type='checkbox']:checked").length == 0) {
                $(".mask").show();
                $(".pleaseC").show()
            } else {
                $(".mask").show();
                $(".tipDel").show();
                $(".cer").click(function () {
                    $(".th input[type='checkbox']:checked").each(function (c) {
                        index = $(this).parents(".th").index() - 1;
                        $(".th").eq(index).remove();
                        if ($(".th").length == 0) {
                            $(".table .goOn").show()
                        }
                    });
                    $(".mask").hide();
                    $(".tipDel").hide();
                    b();
                    a()
                })
            }
        }
    });
    $(".cancel").click(function () {
        $(".mask").hide();
        $(".tipDel").hide()
    })
});