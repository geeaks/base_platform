package com.gts.framework.core.context;

/**
 * @Description: 需要关注ProductContext远程传输时，潜在发生泄漏的可能性？
 * @ClassName: ProductContextHolder
 * @author gaoxiang
 * @date 2015年11月18日 下午9:48:29
 */ 
public final class ProductContextHolder {
	
	private static ThreadLocal<ProductContext> context = new ThreadLocal<ProductContext>() {
		// 初始化值
		public ProductContext initialValue() {
			return new ProductContext();
		}
	};
	
	public static void clean() {
		if (null != context.get()) {
			context.get().clean();
			context.set(null);
		}
	}
	
	public static ProductContext getProductContext() {
		if (null == context.get()) {
			context.set(new ProductContext());
		}
		return context.get();
	}
	
	/**
	 * 强制覆盖现有的产品环境
	 * @param productContext
	 */
	public static void setProductContext(ProductContext productContext) {
		context.set(productContext);
	}
}
