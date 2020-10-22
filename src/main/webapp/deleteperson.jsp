<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
<jsp:param name="title" value="Confirmation" />
<jsp:param name="style" value="${style}"/>
</jsp:include>
		<main>

		<form method="POST"
			action="Controller?action=deleteactionperson&name=${person.userid}"
			novalidate="novalidate">
			<!-- novalidate in order to be able to run tests correctly -->
			<p>
				<input type="submit" name="delete" id="delete" value="Delete">
			</p>
			<p>
				<input type="submit" name="cancel" id="cancel" value="Cancel">
			</p>
		</main>
<jsp:include page="footer.jsp">
<jsp:param name="page" value="deletepageperson" />
</jsp:include>
</html>
