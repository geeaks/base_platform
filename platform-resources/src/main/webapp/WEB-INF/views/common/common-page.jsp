<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 卡片 -->
<div class="row clearfix" style="text-align: center">
	<div class="col-md-12 column">
		<ul class="pagination">
			<li>
				<a href="#">上一页</a>
			</li>
			<c:forEach var="item" begin="1" end="${page.showPageCount}" step="1" varStatus="index">
				<li>
					<a href="#">${index.index}</a>
				</li>
			</c:forEach>
			<li>
				<a href="#">下一页</a>
			</li>
		</ul>
	</div>
</div>
