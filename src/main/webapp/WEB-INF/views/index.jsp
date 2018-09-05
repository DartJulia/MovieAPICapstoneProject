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

<h1>Movie Search</h1>
<form action="/search" > <!-- method="POST" -->
Search by Movie Title: <input type="text" name="query">
<button type="submit" class="btn btn-primary">Search</button>

</form>
<br>
<br>
<br>


<h1> Genre Search</h1>
<form action="/genresearch" method="POST"> 
<select name="genreid" class="custom-select" style="width:20%"> <!-- name=color matches request param -->
		<option value="">Select A Genre...</option>
				<option value=18>Drama</option>
				<option value="28">Action</option>
				<option value="16">Animation</option>
				<option value="35">Comedy</option>
				<option value="80">Crime</option>
				<option value="878">Science Fiction</option>
		</select>
<button type="submit" class="btn btn-primary">Search Genre</button>

</form>
<br><br>
<a href="/favoritelist"><button>View Favorites</button></a>

</div>

</body>
</html>