<%@ page contentType="text/html;charset=UTF-8"%>
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
	<!-- 信息主体部分 -->
	<jsp:include page="./subunit/home-info.jsp" />
	<div class="container" style="background: white; width: 102.1%;margin-left: 3px;">
		<!-- 待办事项部分 -->
		<jsp:include page="./subunit/home-items.jsp" />
		<!-- 分页部分 -->
		<jsp:include page="../common/common-page.jsp" />
	</div>
</div>
<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>
