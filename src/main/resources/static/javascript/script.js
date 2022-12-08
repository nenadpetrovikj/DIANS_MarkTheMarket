$(document).ready(function () {
    // dialog pop-ups
    $("#hoursButton").click(function(){
        $("#dialog1").dialog("open");
        $("#dialog2").dialog("close");
        $("#page-mask").addClass("page-mask");
    });
    $("#dialog1").dialog({
        autoOpen: false,
        modal: true,
        width: 400,
        buttons: {
            close: function () {
                $("#page-mask").removeClass("page-mask");
                $("#dialog1").dialog("close");
            }
        }
    });
    $("#infoButton").click(function(){
        $("#dialog2").dialog("open");
        $("#dialog1").dialog("close");
        $("#page-mask").addClass("page-mask");
    });
    $("#dialog2").dialog({
        autoOpen: false,
        modal: true,
        width: 400,
        buttons: {
            close: function () {
                $("#page-mask").removeClass("page-mask");
                $("#dialog2").dialog("close");
            }
        }
    });

    // goToTop button
    mybutton = document.getElementById("myBtn");
    window.onscroll = function() {scrollFunction()};
    function scrollFunction() {
        if (document.body.scrollTop > 60 || document.documentElement.scrollTop > 60) {
            mybutton.style.display = "block";
        }
        else {
            mybutton.style.display = "none";
        }
    }
    $("#myBtn").click(function () {
        window.scrollTo({top: 0, behavior: 'smooth'});
    });
});