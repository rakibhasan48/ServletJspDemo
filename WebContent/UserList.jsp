<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<link rel="stylesheet" href="styles/style2.css">
	
		<h1 style="text-align:center">Welcome Admin</h1><br><br>	
		
		<div class="addUser">
			<a class="btn btn-admin" href="register">Add New User</a>
		</div>
		
		
		<div class="container" id="table">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Password</th>
						<th>Qualification</th>
						<th>Language</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tempUser" items="${userList}">
						<tr class="active success">
							<td>${tempUser.uname}</td>
							<td>${tempUser.pass}</td>
							<td>${tempUser.quali}</td>
							<td>${tempUser.lang}</td>
							<td><a href="UpdateForm.jsp?name=${tempUser.uname}&pass=${tempUser.pass}&quali=${tempUser.quali}&lang=${tempUser.lang}">Update</a></td>
							<td><a href="deleteUser?name=${tempUser.uname}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
<jsp:include page="footer.jsp"/>