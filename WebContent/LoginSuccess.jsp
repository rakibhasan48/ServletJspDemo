</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<html>
	
	<body>
	
		<c:set var="uname" value="${name}"/>
		
		<div class="alert alert-success">
			<span style="text-align:center">Welcome ${cookie.user.value}, you have successfully logged in.</span>
		</div>
		
	
	</body>

</html>