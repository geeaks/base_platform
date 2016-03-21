<%@ page contentType="text/html;charset=UTF-8"%>
<div class="panel panel-default">
	<div class="panel-heading">我的信息</div>
	<table class="table">
		<tr>
			<td>姓名:</td>
			<td>${session_user.name}</td>
			<td>年龄:</td>
			<td>${session_user.age}</td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>${session_user.gender}</td>
			<td>职业:</td>
			<td>${session_user.userType}</td>
		</tr>
		<tr>
			<td>手机:</td>
			<td>${session_user.mobile}</td>
			<td>邮箱:</td>
			<td>${session_user.email}</td>
		</tr>
		<tr>
			<td>职位:</td>
			<td>${session_user.job}</td>
			<td></td>
			<td></td>
		</tr>
	</table>
</div>