<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${Title}</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE = edge">
    <meta name="viewport" content="width = device-width, initial-scale = 1">
    <meta name='_csrf' content='${_csrf.token}' />
    <meta name='_csrf_header' content='${_csrf.headerName}' />
    <script type="text/javascript" src="<c:url value="/WebResources/js/jquery-1.12.3.min.js"/>"></script>
    <link href="<c:url value="/WebResources/bootstrap3.3.6/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/WebResources/font-awesome-4.6.3/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/WebResources/css/Style.css" />" rel="stylesheet">
    <script src="<c:url value="/WebResources/bootstrap3.3.6/js/bootstrap.min.js" />" type="text/javascript"></script>
</head>
<body>