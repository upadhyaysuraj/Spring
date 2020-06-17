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

<form method="post" action="/Spring_06_MVC/send">
	Book Name: <input type="text" value="xyz" name="bookName">
	Book Type: <input type="text" name="bookType">
	<input type="submit" value="submit"> 
</form>

Book Name: ${bookName}
<br>
Book Type: ${bookType}

</body>
</html>