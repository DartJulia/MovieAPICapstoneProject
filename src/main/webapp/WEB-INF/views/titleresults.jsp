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
	<h1>Search results</h1>
		<table class="table table-hover">
			<thead>
				<tr class="table-active">
					<th>Title</th>
					<th>Release Date</th>
					<th>Overview</th>
					<th>ID</th>
					<th>Action</th>
				</tr>

				<c:forEach var="m" items="${movie}">


					<tr class="table-primary">
						<td>${m.title}</td>
						<td>${m.release_date}</td>
						<td>${m.overview}</td>
						<td>${m.id}</td>
						<td><a href="/favorite/${m.id}/${m.title}/${m.release_date}/${m.overview}/"><button class="btn btn-secondary">Favorite</button></a>
					</tr>
				</c:forEach>
		</table>
		</div>
</body>
</html>