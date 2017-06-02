<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon" href="#" type="image/png">

<title>Login</title>

<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">


<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>

</head>

<body class="login-body">
	<div class="container">
		<form class="form-signin" action="LoginServlet" method="post">
			<div class="form-signin-heading text-center">
				<h1 class="sign-title">Sign In</h1>
			</div>
			<div class="login-wrap">
				<select name="userType" class="form-control">
					<option value="notchoose">--用户类型--</option>
					<option value="manager">管理员</option>
					<option value="student">学生</option>
					<option value="teacher">教师</option>
				</select> <br> <input type="text" class="form-control" name="useid"
					placeholder="User ID" autofocus> <input type="password"
					class="form-control" placeholder="Password" name="password">
				${message}
				<button class="btn btn-lg btn-login btn-block" type="submit">
					<i class="fa fa-check"></i>
				</button>
				<div class="registration">
					Not a member yet? <a class="" href="registration.html"> Signup
					</a>
				</div>
				<label class="checkbox"> <input type="checkbox"
					value="remember-me"> Remember me <span class="pull-right">
						<a data-toggle="modal" href="#myModal"> Forgot Password?</a>
				</span>
				</label>

			</div>

			<!-- Modal -->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
				tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Forgot Password ?</h4>
						</div>
						<div class="modal-body">
							<p>Enter your e-mail address below to reset your password.</p>
							<input type="text" name="email" placeholder="Email"
								autocomplete="off" class="form-control placeholder-no-fix">

						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">Cancel</button>
							<button class="btn btn-primary" type="button">Submit</button>
						</div>
					</div>
				</div>
			</div>
			<!-- modal -->
		</form>

	</div>

	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/modernizr.min.js"></script>

</body>
</html>