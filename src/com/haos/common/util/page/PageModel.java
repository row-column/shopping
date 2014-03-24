package com.haos.common.util.page;

import java.util.List;

/**
 * Page model interface
 * @author WangYue
 *
 * @param <T>
 */
public interface PageModel<T> extends List<T> {

    /**
     * Is have middle page
     * @return
     */
    boolean isMiddlePage();


    
    /**
     * Is have last page
     * @return
     */
    boolean isLastPage();

    /**
     * Is  next Page available
     * @return
     */
    boolean isNextPageAvailable();

   /**
    * is previous page available
    * @return
    */
    boolean isPreviousPageAvailable();

   /**
    * Get page size
    * @return
    */
    int getPageSize();

    /**
     * Set page size
     * @param pageSize
     */
    void setPageSize(int pageSize);

   
    /**
     * Get index
     * @return
     */
    int getIndex();

    /**
     * Set index
     * @param index
     */
    void setIndex(int index);

    /**
     * Get total item
     * @return
     */
    int getTotalItem();

    /**
     * Set total item
     * @param totalItem
     */
    void setTotalItem(int totalItem);

    /**
     * Get total page
     * @return
     */
    int getTotalPage();

    /**
     * Get start row
     * @return
     */
    int getStartRow();

   /**
    * Get end row
    * @return
    */
    int getEndRow();

   /**
    * Get next page
    * @return
    */
    int getNextPage();

    /**
     * Get previous page
     * @return
     */
    int getPreviousPage();
    
    /**
     * Is first page
     * @return
     */
    boolean isFirstPage();
}

