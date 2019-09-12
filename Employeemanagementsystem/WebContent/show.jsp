<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> employee details</h3>

Employee id <%= session.getAttribute("id") %> <br>
Name <%= session.getAttribute("name") %> <br>
Date of Birth <%=session.getAttribute("dob") %> <br>
salary <%= session.getAttribute("salary") %> <br>




</body>
</html>