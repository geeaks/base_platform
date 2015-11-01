<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人首页</title>
    <link href="${staticMemberPath}/new/css/common.css" rel="stylesheet" type="text/css">
    <link href="${staticMemberPath}/css/bootstrap.css" rel="stylesheet">
    <script src="${staticMemberPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${staticMemberPath}/js/bootstrap.min.js"></script>
    <script src="${staticMemberPath}/js/commons/holder.min.js"></script>
    <!--[if lte IE 9]>
	<script src="${staticMemberPath}/js/commons/respond.min.js">
	<script src="${staticMemberPath}/js/commons/html5shiv.min.js"></script>
	<![endif]-->
    <style>
    	#tan3>ul li:hover{
    		background-color: #ea5529;
    		color: #fff;
    	}
    </style>
  </head>
  <body>
  <c:set var="tab1" value="10" scope="application"/>
  <c:set var="tab" value="1" scope="application"/>
  <c:import url="/common/head.htm"></c:import>
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  <div class=""></div>
	  <div class="carousel-inner add-height">
	    <div class="item active person-image">
			<div class="user-inf">
				<span class="name">您好，${userName}</span></br>
				<span class="count">账户名：${cell}</span>
				<c:if test="${user.realnameStatus=='T'}">
					<span class="position-ab"><div id="verifyDiv" class="tan">你已通过先锋支付实名认证</br><span class="gray">点击图标查看详情</span></a><div class="tri"></div></div>
					<img src="${staticMemberPath}/images/user-sm.png" id="verifyImg"></span>
				</c:if>
				<c:if test="${user.realnameStatus!='T'}">
					<span class="position-ab"><div id="verifyDiv" class="tan">申请实名认证后，可享受更多特权</br>
					<span class="gray">点击图标立即认证</span></a><div class="tri"></div></div>
					<img id="verifyImg" status="0" src="${staticMemberPath}/images/user-sm_unable.png">
				</c:if>
				<c:if test="${user.pinAnsw!=null && user.pinAnsw!=''}">
					<span class="position-ab"><div id="ansDiv" class="tan">你已通过先锋支付实名认证</br>
					<span class="gray">点击图标查看详情</span></a><div class="tri"></div></div>
					<img src="${staticMemberPath}/images/bao.png" id="ansImg"></span>
				</c:if>
				<c:if test="${user.pinAnsw==null || user.pinAnsw==''}">
					<img src="${staticMemberPath}/images/bao_unable.png">
				</c:if>
				<c:if test="${user.enabledStatus=='phone_active'}">
					<span class="position-ab">
						<div id="enabledStatusDiv" class="tan">
							你已通过先锋支付实名认证
							</br>
							<span class="gray">点击图标查看详情</span>
							<div class="tri"></div>
							</a><div class="tri">
							</div>
						</div>
						<img src="${staticMemberPath}/images/phone.png" id="enabledStatusImg">
					</span>
				</c:if>
				<c:if test="${user.enabledStatus!='phone_active'}">
					<img src="${staticMemberPath}/images/phone_unable.png">
				</c:if>
				</span>
				<span class="user-shotline">|</span>
				<span class="count">安全等级：<span class="color-green2">高</span>
				<a href="${basePath}/user/basicinfo.htm" class="yellow ml20">提升</a>
				<span class="user-shotline">|</span><span class="reas"> 
				</span>
				</span>
				<span class="count">上次登录时间：<fmt:formatDate value='${lastLgnTime }' pattern="yyyy-MM-dd HH:mm:ss" /></span>
 			</div>
	    </div>
	  </div>
	</div>
    <div class="container user-all user-firstpp add-gap">
            <div class="user-first">
            <div class="account"><span>账户余额</span></div>
                <span>
                	<c:if test="${error eq '0'}">通讯异常。。。。</c:if>
                        <c:if test="${error ne '0'}">
                        <em class="color-yellow1">
                        	<c:if test="${empty(money)}">0.00</c:if> 
                        	<c:if test="${!empty(money) }"><span class="money">${money}</span></c:if></em>元
                        	<span class="flr" style="color:#999;">余额支付：已开启</span>
                            <div class="withdraw">
                            <a href="${basePath}/recharge/index.htm" class="normal-btn">充 值</a> 
                            <a href="${basePath}/withdraw/index.htm" class="normal-btn" style="margin-left:5px;">提 现</a>
                            </div>
                        </c:if>
                </span>
                <div>
                	
                	<!-- <a href="#" class="flr">管理  ></a> -->
                </div> 
            </div>
            <div class="user-first">
            	<div class="account"><span>工资宝</span><!-- <a href="#" class="flr">更高收益 ></a> --></div>
                <span>
                	<!-- <span class="money">0.00</span> -->
                   <!--  <span class="balance-paid">累计收益：<span class="red">0.00</span>元</span> -->
                    <!-- <div class="withdraw">
                    <a href="#" class="normal-btn">转 入</a> 
                    <a href="#" class="minor-btn" >转 出</a>
                    <a href="#" class="minor-btn" >管 理</a>
                    </div> -->	
                </span>
                <div> <span style="color:#999;">工资宝产品即将推出,敬请期待......</span></div>
            </div>
            <div class="user-first width200 border-none">
            	<div class="account"><span>银行卡</span><a href="${basePath}/bank/index.htm" class="flr">管理 ></a></div>
                <ul>
                <c:forEach items="${bankList}" var="bank" end="2">
                	<c:set var="cardLength" value="${fn:length(bank.cardNo)}" />
                	<c:set var="bankNameLength" value="${fn:length(bank.bankName)}" />
                		<c:set var="bankName" value="${bank.bankName}" />
                	<c:if test="${bankNameLength>6}">
                		<c:set var="bankName" value="${fn:substring(bank.bankName, 0, 4)}.." />
                	</c:if>
                	<li><a href="${basePath}/bank/index.htm" title="${bank.bankName}"><c:out value="${bankName} ( 尾号:${fn:substring(bank.cardNo, cardLength-4, cardLength)} )"/></a></li>
                </c:forEach>
                </ul>
            </div>
    </div>
    
	<div class="container user-all bg-gray">
        	<ul class="nav nav-tabs" id="safe">
              <li class="active"><a href="#home1" data-toggle="tab" class="zc">交易记录</a></li>
              <!--li><a href="#zh" data-toggle="tab" class="zh">资产动态</a></li-->
            </ul>
            <div class="tab-content help-tab-content border-none">
            <div class="tab-pane active" id="home1">
				<div class="detail-title">
					<span class="record" onclick="getTradeList('');" style="cursor:pointer">最近交易记录</span>
		            	<ul>
		                    <li><a onclick="getTradeList('16');" style="cursor:pointer">支付明细</a></li><li>|</li>
		                    <li><a onclick="getTradeList('10');" style="cursor:pointer">充值记录</a></li><li>|</li>
		                    <li><a onclick="getTradeList('14');" style="cursor:pointer">提现记录</a></li><li>|</li>
		                    <!-- 目前暂无 -->
		                    <li><a onclick="getTradeList('null');" style="cursor:pointer">退款记录</a></li><li>|</li>
		                </ul>
					<div class="clear"></div>
				</div>
		        <div class="container">
		        
					<table class="table table-bordered table-striped" id="orderInfo">
					        
					         <c:if test="${neter eq '0'}">通讯异常。。。。</c:if>
		                     <c:if test="${neter ne '0' }">
					        
					        <tbody>
					        	<c:if test="${empty(orders)}">
								    <c:out value="<tr>"  escapeXml="false"></c:out>
								    <c:out value="<td>交易记录为空!</td>" escapeXml="false"></c:out>
								    <c:out value="</tr>" escapeXml="false"></c:out>
								</c:if>
								<c:if test="${!empty(orders)}">
		                    	<c:forEach items="${orders}" var="item" varStatus="order">  
									<tr>
		                        	<td width="210px" style="padding-left:20px;">${item.date}</td>
		                            <td width="100px">${item.typeName}</td>
		                            <c:if test="${item.typeName=='充值'}">
										<td align="right" class="sm-mgr" width="210px">
			                            	<a href="#"  class="color-green" >${item.amount}</a>
				                  		</td>
		                            </c:if>
		                            <c:if test="${item.typeName=='提现' || item.typeName=='支付'}">
		                            	<td  align="right" class="no-mgr" width="210px">
			                            	<a href="#"  class="red">${item.amount}
				                            <span class="jt2">
				                            	<div id="detail${order.index}" style="text-align: center; position: absolute; width: 100px; height: 60px; top: -40px;left: -40px; display:none;">
													<div class="tan2" style="position:static;">点击查看明细</div>
													<div class="tri2" style="position:static;"></div>
				                            	</div>
				                            	<img src="${staticMemberPath}/images/jt2.jpg" class="no-mgl" onmousemove="showDetail(${order.index});">
				                            </span>
				                            </a>
				                    	</td>
		                            </c:if>
		                            <td align="center" width="250px">${item.orderStatus}</td>
		                            <td onmousemove="showDetails(${order.index});" align="right" width="80px" style="padding-right:20px;">
		                            	<a href="#">详情
		                                <span class="jt3">
		                                    <div class="tan3" id="details${order.index}" style="display: none;">
		                                    	<ul>
		                                        	<li>详情</li>
		                                            <li>删除</li>
		                                        </ul>
		                                    </div>
		                                    <img src="${staticMemberPath}/images/jt3.jpg">
		                                </span>
		                            	</a>
		                       		</td>
		                        	</tr>
								</c:forEach>
								</c:if>
					        </tbody>
					        </c:if>
					      </table>
				
		                   <a href="${basePath}/trade/tradeList.htm"  class="flr corner">查看所有交易记录</a>		  
				</div>
              </div>
              <div class="tab-pane" id="zh">
               2
              </div>
            <script type="text/javascript">
            $(function () {
                $('#myTabHelp a:last').tab('show');
               	$("#verifyDiv").hide();
               	$("#verifyImg").mouseover(function(){
               	    $("#verifyDiv").show();
               	 });
               	$("#verifyImg").mouseout(function(){
               	    $("#verifyDiv").hide();
               	});
               	$("#verifyImg").click(function(){
               		if($(this).attr('status')=='0'){
	               		window.open("${basePath}/bank/index.htm"); 
               		}else{
	               		window.open("${basePath}/bank/firstaddbank.htm"); 
               		}
               	 });
               	$("#ansDiv").hide();
               	$("#ansImg").mouseover(function(){
               	    $("#ansDiv").show();
               	 });
               	$("#ansImg").mouseout(function(){
               	    $("#ansDiv").hide();
               	});
            	$("#enabledStatusDiv").hide();
               	$("#enabledStatusImg").mouseover(function(){
               	    $("#enabledStatusDiv").show();
               	 });
               	$("#enabledStatusImg").mouseout(function(){
               	    $("#enabledStatusDiv").hide();
               	});
               	$(document).on("click",hideDetail);
               	$(document).on("mouseover",hideDetails);
              });
              var showedDetail=null;
              function showDetail(index){
            	  showedDetail?showedDetail.hide():"";
            	  showedDetail=$("#detail"+index).show();
            	  showedDetail.on("mouseleave",hideDetail);
              }
              function hideDetail(t){
            	  if(showedDetail){
	            	  showedDetail.hide();
	            	  showedDetail.off("mouseleave",hideDetail);
            	  }
              }
              var showedDetails=null;
              function showDetails(index){
            	  showedDetails?showedDetails.hide():"";
            	  showedDetails=$("#details"+index).show(); 
              }
              function hideDetails(t){
            	  if(!$(t.target).parents("div[class='tan3']").length && showedDetails){
		              showedDetails.hide(); 
            	  }
              }
              function getTradeList(val){
            	  $.ajax({   
                      type:"post",   
                      url:"${basePath}/trade/tradeListBywhere.htm?tradeType="+val,   
                      contentType:"text/html;charset=utf-8",
                      data:"",
                      success: function(data) {
                    	  $("#orderInfo").html(data);
                    	 
                      } 
                  }); 
              }
             
  
            </script>
       </div> 
	</div>
	<div class="container ad">
    	<img src="${staticMemberPath}/images/ad.jpg">	
    </div>
	<c:import url="/WEB-INF/views/jsp/common/newfooter.jsp"></c:import>
  </body>
</html>
