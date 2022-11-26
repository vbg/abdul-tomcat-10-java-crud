<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- importing the tag library connection -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>my account</title>
</head>
<body>

<h1>user page</h1>

<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
	<table>
	<!-- looping the user data using c tag library -->
	
	<c:forEach var="user" items="${userDetails}">
	
	<!-- storing the user data into variables -->
	<c:set var="id" value="${user.id}"/>
	<c:set var="name" value="${user.uname}"/>
	<c:set var="pwd" value="${user.upwd}"/>
	<c:set var="email" value="${user.uemail}"/>
	<c:set var="mobile" value="${user.umobile}"/>
	
	<!-- printing the data to the page -->
	<tr>
		<td>User ID : </td>
		<!-- this calls to the getter of the user class and printing the valuve of the user id -->
		<td>${user.id}</td>
	</tr>
	<tr>
		<td>User name : </td>
		<td>${user.uname}</td>
	</tr>
	<tr>
		<td>Password : </td>
		<td>${user.upwd}</td>
	</tr>
	<tr>
		<td>User Email : </td>
		<td>${user.uemail}</td>
	</tr>
	<tr>
		<td>User Mobile :</td>
		<td>${user.umobile}</td>
	</tr>
	
	</c:forEach>
	</table>
	
	<!-- storing the data into a link that need to pass to another page and storing them in to a single variable -->
	<c:url value="updateuser.jsp" var="userupdate">
		<c:param name="id" value="${id}" />
		<c:param name="name" value="${name}" />
		<c:param name="pwd" value="${pwd}" />
		<c:param name="email" value="${email}" />
		<c:param name="mobile" value="${mobile}" />
	</c:url>
	
	<!-- passing the variable that stored data and the link in the above to the below anchor, so that when we click that button it will redirect us to another page with the data  -->
	<a href="${userupdate}">
	<input type="button" name="update" value="update my data">
	</a>
	<br/>
	
	<!-- to delete data  -->
	<form action="delete" method="post" onsubmit="submitForm();">
	<c:forEach var="user" items="${userDetails}">
	<input type="hidden" name="deletedataid" value="${user.id}">				
	</c:forEach>
	
	<input type="submit" name="submit" value="delete my data">
	</form>

<!-- JS alert for delete is fail -->
	
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
	<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>  
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;

		function submitForm(){
			Swal.fire({
				  title: 'Are you sure?',
				  text: "You won't be able to revert this!",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Yes, delete it!'
				}).then((result) => {
				  if (result.isConfirmed) {
				    Swal.fire(
				      'Deleted!',
				      'Your file has been deleted.',
				      'success'
				    )
				  }
				})
		}
	</script>	
</body>
</html>