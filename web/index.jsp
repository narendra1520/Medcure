<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Medcur</title>

        <style>
            button{
                background: blueviolet;
                color:white;
                padding: 5px;
            }
            #intro{
                display: table;
                margin: auto;
                text-align: center;
            }
            #er{
                margin-top: 5px;
                color:red;
                display: table;
                margin: auto;
            }
        </style>
    </head>

    <body>
        <div id="intro">
            <h3>Welcome to Medcur</h3>
            <h4>Login to continue</h4>
        </div>

        <form:form id="loginForm" action="loginProc" modelAttribute="formLog" method="post">
            <table style="border: 1px solid black;" align="center">
                <tr>
                    <td><label for="username">Username:</label></td>
                    <td><form:input path="username" required="required" /></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><form:password path="password" required="required"/></td>
                </tr>
                <tr style="margin-top: 5px;">
                    <td align="center" colspan="2"><button type="submit" value="Login">Login</buttton></td>
                </tr>
            </table>
            <div id="er"><form:errors path="username"/></div>
        </form:form>
    </body>
</html>
