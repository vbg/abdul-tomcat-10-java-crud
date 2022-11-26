<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update user</title>
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">

	<!-- catching the data form the url and storing them into variables -->
	<%
		String id = request.getParameter("id");
	  	String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
	%>
	
	<!-- if you want to display a java variable into html tag use below notation -->
	<form action="update" method="post">
	User ID : <input type="text" name="id" value="<%=id%>" readonly><br>
	User name : <input type="text" name="name" value="<%=name%>"><br>
	User password : <input type="password" name="password" value="<%=pwd%>"><br>
	User email : <input type="email" name="email" value="<%=email%>"><br>
	User mobile : <input type="text" name="mobile" value="<%=mobile%>"><br>
	
	<input type="submit" name="submit" value="Update my data"><br>
	</form>
	
	<!-- JS alert for registration is done -->
	
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
	<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>  
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if (status == "updatefailed") {
		swal("Sorry","update failed","error");
	}
	</script>
</body>
</html>