<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css"/>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'font-awesome.min.css')}" type="text/css">
	</head>
	<body>
		<div class="container" id="login-block">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4">
	
					<div class="login-box clearfix animated flipInY">
						<div class="page-icon animated bounceInDown">
							<img class="img-responsive" src="${resource(dir: 'images', file: 'login-key-icon.png')}" alt="Key icon">
						</div>
						<div class="login-logo">
							<a href="./autenticar">
							<img src="${resource(dir: 'images', file: 'login-logo.png')}" alt="Company Logo"></a>
						</div>
						<hr>
						<div class="login-form">
							

						<g:if test="${flash.message}">
							<div class="alert alert-danger">
								<button type="button" class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>
	
								<strong> ${flash.message}</strong> 
								<br />
							</div>
						</g:if>

						<g:form controller="login" action="entrar">
								<g:textField name="keyUser" placeholder="User name" class="input-field" /> 
								<g:passwordField name="password" placeholder="Password" class="input-field" />
								<button type="submit" class="btn btn-login">Login</button>
							</g:form>
							<div class="login-links">
								<a href="./autenticar"> Forgot password? </a> 
								<br> 
								<a href="./autenticar">
									Don't have an account? <strong>Sign Up</strong>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${resource(dir: 'js', file: 'jquery-2.0.3.min.js')}'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${resource(dir: 'js', file: 'jquery-1.10.2.min.js')}'>"+"<"+"/script>");
		</script>
		<![endif]-->

		<script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
	</body>
</html>