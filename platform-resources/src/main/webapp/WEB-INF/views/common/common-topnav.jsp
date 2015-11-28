<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 顶端导航栏目 -->
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		</button>
		<a class="navbar-brand" href="${basePath}/">GTS Platform</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right" style="margin-right: 100px;">
			<c:choose>
				<c:when test="${session_user ne null}">
					<li>
						<a style="cursor: pointer;" >
							您好，<span class="glyphicon glyphicon-user"></span> ${session_user.name}
						</a>
					</li>
					<li>
						<a style="cursor: pointer;" >
							<span class="glyphicon glyphicon-arrow-right"></span> 退出
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="${basePath}/">登录</a>
					</li>
					<li>
						<a href="#">注册</a>
					</li>
				</c:otherwise>
			</c:choose>
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
