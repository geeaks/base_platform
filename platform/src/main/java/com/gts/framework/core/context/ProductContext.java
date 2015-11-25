package com.gts.framework.core.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.gts.framework.core.model.GtsBaseModel;
import com.gts.framework.core.model.ProductEnvironment;
import com.gts.framework.core.model.ProductUser;

/**
 * @Description: 产品上下文
 * @ClassName: ProductContext
 * @author gaoxiang
 * @date 2015年11月18日 下午9:48:03
 */ 
public class ProductContext extends GtsBaseModel {
	
	private static final long serialVersionUID = -6071432986457262124L;
	
	/** 产品请求的URL地址 */
	@Expose
	private String url;
	
	/** 用户请求的服务ID，由入口产品所在环境分配 */
	@Expose
	private String requestId;
	
	/** 产品编码 (暂无规划) */
	@Expose
	private String productCode;
	
	/** 产品版本 */
	@Expose
	private String productVersion;
	
	/** 服务链路，用服务code来标记 */
	@Expose
	private List<String[]> serviceCodeStack;
	
	/** 操作环境 */
	@SerializedName("env")
	@Expose
	private ProductEnvironment environment;
	
	/** 产品使用者 */
	@SerializedName("user")
	@Expose
	private ProductUser user;
	
	/** 操作主体是否通过身份验证(即是否成功登录) */
	@Expose
	private boolean authenticated = false;
	
	/** 操作时间 */
	@Expose
	private Date time;
	
	/** 运营活动ID */
	@Expose
	private String activityId;
	
	/**
	 * 活动来源 ，例如来自SINA网站等，也可以说GOOGLE等搜索引擎
	 */
	@Expose
	private String referer;
	
	// ----- 下面的属性主要为Thread共享使用，不需要把其中的属性进行网络传输---------
	/**
	 * 存储环境数据
	 */
	private transient Map<String, Object> context = null;
	
	/**
	 * 默认构造函数,主要为序列化
	 */
	public ProductContext() {
		this(false);
	}
	
	/**
	 * 指定当前安全状况
	 * 
	 * @param authenticated
	 */
	public ProductContext(boolean authenticated) {
		this.authenticated = authenticated;
		environment = new ProductEnvironment();
		user = new ProductUser();
		time = new Date();
		requestId = UUID.randomUUID().toString();
	}
	
	public ProductEnvironment getEnvironment() {
		return environment;
	}
	
	public void setEnvironment(ProductEnvironment environment) {
		this.environment = environment;
	}
	
	public ProductUser getUser() {
		return user;
	}
	
	public void setUser(ProductUser user) {
		this.user = user;
	}
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getProductVersion() {
		return productVersion;
	}
	
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	
	public List<String[]> getServiceCodeStack() {
		return serviceCodeStack;
	}
	
	public void setServiceCodeStack(List<String[]> serviceCodeStack) {
		this.serviceCodeStack = serviceCodeStack;
	}
	
	/**
	 * 方便的方法，便于加入服务编码和版本
	 * 
	 * @param code
	 * @param version
	 */
	public void addServiceCodeAndVersion(String code, String version) {
		if (null == this.serviceCodeStack) {
			this.serviceCodeStack = new ArrayList<String[]>();
		}
		this.serviceCodeStack.add(new String[] { code, version });
	}
	
	/**
	 * 方便的方法，获取当前服务编码和版本
	 * 
	 * @return
	 */
	public String[] lookCurrentServiceCodeAndVersion() {
		if (null == serviceCodeStack) {
			return new String[] { "", "" };
		} else {
			return this.serviceCodeStack.get(this.serviceCodeStack.size() - 1);
		}
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getRequestId() {
		return requestId;
	}
	
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	public String getActivityId() {
		return activityId;
	}
	
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	public String getReferer() {
		return referer;
	}
	
	public void setReferer(String referer) {
		this.referer = referer;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 向环境中放置数据
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		if (null == context) {
			context = Collections.synchronizedMap(new HashMap<String, Object>());
		}
		context.put(key, value);
	}
	
	/**
	 * 从环境中获取数据
	 * 
	 * @param key
	 * @return
	 */
	public Object find(String key) {
		if (null == context) {
			context = Collections.synchronizedMap(new HashMap<String, Object>());
		}
		return context.get(key);
	}
	
	/**
	 * 释放缓存中的数据
	 */
	public void clean() {
		if (null != context) {
			context.clear();
		}
	}
}
