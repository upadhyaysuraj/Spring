<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book inserted</title>
</head>
<body>
${heading}<br><br>
Book Details:<br>
ID: ${book.bookId}<br>
Name: ${book.bookName}<br>
Author: ${book.bookAuthor}<br>

<form action="/Spring_07_MVC/login">
	<button type="submit">Logout</button>
</form>

</body>
</html>