package com.haos.common.util.page;

/**
 * Base query interface
 * @author WangYue
 *
 */
public interface Query {

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
}
