<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 40px;
}
</style>
<body>
<div>

<form action="update" method ="post">
 new Employee name <input type ="text" name ="username"> <br>
  new Dob <input type ="text" name ="dob"> <br>
 new Salary <input type ="number" name ="salary"> <br>
<input type ="submit" value ="updated">
</form>
</div>

</body>
</html>