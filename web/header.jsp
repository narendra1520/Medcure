<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<c:url value="/resource/jquery.min.js" var="qjs"/>
<c:url value="/resource/logo1.png" var="lg1"/>
<c:url value="/resource/logo2.png" var="lg2"/>

<c:set var="path" scope="application" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <script type="text/javascript" src="${qjs}"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Medcur</title>
        <style>
            #nav{
                background: gray;
                color:white;
                padding:5px;
            }

            #nav a{
                color: white;
                text-decoration: none;
                border-right: 1px solid black;
                padding:5px;
            }
            
            #title{
                color: blue;
                text-align: center;
                width: 100%;
                height: 50px;
                border: 1px solid black;
                font-size: 40px;
                text-align: center;
                font-weight: bold;
            }
            
            #title img{
                height: 100px;
                width: 100px;
            }
            
            .lg1{
                float:left;
            }
            
            .lg2{
                float:right;
            }

            table {
                border-collapse: collapse;
            }

            table button{
                background: none;
                color:blue;
            }

            table a{
                color: red;
                text-decoration: none;
            }


            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2}

            th {
                background-color: #4CAF50;
                color: white;
            }
            
            h2{
                color: crimson;
                margin-top: 80px;
                margin-left: 10%;
            }
        </style>
    </head>

    <body>
        <div id="nav">
            <a href="${path}/home">Home</a>
            <a href="${path}/product">View Products</a>
            <a href="${path}/company">View Companies</a>
            <a href="${path}/category">View Category</a>
            <a href="${path}/logout">Logout</a>
        </div>
        <div id="title">
            <img class="lg1" src="${lg1}">
            Medcur
            <img class="lg2" src="${lg2}">
        </div>
    </body>
</html>