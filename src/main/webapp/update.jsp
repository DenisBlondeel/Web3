<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
<jsp:param name="title" value="Update" />
<jsp:param name="style" value="${style}"/>
</jsp:include>
		<main>
		<c:if test="${warning == 'incomplete'}">
			<div class="alert-danger">
				<ul>
					<li>Some fields are left blank !</li>
				</ul>
			</div>
			</c:if>
					<c:if test="${warning == 'illegalNumber'}">
			<div class="alert-danger">
				<ul>
					<li>Not a valid number!</li>
				</ul>
			</div>
			</c:if>
		
		<form method="POST" action="Controller?action=updateaction"
			novalidate="novalidate">
			<!-- novalidate in order to be able to run tests correctly -->
			<p>
				<label for="productid">Product id</label><input type="text" id="productid"
					name="productid" value="<c:out value="${product.productId}" />" required readonly>
			</p>
			<p>
				<label for="description">Description</label><input type="text"
					id="description"" name="description"" value="<c:out value="${product.description}" />" required>
			</p>
			<p>
				<label for="price">Price</label><input type="text"
					id="price" name="price" value="<c:out value="${product.price}" />" required>
			</p>	
			<p>
				<input type="submit" id="update" value="Update">
			</p>

		</form>

		</main>
<jsp:include page="footer.jsp">
<jsp:param name="page" value="updatepage" />
</jsp:include>
</html>
