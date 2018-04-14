$(document).ready(function () {

    $('.active').removeClass('active');
    $('#prof').addClass('active');

    $('.edit-button').click(function () {
        $('.profile-block').addClass('display-none');
        $('.edit-block').removeClass('display-none');
    });
    $('.cancel-button').click(function () {
        $('form').trigger('clear');
        $('.edit-block').addClass('display-none');
        $('.profile-block').removeClass('display-none');
    });

    $('.delete-button').click(function () {
        var del = confirm("Удалить страницу?");
        if (del) {
            $.ajax({
                type: "POST",
                url: "/ru.itis.affection/delete"
            });
        }
    });

    $('.all-tests').click(function (e) {
        e.preventDefault();
        $.ajax({
            type: 'GET',
            url: '/profile',
            data: {
                'details': 'details'
            }
        });
    });


//            function clearForm() {
//                var formData = $('#user-form').getElementsByClassName('form-control');
//                formData.each(function (inputData) {
//                    if (inputData.value() != '') {
//                        inputData.val('');
//                    }
//                });
//            }

});