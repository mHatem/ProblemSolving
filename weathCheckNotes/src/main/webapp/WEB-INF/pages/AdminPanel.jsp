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
						<li>
							<a href="${pageContext.request.contextPath}/Weather">Home</a>
						</li>
						<li class="active">
							<a href="${pageContext.request.contextPath}/AdminPanel">AdminPanel</a>
						</li>
					</ul>
				</div>
				<div class="pull-right">
					<form class="form-signin" action="logOut" method="post">
						<font style="color: white">Welcom ${loginUser.getName()}</font>
						<button class="btn btn-lg btn-primary" type="submit">Log out</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Container -->
	<div class="container">
		<div class="wrapper">
			<form action="saveNote" method="post">
				<textarea style="width: 400px" name="note" rows="2" maxlength="6000" class="form-control" placeholder="Enter new note for today" required></textarea>
				<br />
				<button class="btn btn-lg btn-primary" type="submit">Add Note</button>
				<c:if test="${not empty message}">
					<p>${message}</p>
					<br />
				</c:if>
			</form>

			<form action="savePreNote" method="post">
				<textarea style="width: 400px" name="note" rows="2" maxlength="6000" class="form-control" placeholder="Enter master note for tempreture from 1 to 10" required></textarea>
				<br />
				<textarea style="width: 400px" name="note2" rows="2" maxlength="6000" class="form-control" placeholder="Enter master note for tempreture from 10 to 15" required></textarea>
				<br />
				<textarea style="width: 400px" name="note3" rows="2" maxlength="6000" class="form-control" placeholder="Enter master note for tempreture from 15 to 20" required></textarea>
				<br />
				<textarea style="width: 400px" name="note4" rows="2" maxlength="6000" class="form-control" placeholder="Enter master note for tempreture more than 20" required></textarea>
				<br />
				<button class="btn btn-lg btn-primary" type="submit">Add Master Notes</button>
			</form>
		</div>
		<div class="table-responsive">



			<c:if test="${not empty userNotes}">
				<table class="table table-striped">

					<thead>
						<tr>
							<th>ID</th>
							<th>Note</th>
							<th>Date</th>
							<th>type</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="note" items="${userNotes}">
								<td>
									<c:out value="${note.id}" />
								</td>

								<td>
									<c:out value="${note.note}" />
								</td>

								<td>
									<c:out value="${note.date}" />
								</td>
								<td>
									<c:out value="${note.type == 0 ?'normal':'Predefined' }" />
								</td>
								<td>
									<form action="deleteNote" method="post">
										<input type="hidden" value="${note.id}" name="noteId" required />
										<button class="btn btn-lg btn-primary" type="submit">Delete</button>
									</form>
								</td>
								<tr>
									<td colspan="2"></td>
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</c:if>

		</div>
	</div>
	<br />
	<br />
	<br />
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