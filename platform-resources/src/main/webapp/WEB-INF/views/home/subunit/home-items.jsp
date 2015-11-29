<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 卡片 -->
<div class="row clearfix">
	<div class="col-md-12 column">
		<h3>待办事项</h3>
		<div style="text-align: right;" >
			<form action="" class="form-search " style="margin-right: 100px;margin-bottom: 20px;">
				<span>发起人:</span>
				<input class="input-medium search-query" type="text" />
				<button type="submit" class="btn" style="margin-left: 20px; border-top-width: 0px; padding-top: 3px;">查找</button>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>内容</th>
					<th>类型</th>
					<th>状态</th>
					<th>发起人</th>
					<th>处理人</th>
					<th>发起时间</th>
					<th>处理时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pendingItem" items="${pendingItems}" varStatus="index" >
					<tr <c:if test="${index.index % 2 == 0}"> class="success" </c:if>
					<c:if test="${index.index % 2 == 1}"> class="warning" </c:if>>
						<td>${pendingItem.itemId}</td>
						<td>${pendingItem.itemName}</td>
						<td>${pendingItem.itemContent}</td>
						<td>${pendingItem.itemType}</td>
						<td>
							<c:choose>
								<c:when test="${pendingItem.handlerStatus eq 'S'}">
									成功
								</c:when>
								<c:when test="${pendingItem.handlerStatus eq 'F'}">
									失败
								</c:when>
								<c:when test="${pendingItem.handlerStatus eq 'I'}">
									处理中
								</c:when>
							</c:choose>
							
						</td>
						<td>${pendingItem.applicantName}</td>
						<td>${pendingItem.handlerName}</td>
						<td>${pendingItem.strGmtCreate}</td>
						<td>${pendingItem.strGmtModify}</td>
						<td>
							<c:if test="${pendingItem.handlerStatus eq 'I'}">
								<a href="#">处理</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
