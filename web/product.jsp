<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<jsp:include page="/header.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<div id="frm" style="float:right;margin-right:50px;display:none">

    <h4> Update Product</h4>
    <form:form id="produpform" action="editProduct" modelAttribute="formprd" method="post">
        <table style="border:1px solid black;" align="center">
            <tr>
                <td><label for="productname">Product Name:</label></td>
                <td><form:input id="nameup" path="productname" readonly="true" disabled="true"/></td>
            </tr>
            <tr>
                <td><label for="priceperunit">Price per Unit:</label></td>
                <td><form:input id="prcup" path="priceperunit" required="required"/></td>
            </tr>
            <tr>
                <td><label for="company">Company:</label></td>
                <td><form:select id ="comup" path="company" items="${companyList}"/>
            </tr>
            <tr>
                <td><label for="category">Category</label></td>
                <td><form:select id="catup" path="category" items="${categoryList}"/>
            </tr>
            <tr>
                <td><label for="quantity">Quantity:</label></td>
                <td><form:input id="qtyup" path="quantity" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Update"/></td>
            </tr>
        </table>
            <form:hidden id="prdid" path="id"/>
    </form:form>
</div>

<div style="float:right;margin-right:50px;">

    <h4> Add Product</h4>
    <form:form id="prodform" action="addProduct" modelAttribute="formprd" method="post">
        <table style="border:1px solid black;" align="center">
            <tr>
                <td><label for="productname">Product Name:</label></td>
                <td><form:input path="productname" required="required" /></td>
            </tr>
            <tr>
                <td><label for="priceperunit">Price per Unit:</label></td>
                <td><form:input path="priceperunit" required="required" /></td>
            </tr>
            <tr>
                <td><label for="company">Company:</label></td>
                <td><form:select path="company" items="${companyList}"/>
                <!--<td><form:input path="company" /></td>-->
            </tr>
            <tr>
                <td><label for="category">Category</label></td>
                <td><form:select path="category" items="${categoryList}"/>
                <!--<td><form:input path="category"/></td>-->
            </tr>
            <tr>
                <td><label for="quantity">Quantity:</label></td>
                <td><form:input path="quantity" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Add"/></td>
            </tr>
        </table>
    </form:form>
</div>

<h2>Products</h2>
<table styele="margin-top:30px;" border="1" padding="5" margin="0">
    <tr>
        <th>Product Name</th>
        <th>Company</th>
        <th>Category</th> 
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:if test="${productsList!=null}">
        <c:forEach items="${productsList.products}" var="pr" varStatus="tagst">
            <tr id="tr${tagst.index}">
                <td>${pr.productname}</td>
                <td>${pr.company}</td>
                <td>${pr.category}</td>
                <td>${pr.priceperunit}</td>
                <td>${pr.quantity}</td>
                <td><a href="${path}/product/delete/${pr.id}"> Delete </a></td>
                <td><button onclick="javascript:enableForm(${tagst.index},${pr.id})"> Update </button></td>
                <!--<td><button onclick="javascript:AddCart()">Add</button></td>-->
            </tr>
        </c:forEach>
    </c:if>
</table>

<script type="text/javascript">
    enableForm = function (pr, id) {
        var x = document.getElementById("frm");
        if (x.style.display === "none") {
            x.style.display = "block";
            $("#nameup").val($("#tr" + pr).children().eq(0).text());
            $("#comup").val($("#tr" + pr).children().eq(1).text());
            $("#catup").val($("#tr" + pr).children().eq(2).text());
            $("#prcup").val($("#tr" + pr).children().eq(3).text());
            $("#qtyup").val($("#tr" + pr).children().eq(4).text());
            $("#prdid").val(id);
        } else {
            x.style.display = "none";
        }
    };
</script>


