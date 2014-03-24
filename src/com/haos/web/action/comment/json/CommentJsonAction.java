package com.haos.web.action.comment.json;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.comment.Comment;
import com.haos.service.comment.CommentService;
import com.opensymphony.xwork2.ActionContext;


/**
 * Comment Information JsonAction
 * @author WangYue
 *
 */
public class CommentJsonAction extends BaseAction {
   //private final static Log logger = LogFactory.getLog(CommentJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * comment information service interface
     */
    private CommentService commentService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     * comment value information
     */
    private Comment comment;
    
    /**
     * ids array
     */
    private Long[]ids;


    /**
     * add comment method
     *
     * @return
     */
    public String addComment() {
    	Map<String,Object> map=ActionContext.getContext().getSession(); //get session
    	String userCode=(String)map.get("userCode");
    	if(StringUtils.isNotBlank(userCode)){
    		if (null != comment) {
    			comment.setUserCode(userCode);  //set user code
    			ResultCollection serviceResult = commentService.addComment(comment);
    			
    			if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
    				result = "true";
    			} else {
    				result = "false*" + (String) serviceResult.get("resultMsg");
    			}
    		} else {
    			result = "false";
    		}
    		
    	}else{
    		result="false*login";
    	}
        return "out";
    }

    /**
     * update comment
     *
     * @return
     */
    public String updateComment() {
        if (null != comment) {

            ResultCollection serviceResult = commentService.updateComment(comment);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * delete comment
     *
     * @return
     */
    public String deleteComment() {
        if (null != comment.getId() && comment.getId().intValue() > 0) {
            ResultCollection serviceResult = commentService.deleteCommentById(comment.getId());
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        } else {
            result = "false";
        }
        return "out";
    }

    
    
    
    /**
     * delete comments method
     *
     * @return
     */
    public String deleteComments() {
        if(ids!=null&&ids.length>1){
            ResultCollection serviceResult = commentService.deleteCommentByIds(ids);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false";
            }
        }else {
            result = "false";
        }
        return "out";
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public CommentService getCommentService() {
		return commentService;
	}
	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

     
  
}
