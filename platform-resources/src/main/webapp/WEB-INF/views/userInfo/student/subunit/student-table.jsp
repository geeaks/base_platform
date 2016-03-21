<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 卡片 -->
<div class="row clearfix">
	<div class="col-md-12 column">
		<form action="" class="form-search " style="margin-right: 100px;margin-bottom: 20px;">
			<div style="text-align: right;" >
					<span>发起人:</span>
					<input class="input-medium search-query" type="text" />
					<button type="submit" class="btn" style="margin-left: 20px; border-top-width: 0px; padding-top: 3px;">查找</button>
			</div>
		</form>
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
			</tbody>
		</table>
	</div>
</div>
