<jsp:include page="header.jsp"/>

	
	<div class="login">
		<div class="btn-login">
			<h4 class="btn btn-small"><a href="signin">Login</a></h4>
			<h4 class="btn btn-small"><a href="register">SignUp</a></h4>
		</div>	
	</div>
	
	<div class="forms">	
		<form action="signup" method="POST">
			<div class="form-group">
				<h3><span class="label label-default">Enter username : </span><br></h3>
				<input class="form-control" type="text" name="uname" required><br>
			</div>
			
			<div class="form-group">
				<h3><span class="label label-default">Enter Password : </span><br></h3>
				<input class="form-control" type="password" name="pass" required><br>
			</div>
			 
			 <h3><span class="label label-default">Enter Qualtification :</span><br></h3>
			<div class="form-check">
				<label class="form-check-label"><input class="form-check-input"  type="radio" name="quali" value="B.Tech"> B.Tech</label>
				 <label class="form-check-label"><input class="form-check-input"  type="radio" name="quali" value="B.Sc"> B.Sc</label>
				 <label class="form-check-label"><input class="form-check-input"  type="radio" name="quali" value="BCA"> BCA</label>
			</div> 
			
			<h3><span class="label label-default">Enter Languages :</span><br></h3>
			<div class="form-check">
				<label class="form-check-label"><input class="form-check-input"  type="checkbox" name="lang" value="English"> English</label>
				 <label class="form-check-label"><input class="form-check-input"  type="checkbox" name="lang" value="Hindi"> Hindi</label>
				 <label class="form-check-label"><input class="form-check-input" type="checkbox" name="lang" value="Bengali"> Bengali</label>
				 <label class="form-check-label"><input class="form-check-input"  type="checkbox" name="lang" value="Spanish"> Spanish</label>
			</div> 
			 
			 <div class="form-group">
				<br><br><button class="btn btn-lg btn-primary btn-block form-control">Sign Up</button>
			</div>
			
		</form>
	</div>
	
		
		
<jsp:include page="footer.jsp"/>