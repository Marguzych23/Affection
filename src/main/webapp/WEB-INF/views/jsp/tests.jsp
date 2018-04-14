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
    <link rel="stylesheet" href="<c:url value="/resources/css/layout.min.css"/>">

    <!-- Animate styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/animate.css">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/logo-nav.css"/>" rel="stylesheet">


    <!--&lt;!&ndash;Footer&ndash;&gt;-->
    <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">-->
    <!--<link rel="stylesheet" href="/resources/css/footer-distributed-with-address-and-phones.css">-->

    <!-- My styles -->
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

    <!-- Page styles -->
    <link href="<c:url value="/resources/css/testSettings.css"/>" rel="stylesheet">


    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>

    <!-- Page scripts -->
    <script type="text/javascript" src="<c:url value="/resources/js/tests.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/testSettings.js"/>"></script>

</head>
<body>

<!-- Included Navbar -->
<jsp:include page="navbar.jsp"></jsp:include>

<section>
    <section class="container tests">
        <div class="row">
            <div class="content col-md-11 animated fadeInUp delay-01s row">

                <div class="test-name-content col-md-12 text-center">
                    <h1>Тесты</h1>
                    <hr class="star-primary">
                </div>

                <div class="main-content col-md-8 offset-md-2">

                    <ul class="nav nav-tabs nav-custom">
                        <li class="active">
                            <a class="test-tab" href="#all" data-toggle="tab">
                                <strong>Все</strong>
                            </a>
                        </li>
                        <li>
                            <a class="test-tab" href="#popular" data-toggle="tab">
                                <strong>Популярные</strong>
                            </a>
                        </li>
                        <li>
                            <a class="test-tab" href="#new" data-toggle="tab">
                                <strong>Новые</strong>
                            </a>
                        </li>
                        <li>
                            <a class="test-tab" href="#unpassed" data-toggle="tab">
                                <strong>Не пройденные</strong>
                            </a>
                        </li>
                        <li>
                            <a class="test-tab" href="#passed" data-toggle="tab">
                                <strong>Пройденные</strong>
                            </a>
                        </li>
                    </ul>
                    <div id="tests">
                        <div id="all">
                            <%--@elvariable id="tests" type="java.util.List<dto.TestDto>"--%>
                            <c:forEach items="${tests}" var="test">
                                <div class="floating-content">
                                    <div class="form-group floating-label-form-group">
                                        <label for="${test.name}">${test.name}</label>
                                        <input type="text" class="test-name required-field form-control"
                                               placeholder="${test.name}"
                                               name="test-name" value="${test.name}">
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div id="popular">
                            <%--@elvariable id="popularTests" type="java.util.List<dto.TestDto>"--%>
                            <c:forEach items="${popularTests}" var="test">
                                <div class="floating-content">
                                    <div class="form-group floating-label-form-group">
                                        <label for="${test.name}">${test.name}</label>
                                        <input type="text" class="test-name required-field form-control"
                                               placeholder="${test.name}"
                                               name="test-name" value="${test.name}">
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div id="new">
                            <%--@elvariable id="newTests" type="java.util.List<dto.TestDto>"--%>
                            <c:forEach items="${newTests}" var="test">
                                <div class="floating-content">
                                    <div class="form-group floating-label-form-group">
                                        <label for="${test.name}">${test.name}</label>
                                        <input type="text" class="test-name required-field form-control"
                                               placeholder="${test.name}"
                                               name="test-name" value="${test.name}">
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div id="unpassed">
                            <%--@elvariable id="unpassedTests" type="java.util.List<dto.TestDto>"--%>
                            <c:forEach items="${unpassedTests}" var="test">
                                <div class="floating-content">
                                    <div class="form-group floating-label-form-group">
                                        <label for="${test.name}">${test.name}</label>
                                        <input type="text" class="test-name required-field form-control"
                                               placeholder="${test.name}"
                                               name="test-name" value="${test.name}">
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div id="passed">
                            <%--@elvariable id="passedTests" type="java.util.List<dto.TestDto>"--%>
                            <c:forEach items="${passedTests}" var="test">
                                <div class="floating-content">
                                    <div class="form-group floating-label-form-group">
                                        <label for="${test.name}">${test.name}</label>
                                        <input type="text" class="test-name required-field form-control"
                                               placeholder="${test.name}"
                                               name="test-name" value="${test.name}">
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>


    <section class="container testSettings display-none">
        <form action="<c:url value="/test"/>" method="GET" id="form">
            <div class="row">
                <div class="content col-md-11 animated fadeInUp delay-01s row">
                    <div class="content-name col-md-12 text-center">
                        <h1>Настройки теста</h1>
                        <hr class="star-primary">
                    </div>

                    <div class="agents col-md-4 text-left">
                        <h6>Выберите агентов:</h6>

                        <div class="funky-radio checkbox-selects">
                            <div class="funky-radio-success">
                                <input type="checkbox" id="teacher-on" name="agents" value="teacher"/>
                                <label for="teacher-on">Преподаватель</label>
                            </div>
                            <div class="funky-radio-success">
                                <input type="checkbox" id="friend-on" name="agents" value="friend"/>
                                <label for="friend-on">Друг</label>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="test-name" name="test-name">
                    <div class="teachers col-md-6 text-left">
                        <h6>Настроение преподавателя:</h6>

                        <div class="funky-radio radio-selects">
                            <div class="funky-radio-success">
                                <input type="radio" name="test-teacher" value="kind" id="kind"/>
                                <label for="kind">Всегда добрый</label>
                            </div>
                            <div class="funky-radio-success">
                                <input type="radio" name="test-teacher" value="evil" id="evil"/>
                                <label for="evil">Всегда злой</label>
                            </div>
                            <div class="funky-radio-success">
                                <input type="radio" name="test-teacher" checked value="none" id="none"/>
                                <label for="none">В зависимости от
                                    ваших ответов</label>
                            </div>
                        </div>
                    </div>


                    <div class="friends col-md-6 text-left">
                        <h6>Выберите друга:</h6>
                        <div class="row cc-selector">
                            <div class="">
                                <input type="radio" name="test-friend" value="friend1" id="girl">
                                <label class="friend-cc girl" for="girl"></label>
                            </div>
                            <div class="">
                                <input type="radio" name="test-friend" checked value="friend2" id="boy">
                                <label class="friend-cc boy" for="boy"></label>
                            </div>
                        </div>
                    </div>

                    <div class="data-submit col-md-12">
                        <div class="form-group continue_btn">
                            <button class="btn btn-success btn-lg settings-button" type="submit">Начать тестирование
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </section>
</section>


</body>
</html>