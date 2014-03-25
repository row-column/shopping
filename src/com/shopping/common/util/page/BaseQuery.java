package com.shopping.common.util.page;

public class BaseQuery implements Query{
	
	/**
	 * Start row
	 */
	private int startRow;
	
	/**
	 * End row
	 */
	private int endRow;
	
	/**
	 * Page size
	 */
	private int pageSize;
	
	public BaseQuery(){
		
	}
	
	public BaseQuery(PageModel pageModel){
		this.startRow=pageModel.getStartRow();
		this.endRow=pageModel.getEndRow();
		this.pageSize=pageModel.getPageSize();
	}


	@Override
	public int getStartRow() {
		return startRow;
	}
	
	public void setStartRow(int startRow){
		this.startRow=startRow;
	}

	@Override
	public int getEndRow() {
		return endRow;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public void setPageSize(int pageSize){
		this.pageSize=pageSize;
	}

}
