package plug;

public class RequestPage {
	private int totalPage; // 总页数
	private int totalResult; // 总记录数
	private int currentResult; // 当前记录起始索引
	private boolean entityOrField; // true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	private int showTag = 5; // 分页标签显示数量

	private int pageNum;// dwz 当前页
	private int numPerPage;// dwz<!--前台动态设置每页显示多少条-->
	
	private boolean isPaging = Boolean.TRUE;
	
	public boolean isPaging() {
		return isPaging;
	}

	public void setPaging(boolean isPaging) {
		this.isPaging = isPaging;
	}

	public int getNumPerPage() {
		if (numPerPage == 0) {
			numPerPage = 20;
		}
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPageNum() {
		if (pageNum <= 0)
			pageNum = 1;
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getShowTag() {
		if (showTag == 0) {
			showTag = 5;
		}
		return showTag;
	}

	public void setShowTag(int showTag) {
		this.showTag = showTag;
	}

	public int getTotalPage() {

		if (totalResult % getNumPerPage() == 0)
			totalPage = totalResult / getNumPerPage();
		else
			totalPage = totalResult / getNumPerPage() + 1;
		return totalPage;
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

	public int getCurrentResult() {
		currentResult = (getPageNum() - 1) * getNumPerPage();
		if (currentResult < 0)
			currentResult = 0;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public boolean isEntityOrField() {
		return entityOrField;
	}

	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}


}
