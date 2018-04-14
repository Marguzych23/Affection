$(document).ready(function () {

    $('.navbar-nav .active').removeClass('active');
    $('#t').addClass('active');
    $('').addClass('active');
    var testName;
    $('a.test-tab').click(function () {
        var sel = $('li.active a').attr('href');
        $(sel).hide();
        $('li.active').removeClass('active');
        $(this).parent().addClass('active');
        sel = $(this).attr('href');
        $(sel).show();
    });
    $('input.test-name').click(function (e) {
        e.preventDefault();
        testName = $(this).val();
        $('.testSettings').removeClass('display-none');
        $('.tests').addClass('display-none');
        $('#test-name').val(testName);
    });
    //
    // $('form').submit(function(event) {
    //     event.preventDefault();
    //     var $form = $('form').serialize();
    //     var $data = ("test-name=" + testName + "&" + $form).;
    //     alert($data);
    //     $.ajax({
    //         type: 'GET',
    //         url: $(this).attr('action'),
    //         data: $data,
    //         fail: function () {
    //             alert('adf');
    //         }
    //     });
    // });

});