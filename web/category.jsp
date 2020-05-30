<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<jsp:include page="/header.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<div style="float:right;margin-right:50px;">

    <h4> Add Category</h4>
    <form:form id="catfrm" action="addCategory" modelAttribute="formcat" method="post">
        <table style="border:1px solid black;" align="center">
            <tr>
                <td><label for="catname">Category Name:</label></td>
                <td><form:input path="catname" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Add"/></td>
            </tr>
        </table>
    </form:form>
</div>

<h2>Categories</h2>
<table styele="margin-top:30px;" border="1" padding="5" margin="0">
    <tr>
        <th>Category Name</th>
        <th>Delete</th>
    </tr>
    <c:if test="${categoryList!=null}">
        <c:forEach items="${categoryList.categories}" var="ct" varStatus="tagst">
            <tr>
                <td>${ct.catname}</td>
                <td><a href="${path}/category/delete/${ct.id}"> Delete </a></td>
                <!--<td><button onclick="javascript:AddCart()">Add</button></td>-->
            </tr>
        </c:forEach>
    </c:if>
</table>


