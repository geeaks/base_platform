package com.gts.base.platform.dao.plugin;

/**
 * @Description: 分页实体类
 * @ClassName: Page
 * @author gaoxiang
 * @date 2015年11月29日 下午11:13:58
 */
public class Page {
	
	/**
	 * @Fields showPageCount : 分页标签显示(默认5个页码)
	 */
	private int showPageCount = 5;
	
	/**
	 * @Fields showCount : 每页显示记录数(默认10条)
	 */
	private int showCount = 10;
	
	/**
	 * @Fields totalPage : 总页数
	 */
	protected int totalPage;
	
	/**
	 * @Fields totalResult : 总记录数
	 */
	private int totalResult;
	
	/**
	 * @Fields currentPage : 当前页
	 */
	private int currentPage;
	
	/**
	 * @Fields currentResult : 当前记录起始索引
	 */
	private int beginIndex;
	
	private int endIndex;
	
	/**
	 * @Fields entityOrField : true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	 */
	private boolean entityOrField;
	
	/**
	 * @Description: 如果
	 * @return int 返回类型
	 * @author gaoxiang
	 * @date 2015年11月29日 下午11:35:19
	 */
	public int getShowPageCount() {
		return getTotalPage() < showPageCount ? getTotalPage() : showPageCount;
	}
	
	public void setShowPageCount(int showPageCount) {
		this.showPageCount = showPageCount;
	}
	
	public int getTotalPage() {
		return totalResult % showCount == 0 ? totalResult / showCount : totalResult / showCount + 1;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalResult() {
		return totalResult;
	}
	
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	
	public int getCurrentPage() {
		currentPage = currentPage <=0 ? 1 : currentPage > getTotalPage() ? getTotalPage() : currentPage;
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getShowCount() {
		return showCount;
	}
	
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	
	public void setCurrentResult(int currentResult) {
		this.beginIndex = currentResult;
	}
	
	public boolean isEntityOrField() {
		return entityOrField;
	}
	
	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}
	
	public int getBeginIndex() {
		beginIndex = (getCurrentPage() - 1) * getShowCount()+1;
		return beginIndex < 0 ? 0 : beginIndex;
	}
	
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	
	public int getEndIndex() {
		endIndex = getCurrentPage() * getShowCount();
		return endIndex;
	}
	
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
}
