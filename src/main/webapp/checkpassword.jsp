<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
<jsp:param name="title" value="Check Password" />
<jsp:param name="style" value="${style}"/>
</jsp:include>
		<main>
		<p>fill here your password:</p>
		<c:choose>
			<c:when test="${warning == 'notequal'}">
				<div class="alert-danger">
					<ul>
						<li>Password incorrect</li>
					</ul>
				</div>
			</c:when>
			<c:when test="${warning == 'equal'}">
				<div class="success-good">
					<ul>
						<li>Password correct !</li>
					</ul>
				</div>
			</c:when>
			</c:choose>
		
		<form method="POST" action="Controller?action=checkpasswordaction&personid=${personid}"
				novalidate="novalidate">
				<!-- novalidate in order to be able to run tests correctly -->
				<p>
					<label for="password">Password</label><input type="text"
						id="password" name="password" required>
				</p>
				<p>
					<input type="submit" id="check" value="Check">
				</p>

			</form>

		</main>
<jsp:include page="footer.jsp">
<jsp:param name="page" value="checkpasswordpage" />
</jsp:include>
</html>