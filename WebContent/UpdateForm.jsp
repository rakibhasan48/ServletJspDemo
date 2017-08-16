<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>DB Demo</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<style>
	body{
		margin-top:7.5rem;
	}
	.form-control {height: auto;}
	.form-check-input{padding-right: 20px;}
	.list{
		background-color: #2f5572;
		color: white;
		text-decoration: none;
		display: inline-block;
		font-size: 1.25rem;
		padding: 2rem 4.0rem;
	}
	a:hover{
		color: white;	
	}
</style>

</head>
	<body>
	<div style="width : 30%; margin: 25px auto;">
		<form action="updateUser?upName=${param.name}" method="POST">
			<div class="form-group">
				<h3><span class="label label-default">Enter username : </span><br></h3>
				<c:set var="name" value="${name}"/>
				<input class="form-control" type="text" name="uname" value="${param.name}"><br>
			</div>
			
			<div class="form-group">
				<h3><span class="label label-default">Enter Password : </span><br></h3>
				<c:set var="pass" value="${pass}"/>
				<input class="form-control" type="password" name="pass" value="${param.pass}"><br>
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
				<br><br><button class="btn btn-lg btn-primary btn-block form-control">Save To Database</button>
			</div>
			
		</form>
	</div>
	
		<h3 style="text-align: center;"><a href="listUsers" class="list">List All Users</a></h3>
		
	</body>
</html>