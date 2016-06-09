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
							<a href="${pageContext.request.contextPath}/Weather">Home</a>
						</li>
						<c:if test="${loginUser.getType() == 1}">
							<li class="active">
								<a href="${pageContext.request.contextPath}/AdminPanel">AdminPanel</a>
							</li>
						</c:if>
					</ul>
				</div>
				<div class="pull-right">
					<form class="form-signin" action="logOut" method="post">
						<font style="color: white">Welcom  ${loginUser.getName()}</font>
						<button class="btn btn-lg btn-primary" type="submit">Log out</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Container -->
	<div class="container">
		<div class="wrapper">
			<br />
			<br />
			<br />
			<c:if test="${not empty temp}">
				<font Style="color: blue; font-size: 42"> ${temp}</font>
				<br />
				<br />
				<br />
				<br />
				<font Style="font-size: 20">Min ${temp_min}</font>

				<font Style="font-size: 20">Max ${temp_max}</font>
				<br />
				<font Style="font-size: 20">System Note : ${note}</font>
				<br />
			</c:if>

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