package com.gts.framework.core.context;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import com.gts.framework.core.constants.CodeType;

/**
 * @Description: 为WEB环境定制的ProductContext容器
 * @ClassName: WebProductContextHolder
 * @author gaoxiang
 * @date 2015年11月17日 下午11:59:56
 */ 
public final class WebProductContextHolder {
	
	private final static String HTTP_SESSION_CONSTANT = "HTTP_SESSION";
	
	/**
	 * 此变量对应的value，会被放置到环境上限文中，交由ResultEncodeFilter做对应业务处理
	 */
	public static final String ENCODE_RETURN_RESULT_CONSTANT = "$$ENCODE_RETURN_RESULT_TAG";
	
	public static final String WEB_CNTXT_RESULT_CONSTANT = "$$WEB_CNTXT_RESULT_CONSTANT";
	
	private static ThreadLocal<ProductContextWrapper> context = new ThreadLocal<ProductContextWrapper>() {
		
		// 初始化值
		@Override
		public ProductContextWrapper initialValue() {
			return new ProductContextWrapper();
		}
	};
	
	/**
	 * @Description: 清空
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:09:04
	 */
	public static void clean() {
		if (null != context.get()) {
			context.get().clean();
			context.set(null);
		}
	}
	
	public static ProductContext getProductContext() {
		ProductContext prdctx = getProductContextWrapper().getProductContext();
		prdctx.put(WEB_CNTXT_RESULT_CONSTANT, true);
		return prdctx;
	}
	
	/**
	 * @Description: 强制覆盖现有的产品环境
	 * @param productContext
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:09:17
	 */
	public static void setProductContext(ProductContext productContext) {
		if (null == context.get()) {
			context.set(new ProductContextWrapper());
			productContext.put(WEB_CNTXT_RESULT_CONSTANT, true);
			context.get().setProductContext(productContext);
		} else {
			productContext.put(WEB_CNTXT_RESULT_CONSTANT, true);
			context.get().setProductContext(productContext);
		}
	}
	
	private static ProductContextWrapper getProductContextWrapper() {
		if (null == context.get()) {
			context.set(new ProductContextWrapper());
		}
		return context.get();
	}
	
	/**
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:12:25
	 */
	public static boolean isWebInitContext() {
		boolean isEncodeResponse = null == getProductContextWrapper().getProductContext()
		.find(WEB_CNTXT_RESULT_CONSTANT) ? false : (Boolean) getProductContextWrapper().getProductContext().find(WEB_CNTXT_RESULT_CONSTANT);
		return isEncodeResponse;
	}
	
	/**
	 * @Description: 设置是否对response返回数据做加密处理
	 * @param codeType 加密类型
	 * @param key 密钥
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:09:46
	 */
	public static void setEncodeResponse(CodeType codeType, String key) {
		Object[] value = new Object[] { codeType, key };
		getProductContextWrapper().transitContainer.put(ENCODE_RETURN_RESULT_CONSTANT, value);
	}
	
	/**
	 * @Description: 设置是否对response返回数据做加密处理
	 * @param codeType 加密类型
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:10:07
	 */
	public static void setEncodeResponse(CodeType codeType) {
		WebProductContextHolder.setEncodeResponse(codeType, "");
	}
	
	/**
	 * @Description: 获取加密类型
	 * @return CodeType 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:10:23
	 */
	public static CodeType encodeResponse() {
		Object[] value = (Object[]) getProductContextWrapper().transitContainer.get(ENCODE_RETURN_RESULT_CONSTANT);
		CodeType codeType = null == value ? null : (CodeType) value[0];
		return codeType;
	}
	
	/**
	 * @Description: 获取密钥
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:10:52
	 */
	public static String encodeResponseKey() {
		Object[] value = (Object[]) getProductContextWrapper().transitContainer.get(ENCODE_RETURN_RESULT_CONSTANT);
		String key = null == value ? null : (String) value[1];
		return key;
	}
	
	/**
	 * @Description: 设置web环境的Session
	 * @param session
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:11:16
	 */
	public static void setHttpSession(HttpSession session) {
		getProductContextWrapper().transitContainer.put(HTTP_SESSION_CONSTANT, session);
	}
	
	/**
	 * @Description: 获取web环境的Session
	 * @return
	 * @return HttpSession 返回类型
	 * @author gaoxiang
	 * @date 2015年11月23日 下午11:11:31
	 */
	public static HttpSession getHttpSession() {
		return (HttpSession) getProductContextWrapper().transitContainer.get(HTTP_SESSION_CONSTANT);
	}
	
	static class ProductContextWrapper {
		
		private Map<String, Object> transitContainer;
		
		public ProductContextWrapper() {
			transitContainer = new HashMap<String, Object>();
		}
		
		public ProductContext getProductContext() {
			return ProductContextHolder.getProductContext();
		}
		
		public void setProductContext(ProductContext productContext) {
			ProductContextHolder.setProductContext(productContext);
		}
		
		public Map<String, Object> getTransitContainer() {
			return transitContainer;
		}
		
		public void clean() {
			ProductContextHolder.clean();
			this.transitContainer.clear();
		}
	}
}
