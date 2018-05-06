<%--@elvariable id="userTests" type="java.util.List<ru.itis.affection.models.UserTest>"--%>
<%--@elvariable id="userProfile" type="ru.itis.affection.forms.UserForm"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "security" uri= "http://www.springframework.org/security/tags" %>
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
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- ANIMATE STYLES -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/animate.css"/>">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/logo-nav.css"/>" rel="stylesheet">

    <!-- My styles -->
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

    <!-- Page styles -->
    <link href="<c:url value="/resources/css/profile.css"/>" rel="stylesheet">


    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>

    <!-- Page script -->
    <script src="<c:url value="/resources/js/profile.js"/>"></script>

</head>
<body>

<jsp:include page="navbar.jsp"></jsp:include>

<section class="container">
    <div class="row">
        <div class="profile-block content col-md-11 animated fadeInUp delay-01s row">

            <div class="content-name col-md-12 text-center">
                <h1>Профиль</h1>
                <hr class="star-primary">
            </div>

            <div class="profile-data main-content col-md-6 text-left">
                <div class="row">
                    <h3>${userProfile.login}</h3>
                    <button type="button" class="edit-button btn btn-success btn-md">Edit</button>
                </div>
                <div class="floating-content">
                    <p>Email: ${userProfile.email}</p>
                </div>
                <div class="floating-content">
                    <p>Пол:
                        <c:if test="${userProfile.sex}">
                            Мужчина
                        </c:if>
                        <c:if test="${not userProfile.sex}">
                            Женщина
                        </c:if>
                    </p>
                </div>
                <div class="floating-content">
                    <p>Дата рождения: ${userProfile.birthday}</p>
                </div>
            </div>

            <div class="tests-content main-content text-style col-md-4 offset-md-2">

                <ul class="nav nav-tabs nav-custom">
                    <li class="active">
                        <a class="test-tab" href="#tab-activity" data-toggle="tab">
                            <strong>Пройденные</strong>
                        </a>
                    </li>
                </ul>
                <c:forEach items="${userTests}" var="userTest">
                    <div class="tests-group-tittle floating-content">
                        <p>${userTest.test.name}</p>
                        <h6>${userTest.date}</h6>
                        <h6>${userTest.percent}</h6>
                    </div>
                </c:forEach>
                <div class="form-group text-left">
                    <a href="/profile?details=det" class="all-tests">Ещё</a>
                </div>
                <%--@elvariable id="userTestDetails" type="java.util.List<dto.UserTestDetailDto>"--%>
                <c:forEach items="${userTestDetails}" var="userTestDetail">
                    <div class="tests-group-tittle floating-content">
                        <p>${userTestDetail.test.name}</p>
                    </div>
                </c:forEach>
            </div>
        </div>


        <div class="edit-block content col-md-11 animated fadeInUp delay-04s display-none">

            <div class="row">
                <div class="col-md-12 text-center">
                    <h1 class="block-title">Настройки</h1>
                    <hr class="star-primary">
                </div>
            </div>

            <div class="row auth-form">
                <form:form method="post" cssClass="col-md-12 user required-fields" id="user-form"
                           action="/profile" modelAttribute="userForm">

                    <div class="row">

                        <div class="offset-md-3 col-md-6">
                            <div class="form-group floating-label-form-group">
                                <form:label path="nickname">Имя</form:label>
                                <form:input cssClass="form-control" placeholder="Nickname"
                                            path="name"
                                            id="nickname" tabindex="0"/>
                            </div>
                        </div>


                        <div class="offset-md-3 col-md-6">
                            <div class="form-group floating-label-form-group">
                                <form:label path="new-password">Новый пароль</form:label>
                                <form:password cssClass="form-control"
                                               placeholder="Новый пароль"
                                               path="new-password" tabindex="0"/>
                            </div>
                        </div>

                        <div class="offset-md-3 col-md-6">
                            <div class="form-group floating-label-form-group">
                                <form:label path="repeat-new-password">Новый пароль</form:label>
                                <form:password cssClass="form-control"
                                               placeholder="Повторите пароль"
                                               path="repeat-new-password" tabindex="0"/>
                            </div>
                        </div>

                            <%--<div class="offset-md-3 col-md-6">--%>
                            <%--<div class="required_field form-group floating-label-form-group">--%>
                            <%--<label path="age">Возраст</label>--%>
                            <%--<input type="date" class="age required-field form-control" placeholder="Дата рождения"--%>
                            <%--name="age" id="age"--%>
                            <%--tabindex="0">--%>
                            <%--</div>--%>
                            <%--</div>--%>

                        <div class="offset-md-3 col-md-6">
                            <div class="form-group">
                                <input class="save-button btn btn-success btn-lg" type="submit" tabindex="0"
                                       value="Сохранить">
                                <input class="delete-button btn btn-lg" type="button" value="Удалить пользователя">
                                <input class="cancel-button btn btn-lg" type="button" value="Отмена">
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>


    </div>
</section>

</body>
</html>