﻿<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>忘记登录密码</title>
</head>
<body>
<!-- 顶部导航栏 -->
<jsp:include page="../common/common-topnav.jsp" />
<div class="container">
	<!-- 导航栏 -->
	<jsp:include page="index/index-nav.jsp" />
	<div class="row clearfix">
		<!-- 登录表单 -->
		<jsp:include page="index/forgetPwd-Form.jsp" />
	</div>
</div>
<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>
