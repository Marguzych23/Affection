/**
 * Testing process
 */
$(document).ready(function () {

    $('.active').removeClass('active');
    $('form').submit(function(event) {
        event.preventDefault();
        var $form = $('form');
        $.ajax({
            type: 'POST',
            url: $form.attr('action'),
            data: $form.serialize(),
            success: function (jsonData) {
                if (jsonData.isEnd == true) {
                    $('.content').hide();
                    $('.congratulation').show();
                } else {
                    $('#teacher').attr('src', '/ru.itis.affection/resources/' + jsonData.teacher);
                    $('#friend').attr('src', '/ru.itis.affection/resources/' + jsonData.friend);
                    $('.question').text(jsonData.question);
                    $('.answer').val('');
                }
            },
            dataType: 'json'
        }).fail(function () {
            alert('adf');
        });
    });
});

$(document).ready(function () {
    $('.rebirth-button').click(function() {
        $(location).attr('href', '/ru.itis.affection/tests');
    });
});

/**
 * Agents checking
 */
$(document).ready(function () {
    $('.agents').each(function() {
        if($(this).attr('src') !== '/ru.itis.affection/resources/'){
            $(this).removeClass('off-agent');
        } else {
            $(this).addClass('off-agent');
        }
    });
});

