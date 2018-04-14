/**
 * Created by Marguzych on 15.07.2017.
 */
/**
 * Welcome button click
 */
$(document).ready(function(){
    $('.welcome-button').click(function() {
        $('.welcome').hide();
        $('.navbar').show();
        $('.auth-block').show();
    });
});

/**
 * Navigation
 */
$(document).ready(function(){
    $('a').click(function(event) {
        event.preventDefault();
        if ($(this).hasClass('home-page')) {
            $('#user-form').trigger('reset');
            $('.navbar').hide();
            $('.auth-block').hide();
            $('.settings-block').hide();
            $('.welcome').show();
        } else if ($(this).hasClass('settings-page')) {
            $('#user-form').trigger('reset');
            $('.auth-block').show();
            $('.settings-block').hide();
        } else {
            $(location).attr('href', 'error');
        }
    });
});

/**
 * Auth form validation
 */
$(document).ready(function( $ ){

    $(function() {

        $('form').each(function(){
            var $form = $(this);
            var $auth_button = $form.find('.auth-button');

            $form.find('.required-field').parent().addClass('empty-field');

            function checkInput(){
                $form.find('.required-field').each(function(){
                    if($.trim($(this).val()) !== ''){
                        $(this).parent().removeClass('empty-field');
                    } else {
                        $(this).parent().addClass('empty-field');
                    }
                });
                checkAge();
            }

            function modData() {
                $form.find('.required-field').each(function() {
                    $(this).val($.trim($(this).val()));
                });
            }

            function checkAge() {
                $form.find('.age').each(function(){
                    var number = $(this).val();
                    if(($.isNumeric(number)) && ((number >= 1) && (number <= 117))){
                        $(this).removeClass('empty-field');
                    } else {
                        $(this).addClass('empty-field');
                        $(this).val('');
                    }
                });
            }

            function lightEmpty(){
                $form.find('.empty-field').css({'border-color':'#d60823'});
                setTimeout(function(){
                    $form.find('.empty-field').removeAttr('style');
                },500);
            }

            setInterval(function(){
                checkInput();
                var sizeEmpty = $form.find('.empty-field').size();
                if (sizeEmpty > 0) {
                    if ($auth_button.hasClass('disabled')) {
                        return false;
                    } else {
                        $auth_button.addClass('disabled');
                    }
                } else {
                    $auth_button.removeClass('disabled');
                }
            },500);

            $auth_button.click(function(){
                modData();
                if($(this).hasClass('disabled')){
                    lightEmpty();
                    return false;
                } else {
                    $('.auth-block').hide();
                    $('.settings-block').show();                }
            });
        });
    });

});

/**
 * Settings
 */
//
// $(document).ready(function () {
//     $('.home-header').click(function () {
//         $('.welcome').fadeIn('slow');
//         $(".header").fadeOut('slow');
//         $(".auth-block").fadeOut('slow');
//     });
// });

/**
 * Setting parameters
 */
$(document).ready(function () {
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
});
