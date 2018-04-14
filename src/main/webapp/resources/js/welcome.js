$(document).ready(function () {
    var location = document.location.href;
    if (location.indexOf('signin') != -1) {
        alert(location);
        $('.welcome-button').trigger('click');
    }
});