package com.haos.domain.fun.query;

import com.haos.common.util.page.BaseQuery;
/**
 * User function query value class
 * @author WangYue
 *
 */

public class UserFunQuery extends BaseQuery  {
	private static final long serialVersionUID = 1L;

    
    /**
     *  user code
     */
    private String userCode;
    
    /**
     * function code
     */
    private String funCode;
    
    /**
     * yes or not  delete
     */
    private int yn;
    
    /**
     * yes or not  read
     */
    private int isRead;

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }


    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getRead() {
        return isRead;
    }

    public void setRead(int read) {
        isRead = read;
    }
}