$(function() {
    // when sidebar element clicked, toggle active
    $(".nav-sidebar li").click(function() {
        console.log("clicked");
        if ($(this).attr('class') == 'active') {
            $(this).removeClass('active');
        } else {
            $(this).addClass('active');
        }
    });
    
    /* affix sidebar to main content
    $(".nav-sidebar").affix({
       offset: {
           top: 245
       } 
    });
    */
});