<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="<c:url value="/resources/img/favicon.png"/>" type="image/png">
    <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico"/>" type="img/x-icon">
    <title>Affection</title>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.css"/>" rel="stylesheet">

    <!-- Theme styles -->
    <link rel="stylesheet" href="../../../resources/css/layout.min.css">

    <!-- Animate styles -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/animate.css"/>">

    <!--&lt;!&ndash;Footer&ndash;&gt;-->
    <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">-->
    <!--<link rel="stylesheet" href="/resources/css/footer-distributed-with-address-and-phones.css">-->

    <!-- Page styles -->
    <link href="<c:url value="/resources/css/welcome.css"/>" rel="stylesheet">

    <!— HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries —>
    <!— WARNING: Respond.js doesn't work if you view the page via file:// —>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

    <!-- Page scripts -->
    <script src="<c:url value="/resources/js/welcome.js"/>"></script>


</head>
<body>

<!--Start page - Welcome-->
<section id="home">
    <div class="welcome">
        <div class="container">
            <div class="welcome-info col-md-4 offset-md-4 ">
                <div class=" text-center animated fadeInDown delay-07s">
                    <img src="<c:url value="/resources/img/logo.png"/>" alt="">
                </div><br>
                <div class="col-md-12 we-create text-center animated fadeInUp delay-1s">
                    <h3>Краткое описание</h3>
                </div>
                <div class="center-block text-center">
                    <a class="nav-link js-scroll-trigger" href="#signin" data-toggle="modal"
                       data-target=".bs-modal-sm">
                        <button type="button" class="welcome-button animated fadeInUp delay-1s" tabindex="0">Войти
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="modal fade bs-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="row">
                <div class="form-body">
                    <ul class="nav nav-tabs final-login" role="tablist">
                        <li class="nav-item"><a class="flex-sm-fill text-sm-center nav-link active" data-toggle="tab"
                                                href="#signin">Войти</a>
                        </li>
                        <li class="nav-item"><a class="flex-sm-fill text-sm-center nav-link " data-toggle="tab"
                                                href="#signup">Регистрация</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="signin" class="tab-pane active show fade">
                            <%--@elvariable id="signinErrors" type="java.util.List"--%>
                            <c:forEach items="${signinErrors}" var="error">
                                <div class="text-danger">* ${error}</div>
                            </c:forEach>
                            <div class="inner-form">
                                <form class="sa-innate-form" method="post" action="<c:url value="/login"/>">
                                    <label for="signin-username-field">Логин:</label>
                                    <input id="signin-username-field" type="text" name="signin-login">
                                    <label for="signin-password-field">Пароль:</label>
                                    <input id="signin-password-field" type="password" name="signin-password">
                                    <button type="submit" class="signin">Войти</button>
                                </form>
                            </div>
                        </div>
                        <div id="signup" class="tab-pane fade">
                            <%--@elvariable id="signupErrors" type="java.util.List"--%>
                            <c:forEach items="${signupErrors}" var="error">
                                <div class="text-danger">* ${error}</div>
                            </c:forEach>
                            <div class="inner-form">
                                <form class="sa-innate-form" method="post" action="<c:url value="/signup"/>">
                                    <label for="signup-email">Email:</label>
                                    <input id="signup-email" type="text" name="signup-email">
                                    <label for="signup-username">Логин:</label>
                                    <input id="signup-username" type="text" name="signup-login">
                                    <label for="signup-password">Пароль:</label>
                                    <input id="signup-password" type="password" name="signup-password">
                                    <label for="signup-password-repeat">Пароль:</label>
                                    <input id="signup-password-repeat" type="password" name="signup-password-repeat">
                                    <label for="signup-birthday">Дата рождения:</label><br>
                                    <input id="signup-birthday" type="date" name="signup-birthday"><br>
                                    <label for="signup-sex">Пол:</label>
                                    <select class="select2" id="signup-sex" name="signup-sex">
                                        <option value="1">Женский</option>
                                        <option value="0">Мужской</option>
                                    </select>
                                    <button type="submit" class="signup">Зарегистрироваться</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>