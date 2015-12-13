﻿﻿<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>首页</title>
</head>
<body>
	<!-- 顶部导航栏 -->
	<jsp:include page="../common/common-topnav.jsp" />
	<div class="container">
		<!-- 导航栏 -->
		<jsp:include page="../common/home-nav.jsp" />
		<div class="row-fluid" style="margin-top: 26px;">
			<div class="col-md-3 column">
				<!-- 应用中心左侧导航  -->
				<jsp:include page="subunit/app-nav.jsp" />
			</div>
			<div class="col-md-9 column">
				<!-- 消息中心展示 -->
			</div>
		</div>
	</div>
	<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>
