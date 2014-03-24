package com.haos.web.action.comment;

import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.haos.common.util.CommonConstant;
import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.comment.Comment;
import com.haos.domain.comment.query.CommentQuery;
import com.haos.service.comment.CommentService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Comment information  action
 * @author WangYue
 *
 */
public class CommentAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(CommentAction.class);
	
	/**
     * json result
     */
    private String result;
    
    /**
     * Comment information Service
     */
    private CommentService commentService;
    /**
     * Comment information query value class
     */
    private CommentQuery commentQuery;
    
    /**
     * Comment information
     */
    private Comment comment;
    
    /**
     * commodity id
     */
    private Long commodityId;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;
    


    /**
     * To comment information list page
     *
     * @return
     */
    public String commentMain() {
        if (null == commentQuery) {
            commentQuery = new CommentQuery();
        }
        commentQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        ResultCollection result = commentService.queryCommentListPageByQueryBean(commentQuery, page, pageSize);
        setValueStack(result);
        return "commentMain";
    }

    /**
     * 
     * To add comment information page
     * @return
     */
    public String toAddComment() {
        this.setValueStack(null);
        return "toAddComment";
    }

    /**
     * 
     * To update comment information page
     * @return
     */
    public String toUpdateComment() {
    	
        if (null != comment) {
            // get comment information by id
            ResultCollection result = commentService.getCommentById(comment.getId());
            setValueStack(result);
        } else {
            log.error("CommentAction!toUpdateComment() error!");
        }
        return "toUpdateComment";
    }
    
    /**
     * 
     * To delete comment information page
     * @return
     */
    public String toDeleteComment() {
    	
        if (null != comment) {
            // get comment information by id
            ResultCollection result = commentService.getCommentById(comment.getId());
            setValueStack(result);
        } else {
            log.error("CommentAction!toDeleteComment() error!");
        }
        return "toDeleteComment";
    }
  
    /**
     * to  comment commodity page
     * @return
     */
    public String commentCommodity() {
    	Map<String,Object> map=ActionContext.getContext().getSession(); //get session
    	String userCode=(String)map.get("userCode");
    	if(!StringUtils.isBlank(userCode)){
    		if (null != commodityId && commodityId>0) {
    			
    			if(null==commentQuery){
    				commentQuery = new  CommentQuery();
    			}
    			commentQuery.setCommodityId(commodityId);  //set commodity id
    			commentQuery.setUserCode(userCode); //set user code
    			commentQuery.setYn(CommonConstant.YN_NO_DELETE); //set yn=0
    			setValueStack(commentService.getCommentByCommodityIdAndUserCode(commentQuery)); //call getCommentByCommodityIdAndUserCode()method
    		} else {
    			return ERROR;
    		}
    		
    	}else{
    		return ERROR;
    	}
        return SUCCESS;
        
    }
    
   
	public Long getCommodityId() {
		return commodityId;
	}

	/**
     * 
     * To my comment information page
     * @return
     */
    public String myComment() {
    	Map<String,Object> map=ActionContext.getContext().getSession(); //get session
    	String userCode=(String)map.get("userCode");
    	if(!StringUtils.isBlank(userCode)){
    		
    		if(null!=commodityId&&commodityId>0){
    			if(null==commentQuery){
    				commentQuery= new CommentQuery();
    			}
    			commentQuery.setCommodityId(commodityId); //set  commodity id
    			commentQuery.setUserCode(userCode); //set user code
    			setValueStack(commentService.queryCommentListByQueryBean(commentQuery)); //call queryCommentListByQueryBean()method
    		}else{
    			return ERROR;
    		}
    		
    	}else{
    		return ERROR;
    	}
        return SUCCESS;
    }
    
    public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}
	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public CommentQuery getCommentQuery() {
		return commentQuery;
	}

	public void setCommentQuery(CommentQuery commentQuery) {
		this.commentQuery = commentQuery;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
  
}
