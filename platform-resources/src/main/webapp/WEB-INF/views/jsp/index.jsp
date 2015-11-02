<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页</title>
</head>
<body style="border: 1px;border-left: 300px;border-top: 100px;" >
	<div style="border: 1px;border-left: 300px;border-top: 100px;" >
		<form method="post" action="login">
			<table style="border: 1px;border-left: 300px;border-top: 100px;" >
				<tr>
					<td>登录名</td>
					<td>
						<input id="userName" name="userName" type="text" />
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input id="password" name="password" type="password" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="password" name="password" type="submit" value="点击登录" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
