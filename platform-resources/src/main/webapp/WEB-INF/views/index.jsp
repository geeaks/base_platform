<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="common/common-header.jsp" />
<script src="${basePath}/js/index.js" ></script>
<title>欢迎光临</title>
</head>
<body>
<!-- 顶部导航栏 -->
<jsp:include page="common/common-topnav.jsp" />
<div class="container">
	<!-- 导航栏 -->
	<jsp:include page="index/index-nav.jsp" />
	<div class="row clearfix">
		<!-- 幻灯片 -->
		<jsp:include page="index/index-slide.jsp" />
		<!-- 登录表单 -->
		<jsp:include page="index/index-loginForm.jsp" />
	</div>
	<!-- 介绍 -->
	<jsp:include page="index/index-intro.jsp" />
</div>
<jsp:include page="common/common-footnav.jsp" />
</body>
</html>
