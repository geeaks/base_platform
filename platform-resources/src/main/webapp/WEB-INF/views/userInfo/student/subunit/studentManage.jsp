<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span12">
					<!-- 表格部分 -->
					<jsp:include page="student-table.jsp" />
					<!-- 分页插件 -->
					<jsp:include page="../../../common/common-page.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</div>