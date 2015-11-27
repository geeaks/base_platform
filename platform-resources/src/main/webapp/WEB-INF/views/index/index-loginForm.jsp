<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<style>
#imgCode{cursor: pointer;width: 100%;height: 100%}
</style>
<!-- 登录表单 -->
<div class="col-md-4 column">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form id="loginForm" name="loginForm" action="login" method="post" class="form-horizontal" role="form">
				<div id="alertDiv" class="alert alert-dismissable alert-danger" hidden="hidden">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<span id="alertAttr" value="" />
					<span id="alertMsg"></span>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input id="loginId" name="loginId" class="form-control" type="text" placeholder="登录名:手机号码/邮箱" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input id="password" name="password" class="form-control" type="password" placeholder="登录密码" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-6">
						<input id="checkCode" name="checkCode" class="form-control" type="text" placeholder="验证码" />
					</div>
					<div class="col-sm-6">
						<img id="imgCode" class="img-rounded" onclick="reloadImgCode()" src="${basePath}/getImgCode" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<button type="submit" class="btn btn-default btn-block">登录</button>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<div class="checkbox">
							<label><input id="rememberMe" type="checkbox" />记住用户名</label>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>