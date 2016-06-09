<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Welcome</title>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- Bar -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="brand" href="https://github.com/mhatem">MHatem</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active">
							<a href="${pageContext.request.contextPath}">Home</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- Container -->
	<div class="container">
		<div class="wrapper">
			<c:if test="${not empty message}">
				<font style="color: blue;">${message}</font>
				<br />
			</c:if>
			<div class="form-signin">
				<form action="login" method="post">
					<h2 class="form-signin-heading">Please login</h2>
					<input type="email" class="form-control" name="email" placeholder="Email Address" required />
					<br />
					<input type="password" class="form-control" name="password" placeholder="Password" required />
					<br />
					<button class="btn btn-lg btn-primary" type="submit">Login</button>
				</form>
				<a href="${pageContext.request.contextPath}/register">Register</a>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<footer class="footer">
		<div class="container">
			<p class="text-muted">
				<b>reseved @ Mohamed Hatem</b>
			</p>

		</div>
	</footer>
</body>
</html>