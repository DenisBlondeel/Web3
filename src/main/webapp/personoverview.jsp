<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="nav.jsp">
<jsp:param name="title" value="Overview" />
<jsp:param name="style" value="${style}"/>
</jsp:include>
		<main>
		<table>
			<tr>
				<th>E-mail</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>

			<c:forEach var="person" items="${list}">
				<tr>
					<td>${person.email}</td>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td><a href="Controller?action=deletepageperson&name=${person.userid}">delete</a></td>
					<td><a href="Controller?action=checkpasswordpage&name=${person.userid}">check password</a></td>
				</tr>
			</c:forEach>

			<caption>Users Overview</caption>
		</table>
		</main>
<jsp:include page="footer.jsp">
<jsp:param name="page" value="overview" />
</jsp:include>
</html>