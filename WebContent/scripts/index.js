function checkPass(){
	var pass = $('#pass').val();
	var repass = $('#repass').val();
	
	if(pass.length < 1 || repass.length < 1 || pass != repass){
		$('#con').html("Passwords do not match!");
		$('#submit').attr('disabled', true);
	} else {
		$('#con').html("Passwords match");
		$('#submit').attr('disabled', false);
	}
}

$(document).ready(function(){
	$('#pass, #repass').keyup(checkPass);
	
	$('form').each(function(key, form) {
        $(this).validate(); 
    });
})