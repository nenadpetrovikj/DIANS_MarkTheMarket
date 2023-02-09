$(document).ready(function () {
    $(".generatedResult button").click(function () {
        $(this).next("div").slideToggle();
    })
    // goToTop button
    mybutton = document.getElementById("myBtn");
    window.onscroll = function () {
        scrollFunction()
    };

    function scrollFunction() {
        if (document.body.scrollTop > 60 || document.documentElement.scrollTop > 60) {
            mybutton.style.display = "block";
        } else {
            mybutton.style.display = "none";
        }
    }

    $("#myBtn").click(function () {
        window.scrollTo({top: 0, behavior: 'smooth'});
    });
});