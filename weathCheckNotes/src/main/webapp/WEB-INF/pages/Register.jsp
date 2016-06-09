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
				<a class="brand" href="https://orange.com">Orange</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active">
							<a href="${pageContext.request.contextPath}/Register">Register</a>
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
			<form class="form-signin" action="saveUser" method="post">
				<h2 class="form-signin-heading">Please insert your information</h2>
				<input type="text" class="form-control" name="name" placeholder="Your Name" required />
				<br />
				<input type="email" class="form-control" name="email" placeholder="Email Address" required />
				<br />
				<input type="password" class="form-control" name="password" placeholder="Password" required />
				<br />
				<input type="number" class="form-control" name="mobile" placeholder="Mobile" required />
				<br />
				<button class="btn btn-lg btn-primary" type="submit">Submit</button>
			</form>
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