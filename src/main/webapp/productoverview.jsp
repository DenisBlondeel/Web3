<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
	<jsp:param name="title" value="Product Overview" />
	<jsp:param name="style" value="${style}" />
</jsp:include>
<main>
<table>
	<tr>
		<th>Id</th>
		<th>Description</th>
		<th>Price</th>
		<th>Quantity Add item</th>
		<th>Admin</th>
	</tr>

	<c:forEach var="product" items="${productList}">
		<tr>
			<td><a
				href="Controller?action=updatepage&name=${product.productId}">${product.productId}</a></td>
			<td>${product.description}</td>
			<td>${product.price}</td>
			<td><form method="POST"
					action="Controller?action=addtocartaction" id="card">
					<input type="number" name="quantity" min="1"> <input
						type="submit" value="Submit" id="card"><input
						type="hidden" name="id" value="${product.productId}">
				</form></td>
			<td><a
				href="Controller?action=deletepageproduct&name=${product.productId}">delete</a></td>
		</tr>
	</c:forEach>
	<a href="Controller?action=cartpage">Ga naar winkelkarretje</a>

	<caption>Product Overview</caption>
</table>
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="page" value="productoverview" />
</jsp:include>
</html>