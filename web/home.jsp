<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<jsp:include page="/header.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<table style="margin-top:30px;float: left;" border="1" padding="5">
    <h2>Products</h2>
    <tr>
        <th>Product Name</th>
        <th>Company</th>
        <th>Category</th> 
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Add to Cart</th>
    </tr>
    <c:if test="${productsList!=null}">
        <c:forEach items="${productsList.products}" var="pr" varStatus="tagst">
            <tr id="tr${tagst.index}">
                <td>${pr.productname}</td>
                <td>${pr.company}</td>
                <td>${pr.category}</td>
                <td>${pr.priceperunit}</td>
                <td>${pr.quantity}</td>
                <!--<td><a href="${path}/product/delete/${pr.id}"> Delete </a></td>-->
                <td><button onclick="javascript:addCart(${tagst.index},${pr.id})"> Cart </button></td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<table id="cartTb" style="margin-top:30px;float:right;margin-right: 20px" border="1" padding="5">
    <tr>
        <th>Product Name</th>
        <th>Company</th>
        <th>Category</th> 
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Delete</th>
    </tr>
</table>

<script type="text/javascript">
    addCart = function (pr, id) {
        
        if($("#c"+pr).length){
            
            var x = $("#c"+pr+" td:eq(4)");
            x.text(parseInt(x.text())+1)
            
        }else{
        $("#cartTb").append('<tr id="c'+pr+'"><td>'+$("#tr"+pr).children().eq(0).text()+'</td>\n\
            <td>'+$("#tr"+pr).children().eq(1).text()+'</td>\n\
            <td>'+$("#tr"+pr).children().eq(2).text()+'</td>\n\
            <td>'+$("#tr"+pr).children().eq(3).text()+'</td>\n\
            <td>1</td>\n\
            <td><button onclick="delCart(c'+pr+')">Delete</button></td></tr>');
        }
    };
    
    delCart = function (pr) {
       $(pr).remove();
    };
</script>


