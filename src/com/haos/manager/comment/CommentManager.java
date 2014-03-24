package com.haos.manager.comment;

import java.util.List;

import com.haos.common.util.page.PageModel;
import com.haos.domain.comment.Comment;
import com.haos.domain.comment.query.CommentQuery;


/**
 * Comment information manager interface
 * @author WangYue
 *
 */
public interface CommentManager {

	/**
	 * add comment information
	 * @param comment   comment value class
	 * @return true:success;false:fail
	 */
	public boolean addComment(Comment comment);
	
	/**
	 * update comment information
	 * @param comment  comment value class
	 * @return true:success;false:fail
	 */
	public boolean updateComment(Comment comment);
	
	/**
	 * according to comment id ,query comment information.
	 * @param id  comment id
	 * @return  Comment  comment value class
	 */
	public Comment getCommentById(Long id);
	
	/**
	 * according to comment query ,query comment information.
	 * @param commentCode  comment code
	 * @return Comment  comment value class
	 */
	public Comment getCommentByCommodityIdAndUserCode(CommentQuery commentQuery);
	
	/**
	 * query comment information with page
	 * @param query Query comment value class
	 * @return Comment comment value class
	 */
	public List<Comment> queryCommentListByQueryBean(CommentQuery commentQuery);
	
	/**
	 * query comment information with page
	 * @param query Query comment value class
	 * @return Comment comment value class
	 */
	public PageModel<Comment> queryCommentListPageByQueryBean(CommentQuery commentQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to comment id,delete comment information.
	 * @param id  comment id
	 * @return true:success;false:fail.
	 */
	public boolean deleteCommentById(Long id);
	
	/**
	 * according to comment ids,delete comments information
	 * @param ids comment ids 
	 * @return true:success;false:fail.
	 */
	boolean deleteCommentByIds(Long[] ids);
	/**
	 * get comment records 
	 * @param commentQuery  Query comment value class 
	 * @return comment count 
	 */
	public int queryCommentCountByQueryBean(CommentQuery commentQuery);

	
	
}
