package com.shopping.service.comment;

import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.comment.Comment;
import com.shopping.domain.comment.query.CommentQuery;

/**
 * Comment information service interface
 * @author WangYue
 *
 */
public interface CommentService {

	/**
	 * add comment information
	 * @param comment   comment value class
	 * @return Result 
	 */
	public ResultCollection addComment(Comment comment);
	
	/**
	 * update comment information
	 * @param comment  comment value class
	 * @return Result 
	 */
	public ResultCollection updateComment(Comment comment);
	
	/**
	 * according to comment id ,query comment information.
	 * @param id  comment id
	 * @return  Result
	 */
	public ResultCollection getCommentById(Long id);
	
	/**
	 * according to comment query ,query comment information.
	 * @param commentCode  comment code
	 * @return Result
	 */
	public ResultCollection getCommentByCommodityIdAndUserCode(CommentQuery commentQuery);
	
	/**
	 * query comment information with page
	 * @param query Query comment value class
	 * @return Result
	 */
	public ResultCollection queryCommentListByQueryBean(CommentQuery commentQuery);
	
	/**
	 * query comment information with page
	 * @param query Query comment value class
	 * @return Result
	 */
	public ResultCollection queryCommentListPageByQueryBean(CommentQuery commentQuery, int pageIndex, int pageSize);
	
	
	/**
	 * according to comment id,delete comment information.
	 * @param id  comment id
	 * @return Result .
	 */
	public ResultCollection deleteCommentById(Long id);

	/**
	 * according to comment ids,delete comments information
	 * @param ids comments ids
	 * @return Result Result class 
	 */
    public ResultCollection deleteCommentByIds(Long[] ids);
	
}
