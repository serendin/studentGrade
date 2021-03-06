<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Student"%>
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
					<li><a href="manageOp.jsp"><i class="fa fa-home"></i> <span>主页</span></a></li>
					<li class="menu-list"><a href=""><i class="fa fa-tasks"></i>
							<span>课程查询</span></a>
						<ul class="sub-menu-list">
							<li><a href="findTeachServlet"> 教师任课查询</a></li>
						</ul></li>
					<li class="menu-list"><a href=""><i
							class="fa fa-bar-chart-o"></i> <span>成绩查询</span></a>
						<ul class="sub-menu-list">
							<li><a href="findAvgGradeServlet"> 学年统计与排名</a></li>
							<li><a href="findAvgGradeServlet"> 课平均成绩</a></li>
						</ul></li>
					<li class="menu-list"><a href=""><i class="fa fa-book"></i>
							<span>信息查询修改</span></a>
						<ul class="sub-menu-list">
							<li><a href="findStudentServlet"> 学生信息</a></li>
							<li><a href="findTeacherServlet"> 教师信息</a></li>
							<li><a href="findCourseServlet"> 课程信息</a></li>
						</ul></li>
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
							data-toggle="dropdown"> ${user.name } <span class="caret"></span>
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

			<!-- page heading start-->

			<div class="page-heading">
				<h3>学生信息表</h3>
			</div>
			<!-- page heading end-->

			<!--body wrapper start-->
			<span id="studenttable"></span>
			<div class="wrapper">
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								<span class="tools pull-right"> <a href="javascript:;"
									class="fa fa-chevron-down"></a> <a href="javascript:;"
									class="fa fa-times"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<form action="insertStudentServlet.do" method="post">
										<table class="display table table-bordered table-striped"
											id="dynamic-table">
											<thead>
												<tr>
													<th>学号</th>
													<th>姓名</th>
													<th>性别</th>
													<th>出生年月</th>
													<th>班级</th>
													<th>联系电话</th>
													<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="student" items="${sessionScope.students}"
													varStatus="status">
													<tr>
														<%--为奇数行和偶数行设置不同的背景颜色--%>
														<td>${student.sno}</td>
														<td>${student.name}</td>
														<td>${student.sex}</td>
														<td>${student.birth}</td>
														<td>${student.sclass}</td>
														<td>${student.phone}</td>
														<td><a
															href="updateStudentServlet.do?sno=${student.sno}">修改</a>
															&nbsp;&nbsp; <a
															href="deleteStudentServlet.do?sno=${student.sno}">删除</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th>学号</th>
													<th>姓名</th>
													<th>性别</th>
													<th>出生年月</th>
													<th>班级</th>
													<th>联系电话</th>
													<th>操作</th>
												</tr>
												<tr>
													<td><input type="text" name="sno" /></td>
													<td><input type="text" name="name" /></td>
													<td><input type="text" name="sex" /></td>
													<td><input type="text" name="birth" /></td>
													<td><input type="text" name="class" /></td>
													<td><input type="text" name="phone" /></td>
													<td><input class="btn btn-info pull-left" type="submit" value="插入"></td>
												</tr>
											</tfoot>
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

