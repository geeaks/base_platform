POM配置文件说明：

数据库驱动：
member.jdbc.driver

数据库地址
member.jdbc.url

数据库用户名
member.jdbc.username

数据库密码
member.jdbc.password

连接池的最大数据库连接数，设为0表示无限制
oracle.jdbc.maxActive

超时等待时间以毫秒为单位
oracle.jdbc.maxWait

初始化连接
oracle.jdbc.initialSize

没有人用连接的时候，最大闲置的连接个数，设置为0时，表示没有限制。
oracle.jdbc.maxIdle

没有人用连接的时候，最小闲置的连接个数，设置为0时，表示没有限制。
oracle.jdbc.minIdle
				

dubbo注册地址
dubbo.registry

dubbo超时时间
dubbo.service.timeout


重试次数
dubbo.service.retries
dubbo注册端口
dubbo.member.service.port
会员dubbo服务版本
dubbo.member.service.version

账户dubbo服务版本
dubbo.account.service.version

统一支付dubbo服务版本
<dubbo.payment.service.version
				
交易dubbo服务版本
<dubbo.trade.service.version

渠道dubbo服务版本
<dubbo.channel.service.version
	
网关dubbo服务版本			
<dubbo.gateway.service.version
				
p2p会员服务版本
<dubbo.p2p.member.service.version
		

会员ip
member.host
	
交易ip
trade.host
	
收银台ip
cashier.host
	
渠道ip
channel.host

账户ip	
account.host
	
统一支付ip
payment.host

网关ip
gateway.host
	
protection.system.host.ip
protection.system.host.port

mqip
mq.host.ip

mq端口	
<mq.host.port
	
redis ip
redis.host.ip
	
redis 端口
redis.host.port
	
log 地址
loggingRoot
	
log级别
loggingLevel



