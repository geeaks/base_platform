﻿<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 顶端导航栏目 -->
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		</button>
		<a class="navbar-brand" href="${basePath}/">GTS Platform</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right" style="margin-right: 100px;">
			<li>
				<a href="${basePath}/">登录</a>
			</li>
			<li>
				<a href="#">注册</a>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					客户服务<strong class="caret"></strong>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">服务大厅</a></li>
					<li class="divider"></li>
					<li><a href="#">自助服务</a></li>
					<li class="divider"></li>
					<li><a href="#">提建议</a></li>
				</ul>
			</li>
		</ul>
	</div>
</nav>
