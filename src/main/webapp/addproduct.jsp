<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
<jsp:param name="title" value="Add Product" />
<jsp:param name="style" value="${style}"/>
</jsp:include>
<main>
		<c:choose>
			<c:when test="${warning == 'productid'}">
				<div class="alert-danger">
					<ul>
						<li>Product Id can not be empty !</li>
					</ul>
				</div>
			</c:when>
			<c:when test="${warning == 'description'}">
				<div class="alert-danger">
					<ul>
						<li>Description can not be empty !</li>
					</ul>
				</div>
			</c:when>
			<c:when test="${warning == 'price'}">
				<div class="alert-danger">
					<ul>
						<li>Price can not be empty !</li>
					</ul>
				</div>
			</c:when>
			</c:choose>

			<form method="POST" action="Controller?action=addproductaction"
				novalidate="novalidate">
				<!-- novalidate in order to be able to run tests correctly -->
				<p>
					<label for="productid">Product id</label><input type="text"
						id="productid" name="productid" required value="<c:out value="${param.productid}" />">
				</p>
				<p>
					<label for="description">Description</label><input type="text"
						id="description" " name="description" " required value="<c:out value="${param.description}" />">
				</p>
				<p>
					<label for="price">Price</label><input type="text" id="price"
						name="price" required value="<c:out value="${param.price}" />">
				</p>
				<p>
					<input type="submit" id="signUp" value="Sign Up">
				</p>

			</form>
			</main>
<jsp:include page="footer.jsp">
<jsp:param name="page" value="addproductpage" />
</jsp:include>
</html>
