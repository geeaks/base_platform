<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="common/common-header.jsp" />
<script src="${basePath}/js/index.js" ></script>
<title>首页</title>
</head>
<body style="margin-top:80px;">
<!-- 顶部导航栏 -->
<jsp:include page="common/common-topnav.jsp" />
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<!-- 导航栏 -->
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
					</button>
					<a class="navbar-brand" href="#">学生</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-left">
						<li>
							<a href="#">教师</a>
						</li>
						<li>
							<a href="#">家长</a>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	
	<!-- 幻灯片 -->
	<div class="row clearfix">
		<div class="col-md-8 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="carousel slide" id="carousel-698850">
						<ol class="carousel-indicators">
							<li data-slide-to="0" data-target="#carousel-698850">
							</li>
							<li data-slide-to="1" data-target="#carousel-698850">
							</li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="images/index/1.png" />
								<div class="carousel-caption">
									<h4>
										SDD
									</h4>
									<p>
										傻弟弟在那里玩耍
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="images/index/2.png" />
								<div class="carousel-caption">
									<h4>
										躺好
									</h4>
									<p>
										躺好在艹大海
									</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-698850" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left"></span>
						</a> 
						<a class="right carousel-control" href="#carousel-698850" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 登录表单 -->
		<div class="col-md-4 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<div class="col-sm-10">
								<input id="loginId" name="loginId" class="form-control" type="text" placeholder="登录名:手机号码/邮箱" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10">
								<input id="password" name="password" class="form-control" type="password" placeholder="登录密码" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-5">
								<input id="checkCode" name="checkCode" class="form-control" type="text" placeholder="验证码" />
							</div>
							<div class="col-sm-5">
								<img id="imgCode" class="img-rounded" style="cursor: pointer;width: 100%;height: 100%" onclick="reloadImgCode()" src="${pageContext.request.contextPath}/getImgCode" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-default btn-block">登录</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10">
								<div class="checkbox">
									<label><input id="rememberMe" type="checkbox" />记住用户名</label>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
			<h2>
				关于学生
			</h2>
			<p>
				床前明月光，地上鞋两双，床上狗男女，躺好和弟弟。
			</p>
			<p><a class="btn" href="#">View details »</a></p>
		</div>
		<div class="col-md-4 column">
			<h2>
				关于教师
			</h2>
			<p>
				床前明月光，地上鞋两双，床上狗男女，躺好和弟弟。
			</p>
			<p><a class="btn" href="#">View details »</a></p>
		</div>
		<div class="col-md-4 column">
			<h2>
				关于家长
			</h2>
			<p>
				床前明月光，地上鞋两双，床上狗男女，躺好和弟弟。
			</p>
			<p><a class="btn" href="#">View details »</a></p>
		</div>
	</div>
</div>
<jsp:include page="common/common-footnav.jsp" />
</body>
</html>
