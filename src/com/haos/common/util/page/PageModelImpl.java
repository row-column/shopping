package com.haos.common.util.page;

import java.util.ArrayList;

/**
 * Page model implementation
 * @author WangYue
 *
 * @param <T>
 */
public class PageModelImpl<T> extends ArrayList<T> implements PageModel<T> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     *  Default page size
     */
    public static final int PAGESIZE_DEFAULT = 20;
    /**
     * page size
     */
    private int pageSize;
    /**
     * Page index
     */
    private int index;

    /**
     * Total item
     */
    private int totalItem;
    /**
     * Total page
     */
    private int totalPage;

    
    /**
     * Start row
     */
    private int startRow;
    /**
     * End row
     */
    private int endRow;

    /**
     * Construct
     */
    public PageModelImpl() {
          init();
    }

    /**
     * 
     * @param index
     * @param pageSize
     */
    public PageModelImpl(int index, int pageSize) {
        this.index = index;
        this.pageSize = pageSize;
        init();
    }

   /**
    * 
    */
      public boolean isFirstPage(){
          return index <= 1;
      }


    public boolean isMiddlePage() {
         return !(isFirstPage() || isLastPage());
    }


    public boolean isLastPage() {
        return index >= totalPage;
    }


    public boolean isNextPageAvailable() {
        return !isLastPage();
    }

    public boolean isPreviousPageAvailable() {
          return !isFirstPage();
    }
    public int getNextPage() {
        if(isLastPage()) {
            return totalItem;
        } else {
            return index+1;
        }
    }

    public int getPreviousPage() {
        if(isFirstPage()) {
            return 1;
        } else {
            return index - 1;
        }
    }
  

    public int getPageSize() {
        return pageSize;
    }

 

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        init();
    }

 

    public int getIndex() {
        return index;
    }


    public void setIndex(int index) {
        this.index = index;
        init();
    }



    public int getTotalItem() {
        return totalItem;
    }

    
    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
        init();
    }

    

    public int getTotalPage() {
        return totalPage;
    }

    

    public int getStartRow() {
        return startRow;
    }

  
    public int getEndRow() {
        return endRow;
    }

   
    private void init() {
        if (pageSize < 1) { //
            pageSize = PAGESIZE_DEFAULT;
        }
        if (index < 1) {
            index = 1;//
        }
        if (totalItem > 0) {
            totalPage = totalItem / pageSize + (totalItem % pageSize > 0 ? 1 : 0);
            if(index > totalPage) {
                index = totalPage; //
            }
            endRow = index * pageSize;
            startRow = endRow - pageSize;
            if(endRow>totalItem) {
                endRow = totalItem;
            }
        }
    }


}

