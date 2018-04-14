<%--@elvariable id="testQuestion" type="dto.TestQuestionDto"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="<c:url value="/resources/img/favicon.png"/>" type="image/png">
    <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico"/>" type="img/x-icon">
    <title>Affection</title>


    <!-- Bootstrap styles -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Animate styles -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/animate.css"/>">


    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/logo-nav.css"/>" rel="stylesheet">

    <!-- My styles -->
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/test.css"/>" rel="stylesheet">


    <!-- Bootstrap core JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

    <!-- Page script -->
    <script type="text/javascript" src="<c:url value="/resources/js/test.js"/>"></script>

    <!— HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries —>
    <!— WARNING: Respond.js doesn't work if you view the page via file:// —>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- Included Navbar -->
<jsp:include page="navbar.jsp"></jsp:include>

<section class="content">

    <!--Agents photo-->
    <div class="agents animated fadeInUp delay-04s">
        <img class="agent teacher" id="teacher" src="<c:url value="/resources/${testQuestion.teacherImg}"/>"/>
        <img class="agent friend" id="friend" src="<c:url value="/resources/${testQuestion.friendImg}"/>"/>
    </div>

    <!--Test form-->
    <div class="main container animated fadeInUp delay-06s">
        <form class="test row" action="/affection/test" method="POST">

            <div class="col-md-12">
                <div class="question">${testQuestion.question}</div>
            </div>

            <div class="col-md-6 off-md-3">
                <div class="form-group floating-label-form-group test-answer">
                    <input type="text" class="answer form-control" name="answer" placeholder="Ответ" cols="40" rows="2"
                           required><br>
                </div>
            </div>

            <div class="form-group button col-md-12">
                <input class="continue" type="submit" id="sub" value="Следующий вопрос">
            </div>
        </form>
    </div>
</section>

<!--Congratulation-->
<section class="congratulation container">
    <div class="container">
        <div class="animated fadeInUp row delay-03s">
            <div class="">
                <h1 class="big-text">Поздравляем!</h1>
                <h1>Тест пройден удачно</h1>
            </div>
        </div>
        <div class="row">
            <div class="row form-group button col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-4 col-xs-offset-4">
                <button class="rebirth-button row animated fadeInUp delay-1s" type="button">Пройти тест заново</button>
            </div>
        </div>
    </div>
</section>

</body>
</html>