package com.gts.framework.core.model;

import com.google.gson.annotations.Expose;

/**
 * @Description: 产品运行环境
 * @ClassName: ProductEnvironment
 * @author gaoxiang
 * @date 2015年11月18日 下午9:48:47
 */ 
public class ProductEnvironment extends GtsBaseModel {
	
	private static final long serialVersionUID = -4693571050861188847L;
	
	/** 客户端IP */
	@Expose
	private String clientIp;
	
	/** 服务器IP */
	@Expose
	private String serverIp;
	
	/** 服务器名称 */
	@Expose
	private String serverName;
	
	/**
	 * 用户使用的代理服务器IP地址，如果没有使用代理服务器proxyIP=null.
	 */
	@Expose
	private String proxyIP;
	
	/**
	 * 用户使用的代理服务器的端口，如果没有使用代理服务器proxyPort=null.
	 */
	@Expose
	private String proxyPort;
	
	/** 会话ID 也即 cookie ID */
	@Expose
	private String sessionId;
	
	/** 客户端的唯一标识 */
	@Expose
	private String edmId;
	
	/**
	 * 客户端类型
	 */
	@Expose
	private String edmType;
	
	/** 可识别的合作者ID */
	@Expose
	private String partnerId;
	
	/**
	 * 空构造器。
	 */
	public ProductEnvironment() {
		super();
	}
	
	/**
	 * 构造器。
	 */
	public ProductEnvironment(String clientIp, String serverIp, String serverName) {
		super();
		
		this.clientIp = clientIp;
		this.serverIp = serverIp;
		this.serverName = serverName;
	}
	
	/**
	 * @return Returns the clientIp.
	 */
	public String getClientIp() {
		return clientIp;
	}
	
	/**
	 * @param clientIp The clientIp to set.
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
	/**
	 * @return Returns the serverIp.
	 */
	public String getServerIp() {
		return serverIp;
	}
	
	/**
	 * @param serverIp The serverIp to set.
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
	/**
	 * @return Returns the serverName.
	 */
	public String getServerName() {
		return serverName;
	}
	
	/**
	 * @param serverName The serverName to set.
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	/**
	 * @return
	 */
	public String getProxyIP() {
		return proxyIP;
	}
	
	/**
	 * @param proxyIP
	 */
	public void setProxyIP(String proxyIP) {
		this.proxyIP = proxyIP;
	}
	
	/**
	 * @return
	 */
	public String getProxyPort() {
		return proxyPort;
	}
	
	/**
	 * @param proxyPort
	 */
	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}
	
	/**
	 * 用户是否使用代理服务器访问
	 * 
	 * @return
	 */
	public boolean useProxy() {
		return proxyIP == null ? false : true;
	}
	
	/**
	 * @return
	 */
	public String getSessionId() {
		return sessionId;
	}
	
	/**
	 * @param sessionId
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getEdmId() {
		return edmId;
	}
	
	public void setEdmId(String edmId) {
		this.edmId = edmId;
	}
	
	public String getEdmType() {
		return edmType;
	}
	
	public void setEdmType(String edmType) {
		this.edmType = edmType;
	}
	
	public String getPartnerId() {
		return partnerId;
	}
	
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
}
