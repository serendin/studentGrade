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
					<li><a href="findGradeStuServlet"><i class="fa fa-bar-chart-o"></i> <span>查询成绩</span></a></li>
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
			<div class="wrapper">
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								成绩单 <span class="tools pull-right"> <a
									href="javascript:;" class="fa fa-chevron-down"></a> <a
									href="javascript:;" class="fa fa-times"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<form action="insertGradeServlet.do" method="post">
									<input class="btn btn-primary pull-right" type="submit"
											value="提交" />
										<table class="display table table-bordered table-striped"
											id="dynamic-table">
											<thead>
												<tr>
													<th>学生学号</th>
													<th>课程</th>
													<th>学分</th>
													<th>学时</th>
													<th>成绩</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="grade" items="${sessionScope.grades}"
													varStatus="status">
													<tr>
														<%--为奇数行和偶数行设置不同的背景颜色--%>
														<td>${grade.sno}</td>
														<td>${grade.cname}</td>
														<td>${grade.credit}</td>
														<td>${grade.period}</td>
														<td>${grade.grade}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</form>
								</div>
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

