<jsp:include page="header.jsp"/>
 
  
	<div class="forms">
	
		<h2 style="text-align:center">Update Password</h2><br><br>	
		<form action="updateP" method="POST">
			<div class="form-group">
				<input class="form-control" type="text" name="name" placeholder="Enter Username"><br>
			</div>
			
			<div class="form-group">
				<input class="form-control" type="password" name="oldPass" placeholder="Old Password"><br>
			</div>
			
			<div class="form-group">
				<input id="pass" class="form-control" type="password" name="newPass" placeholder="New Password" onChange="checkPass();"><br>
			</div>
			
			<div class="form-group">
				<input id="repass" class="form-control" type="password" placeholder="Retype New Password" onChange="checkPass();"><br>
			</div>
			 
			 <div class="alert alert-success" id="con">
				
			</div>
			 
			 <div class="form-group">
				<br><button class="btn btn-lg btn-primary btn-block form-control" id="submit" disabled>Submit</button>
			</div>
		</form>
		
	</div>

<jsp:include page="footer.jsp"/>