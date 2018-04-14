/**
 * Setting parameters
 */

$(document).ready(function () {
    $('#teacher-on').change(function () {
        if (this.checked) {
            $('.teachers, .data-submit').fadeIn('slow');
        } else {
            $('.teachers').fadeOut('slow');
            if (!$('#friend-on').is(":checked")) {
                $(".data-submit").fadeOut('slow');
            }
        }
    });

    $('#friend-on').change(function () {
        if (this.checked) {
            $('.friends, .data-submit').fadeIn('slow');
        } else {
            $('.friends').fadeOut('slow');
            if(!$('#teacher-on').is(":checked")) {
                $(".data-submit").fadeOut('slow');
            }
        }
    });

});