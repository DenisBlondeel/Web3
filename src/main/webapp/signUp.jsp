<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
	<jsp:param name="title" value="Sign Up" />
	<jsp:param name="style" value="${style}" />
</jsp:include>

<main> 

<form method="POST" action="Controller?action=signUpaction"
	novalidate="novalidate">
	<!-- novalidate in order to be able to run tests correctly -->
	<p>
		<label for="userid">User id</label><input type="text" id="userid"
			name="userid" required value="<c:out value="${prevUid}" />">
	</p>
	<p>
		<label for="firstName">First Name</label><input type="text"
			id="firstName" name="firstName" required
			value="<c:out value="${prevFirstName}" />">
	</p>
	<p>
		<label for="lastName">Last Name</label><input type="text"
			id="lastName" name="lastName" required
			value="<c:out value="${prevLastName}" />">
	</p>
	<p>
		<label for="email">Email</label><input type="email" id="email"
			name="email" required value="<c:out value="${prevEmail}" />">
	</p>
	<p>
		<label for="password">Password</label><input type="password"
			id="password" name="password" required>
	</p>
	<p>
		<input type="submit" id="signUp" value="Sign Up">
	</p>

</form>
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="page" value="signUppage" />
</jsp:include>
</html>
