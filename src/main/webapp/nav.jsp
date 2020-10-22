<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>${param.title}</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<c:choose>
	<c:when test="${param.style == 'yellow'}">
		<link rel="stylesheet" type="text/css" href="css/yellow.css">
	</c:when>
	<c:when test="${param.style == ''}">
		<link rel="stylesheet" type="text/css" href="css/yellow.css">
	</c:when>
	<c:when test="${param.style == 'red'}">
		<link rel="stylesheet" type="text/css" href="css/red.css">
	</c:when>
</c:choose>
</head>
<body>
	<div id="container">
		<header>
			<h1>
				<span>Web shop</span>
			</h1>
			<nav>
				<ul>
					<li <c:if test="${param.title == 'Home'}"> id="actual" </c:if>><a
						href="Controller?action=default">Home</a></li>
					<li <c:if test="${param.title == 'Overview'}"> id="actual" </c:if>><a
						href="Controller?action=overview">Overview</a></li>
					<li <c:if test="${param.title == 'SignUp'}"> id="actual" </c:if>><a
						href="Controller?action=signUppage">Sign up</a></li>
					<li
						<c:if test="${param.title == 'Product Overview'}"> id="actual" </c:if>><a
						href="Controller?action=productoverview">Product</a></li>
					<li
						<c:if test="${param.title == 'Add Product'}"> id="actual" </c:if>><a
						href="Controller?action=addproductpage">Add product</a></li>
				</ul>
			</nav>
			<h2>${param.title}</h2>

			<c:if test="${errors!=null}">
				<div class="alert alert-danger">
					<ul>
						<c:forEach var="error" items="${errors}">
							<li><c:out value="${error}" /></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<c:if test="${success!=null}">
				<div class="alert alert-success">
					<ul>
						<c:forEach var="succes" items="${success}">
							<li><c:out value="${succes}" /></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>


		</header>