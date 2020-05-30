<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<jsp:include page="/header.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<div id="frm" style="float:right;margin-right:50px;display:none">

    <h4> Update Company</h4>
    <form:form id="comupfrm" action="editCompany" modelAttribute="formcom" method="post">
        <table style="border:1px solid black;" align="center">
            <tr>
                <td><label for="companyname">Company Name:</label></td>
                <td><form:input id="nameup" path="companyname" required="required" /></td>
            </tr>
            <tr>
                <td><label for="country">Country:</label></td>
                <td><form:input id="cntup" path="country" required="required"/></td>
            </tr>
            <tr>
                <td><label for="contactemail">Contact/Email:</label></td>
                <td><form:input id="emup" path="contactemail" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Update"/></td>
            </tr>
        </table>
            <form:hidden id="comid" path="id"/>
    </form:form>
</div>

<div style="float:right;margin-right:50px;">

    <h4> Add Company</h4>
    <form:form id="comfrm" action="addCompany" modelAttribute="formcom" method="post">
        <table style="border:1px solid black;" align="center">
            <tr>
                <td><label for="companyname">Company Name:</label></td>
                <td><form:input path="companyname" required="required"/></td>
            </tr>
            <tr>
                <td><label for="country">Country:</label></td>
                <td><form:input path="country" required="required"/></td>
            </tr>
            <tr>
                <td><label for="contactemail">Contact/Email:</label></td>
                <td><form:input path="contactemail" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Add"/></td>
            </tr>
        </table>
    </form:form>
</div>

<h2>Companies</h2>
<table styele="margin-top:30px;" border="1" padding="5" margin="0">
    <tr>
        <th>Company Name</th>
        <th>Country</th> 
        <th>Contact Email</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:if test="${companyList!=null}">
        <c:forEach items="${companyList.companies}" var="cr" varStatus="tagst">
            <tr id="tr${tagst.index}">
                <td>${cr.companyname}</td>
                <td>${cr.country}</td>
                <td>${cr.contactemail}</td>
                <td><a href="${path}/company/delete/${cr.id}"> Delete </a></td>
                <td><button onclick="javascript:enableForm(${tagst.index},${cr.id})"> Update </button></td>
                <!--<td><button onclick="javascript:AddCart()">Add</button></td>-->
            </tr>
        </c:forEach>
    </c:if>
</table>

<script type="text/javascript">
    enableForm = function (cr, id) {
        var x = document.getElementById("frm");
        if (x.style.display === "none") {
            x.style.display = "block";
            $("#nameup").val($("#tr" + cr).children().eq(0).text());
            $("#cntup").val($("#tr" + cr).children().eq(1).text());
            $("#emup").val($("#tr" + cr).children().eq(2).text());
            $("#comid").val(id);
        } else {
            x.style.display = "none";
        }
    }
</script>


