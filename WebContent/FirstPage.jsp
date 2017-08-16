<jsp:include page="header.jsp"/>
<link rel="stylesheet" href="styles/style2.css">

	<div class="forms">
	
		<h2 style="text-align:center">Login</h2><br><br>	
		<form action="login" method="POST">
			<div class="form-group">
				<input class="form-control" type="text" name="uname" placeholder="Username"><br>
			</div>
			
			<div class="form-group">
				<input class="form-control" type="password" name="pass" placeholder="Password"><br>
			</div>
			 
			 <div class="form-group">
				<br><button class="btn btn-lg btn-primary btn-block form-control">Login</button>
			</div>
		</form>
		
		<div>
			<a href="UpPass.jsp" class="anchor">Forgot Password? Click Here!</a>
		</div>
		
		
		<a class="btn btn-diff" href="register">Signup</a>
		
	</div>

<jsp:include page="footer.jsp"/>