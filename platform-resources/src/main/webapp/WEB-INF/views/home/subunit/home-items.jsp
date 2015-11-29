<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 卡片 -->
<div class="row clearfix">
	<div class="col-md-12 column">
		<h3>待办事项</h3>
		<div style="text-align: right;" >
			<form class="form-search " style="margin-right: 100px;margin-bottom: 20px;">
				<span>发起人:</span>
				<input class="input-medium search-query" type="text" />
				<button type="submit" class="btn" style="margin-left: 20px; border-top-width: 0px; padding-top: 3px;">查找</button>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>编号</th>
					<th>类型</th>
					<th>名称</th>
					<th>内容</th>
					<th>状态</th>
					<th>发起人</th>
					<th>处理人</th>
					<th>发起时间</th>
					<th>处理时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>请假</td>
					<td>躺好被插</td>
					<td>躺好被强势插入了</td>
					<td>成功</td>
					<td>躺好</td>
					<td>祥爷</td>
					<td>2015-11-28 14:47:48</td>
					<td>2015-11-29 15:11:20</td>
					<td>
						<a href="#">处理</a>
					</td>
				</tr>
				<tr class="success">
					<td>2</td>
					<td>交费</td>
					<td>交补课费</td>
					<td>学习了xxx，交补课费</td>
					<td>成功</td>
					<td>躺好</td>
					<td>祥爷</td>
					<td>2015-11-28 14:47:48</td>
					<td>2015-11-29 15:11:20</td>
					<td>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
