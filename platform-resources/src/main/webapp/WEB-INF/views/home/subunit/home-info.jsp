<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 卡片 -->
<div class="container">
<div class="row clearfix">
	<!-- 用户信息卡片 -->
	<div class="col-md-4 card-container">
		<div class="card">
			<div class="card-title" style="padding-bottom:15px;">用户信息<a href="userInfo">详情</a></div>
			<div style="margin-top:8px;">
				用户姓名：<span id="">${session_user.name}</span>
			</div>
			<div style="margin-top:20px;">
				用户角色：<span id="">
					<c:choose>
						<c:when test="${session_user.userType eq 'student'}">
							学生
						</c:when>
						<c:when test="${session_user.userType eq 'teacher'}">
							教师
						</c:when>
						<c:when test="${session_user.userType eq 'genearch'}">
							家长
						</c:when>
						<c:when test="${session_user.userType eq 'manager'}">
							管理员
						</c:when>
						<c:otherwise>
							未知
						</c:otherwise>
					</c:choose>
				</span>
			</div>
			<div style="margin-top:20px;">
				上次登录时间：<span id="">${session_login_info.strLastLoginTime}</span>
			</div>
		</div>
	</div>
	<!-- 用户记事卡片 -->
	<div class="col-md-4 card-container">
		<div class="card">
			<div class="card-title" style="padding-bottom:15px;">我的记事<a href="notice/noticeList">更多</a></div>
			<ul>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1448015745416">今天SDD打飞机-2015-11-20</a>
				</li>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446805841359">今天SDD还打飞机-2015-11-20</a>
				</li>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446601799312">今天SDD就打飞机-2015-11-20</a>
				</li>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446601799312">今天SDD爱打飞机-2015-11-20</a>
				</li>
			</ul>
		</div>
	</div>
	<!--公告卡片 -->
	<div class="col-md-4 card-container">
		<div class="card">
			<div class="card-title" style="padding-bottom:15px;">消息中心<a href="newsCenter/messageList">更多</a></div>
			<ul>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1448015745416">明天地震啊</a>
					<span style="margin-right:40px;" class="pull-right">2015/11/20</span>
				</li>
				
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446805841359">后天海啸啊</a>
					<span style="margin-right:40px;" class="pull-right">2015/11/06</span>
				</li>
				
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446601799312">前天泥石流啊</a>
					<span style="margin-right:40px;" class="pull-right">2015/11/04</span>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>
