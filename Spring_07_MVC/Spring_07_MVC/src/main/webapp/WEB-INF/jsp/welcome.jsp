<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
Welcome ${username}.

<div align="center">

	<form method="post" action="/Spring_07_MVC/submitBook">
			<h3>${heading}</h3> 
		ID: <input type="number" name="bookId"> <br>
		Name: <input type="text" name="bookName"><br>
		Author: <input type="text" name="bookAuthor"><br>
		<button type="submit">Submit</button>
	</form>
</div>

<form action="/Spring_07_MVC/login">
	<button type="submit">Logout</button>
</form>

</body>
</html>