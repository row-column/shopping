package com.haos.domain.level.query;

import com.haos.common.util.page.BaseQuery;

/**
 * Level Query Class Value
 * @author WangYue
 *
 */
public class LevelQuery extends BaseQuery {
	/**
	 * Level Code
	 */
	private String levelCode;
	
	/**
	 * Level Name
	 */
	private String levelName;

	/**
	 * yes or no delete
	 */
	private int yn;

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}
	
	
}
