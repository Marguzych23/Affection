<%--@elvariable id="user" type="models.User"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top navbar-custom animated fadeInDown delay-04s">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/home"/>">
            <img src="<c:url value="/resources/img/logo.png"/>" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/home"/>">Home</a>
                </li>
                <c:choose>
                    <c:when test="${not empty user.login}">
                        <li class="nav-item">
                            <a class="nav-link" id="prof" href="<c:url value="/profile"/>">${user.login}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="t" href="<c:url value="/tests"/>">Тесты</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="out" href="<c:url value="/logout"/>">Выйти</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="/home#signin" data-toggle="modal"
                               data-target=".bs-modal-sm">Войти</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
