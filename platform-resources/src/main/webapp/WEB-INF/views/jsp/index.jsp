<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页</title>
</head>
<body>
	<form method="post" action="login">
		<table style="border: 0px;left: 300px;top: 100px;" >
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
</body>
</html>
