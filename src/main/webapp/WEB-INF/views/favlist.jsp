<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="jumbotron">
<h1>Favorites</h1>
<br>
<table class="table table-hover">
			<thead>
				<tr class="table-active">
					<th>Title</th>
					<th>Release Date</th>
					<th>Overview</th>
					<th>ID</th>
					<th>Action</th>
				</tr>

				<c:forEach var="m" items="${movies}">


					<tr class="table-primary">
						<td>${m.title}</td>
						<td>${m.releasedate}</td>
						<td>${m.overview}</td>
						<td>${m.movieid}</td>
						<td><a href="${m.movieid}/delete"><button class="btn btn-secondary">Delete</button></a>
					</tr>
				</c:forEach>
		</table>
		<a href="/">Go back</a>
		</div>
</body>
</html>