<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
	<jsp:param name="title" value="Winkelkar" />
	<jsp:param name="style" value="${style}" />
</jsp:include>
<main>

<table>
	<tr>
		<th>Id</th>
		<th>Description</th>
		<th>Price</th>
		<th>Quantity</th>
	</tr>

	<c:forEach var="productOrder" items="${cartlist}">
		<tr>
			<td>${productOrder.productId}</td>
			<td>${productOrder.product.description}</td>
			<td>${productOrder.product.price}</td>
			<td>${productOrder.quantity}</td>
			<td><a
				href="Controller?action=deletepageproduct&name=${product.productId}">delete</a></td>
		</tr>
	</c:forEach>
</table>
<hr>
<tr>total: ${total}</tr>

</main>
<jsp:include page="footer.jsp">
<jsp:param name="page" value="cartpage" />
</jsp:include>
</html>