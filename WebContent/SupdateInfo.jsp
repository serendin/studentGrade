<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon" href="#" type="image/png">

<title>学生课程管理系统</title>

<!--dynamic table-->
<link href="js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
<link href="js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="js/data-tables/DT_bootstrap.css" />

<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">

</head>

<body class="sticky-header">

	<section>
		<!-- left side start-->
		<div class="left-side sticky-left-side">
			<h3>
				<font color="white">学生课程管理系统</font>
			</h3>
			<div class="left-side-inner">

				<!--sidebar nav start-->
				<ul class="nav nav-pills nav-stacked custom-nav">
					<li><a href="findMessageStuServlet"><i class="fa fa-home"></i><span>我的信息</span></a></li>
					<li><a href="findCourseStuServlet"><i class="fa fa-tasks"></i><span>选课</span></a></li>
					<li><a href="findGradeStuServlet"><i
							class="fa fa-bar-chart-o"></i> <span>查询成绩</span></a></li>
				</ul>
				<!--sidebar nav end-->

			</div>
		</div>
		<!-- left side end-->

		<!-- main content start-->
		<div class="main-content">

			<!-- header section start-->
			<div class="header-section">

				<!--toggle button start-->
				<a class="toggle-btn"><i class="fa fa-bars"></i></a>
				<!--toggle button end-->

				<!--search start-->
				<form class="searchform" action="index.html" method="post">
					<input type="text" class="form-control" name="keyword"
						placeholder="Search here..." />
				</form>
				<!--search end-->

				<!--notification menu start -->
				<div class="menu-right">
					<ul class="notification-menu">
						<li><a href="#" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown"> ${user.name} <span class="caret"></span>
						</a>
							<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
								<li><a href="login.jsp"><i class="fa fa-sign-out"></i>
										Log Out</a></li>
							</ul></li>
					</ul>
				</div>
				<!--notification menu end -->
			</div>
			<!-- header section end-->
			<!--body wrapper start-->
			<div class="wrapper">
				<div class="row">
					<div class="col-sm-6">
						<section class="panel">
							<header class="panel-heading">
								基本信息 <span class="tools pull-right"> <a
									href="javascript:;" class="fa fa-chevron-down"></a> <a
									href="javascript:;" class="fa fa-times"></a>
								</span>
							</header>
							<div class="panel-body">
								<form action="updateMessageStuServlet" method="post">
									<table class="table">
										<tbody>
											<tr>
												<td><strong>学号</strong></td>
												<td>${student.sno}</td>
											</tr>
											<tr>
												<td><strong>姓名</strong></td>
												<td><input class="form-control" type="text" name="name"
													value="${student.name}" /></td>
											</tr>
											<tr>
												<td><strong>性别</strong></td>
												<td><input class="form-control" type="text" name="sex"
													value="${student.sex}" /></td>
											</tr>
											<tr>
												<td><strong>班级</strong></td>
												<td><input class="form-control" type="text"
													name="class" value="${student.sclass}" /></td>
											</tr>
											<tr>
												<td><strong>出生年月</strong></td>
												<td><input class="form-control" type="text"
													name="birth" value="${student.birth}" /></td>
											</tr>
											<tr>
												<td><strong>联系电话</strong></td>
												<td><input class="form-control" type="text"
													name="phone" value="${student.phone}" /></td>
											</tr>
										</tbody>
									</table>
									<input class="btn btn-primary pull-right" type="submit"
										value="保存">
								</form>
							</div>
						</section>
					</div>
				</div>
			</div>
			<!--body wrapper end-->
		</div>
		<!-- main content end-->
	</section>

	<!-- Placed js at the end of the document so the pages load faster -->
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="js/jquery-migrate-1.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/modernizr.min.js"></script>
	<script src="js/jquery.nicescroll.js"></script>

	<!--multi-select-->
	<script type="text/javascript"
		src="js/jquery-multi-select/js/jquery.multi-select.js"></script>
	<script type="text/javascript"
		src="js/jquery-multi-select/js/jquery.quicksearch.js"></script>
	<script src="js/multi-select-init.js"></script>
	<!--icheck -->
	<script src="js/iCheck/jquery.icheck.js"></script>
	<script src="js/icheck-init.js"></script>
	<!--dynamic table-->
	<script type="text/javascript"
		src="js/advanced-datatable/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/data-tables/DT_bootstrap.js"></script>
	<!--dynamic table initialization -->
	<script src="js/dynamic_table_init.js"></script>

	<!--common scripts for all pages-->
	<script src="js/scripts.js"></script>

</body>
</html>

