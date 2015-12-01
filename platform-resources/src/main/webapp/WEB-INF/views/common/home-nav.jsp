<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container" style="width: 104.6%; margin-left: -10px;">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<!-- 导航栏 -->
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header navbar-left">
					<img class="img-rounded" style="display:inline;width: 32%;height: 32%" src="${basePath}/images/logo.jpg" alt="logo">
				</div>
				<div style="margin-top:20px;margin-left: -80px;" class="navbar-header navbar-left">
					<span>
						<h3 style="display:inline">学生管理服务平台</h3>
					</span>
				</div>
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav navbar-left">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								用户信息<strong class="caret"></strong>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										学生信息管理<strong class="caret"></strong>
									</a>
									<ul class="dropdown-menu">
										<li><a href="#">学生成绩管理</a></li>
										<li class="divider"></li>
										<li><a href="#">学生评语管理</a></li>
									</ul>
								</li>
								<li class="divider"></li>
								<li><a href="#">教师信息管理</a></li>
								<li class="divider"></li>
								<li><a href="#">家长信息管理</a></li>
								<li class="divider"></li>
								<li><a href="#">管理员信息管理</a></li>
								<li class="divider"></li>
								<li><a href="#">密码管理</a></li>
							</ul>
						</li>
						<li class="divider-vertical"><br></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								应用中心<strong class="caret"></strong>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">消息中心</a></li>
								<li class="divider"></li>
								<li><a href="#">待办事项</a></li>
								<li class="divider"></li>
								<li><a href="#">记事管理</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								系统管理<strong class="caret"></strong>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">管理员信息</a></li>
								<li class="divider"></li>
								<li><a href="#">权限管理</a></li>
								<li class="divider"></li>
								<li><a href="#">登录日志查看</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="navbar-header navbar-right">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2"> 
					</button>
					<a class="navbar-brand" href="home">我的首页</a>
				</div>
			</nav>
		</div>
	</div>
</div>
