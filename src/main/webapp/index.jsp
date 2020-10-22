<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="nav.jsp">
	<jsp:param name="title" value="Home" />
	<jsp:param name="style" value="${style}" />
</jsp:include>
<main> Sed ut perspiciatis unde omnis iste natus error sit
voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
qui ratione voluptatem sequi nesciunt. </main>
<footer>
	<c:choose>
		<c:when test="${login == 'istrue'}">
			<form method="POST" action="Controller?action=logout">
				<p>
					<input type="submit" id="logout" value="logout">
				</p>
			</form>
		</c:when>
		<c:otherwise>
			<form method="POST" action="Controller?action=login">
				<p>
					<label for="username">Username</label><input type="text"
						id="username" name="username" required value="<c:out value="" />">
				</p>
				<p>
					<label for="password">Password</label><input type="password"
						id="password" name="password" required value="<c:out value="" />">
				</p>
				<p>
					<input type="submit" id="login" value="Login">
				</p>
			</form>
		</c:otherwise>
	</c:choose>
</footer>
<jsp:include page="footer.jsp">
	<jsp:param name="page" value="index" />
	<jsp:param name="style" value="${style}" />
</jsp:include>
</html>