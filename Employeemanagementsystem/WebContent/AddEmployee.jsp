<%@ page errorPage="fail.jsp" %>  
<jsp:include page="header.jsp"/>

<script>

function formValidate()
{
	var empName=document.getElementById("empName").value;
	if(empName.length<4 || empName.length>15)
		{
		
		document.getElementById("error-msg-name").innerHTML="Name should be of 4 - 15 characters..";
		return false;
		}
	return true;
}

</script>

<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
h3
{
text-align:center;
}
</style>
<body>


<div>
  <h3 > Add Employee</h3>
  
   <form action="add" method="post" onsubmit="return formValidate()">
    <label for="fname">First Name</label>
    <input type="text" name="username" id="empName" placeholder="Your name..">
    
    <p id="error-msg-name" />
    

    <label for="Date of birth">dob</label>
    <input type="text"  name="dob" placeholder=DD/MM/YYYY>

    <label for="salary">salary</label>
    <input type ="text"  name = "salary" placeholder ="enter your salary">
      
    <input type="submit" value="Submit">
     
  </form>
</div>





<jsp:include page="footer.jsp"/>