package com.haos.dao.comment.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.comment.CommentDao;
import com.haos.domain.comment.Comment;
import com.haos.domain.comment.query.CommentQuery;

/**
 * Comment information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class CommentDaoImpl extends BaseDao implements CommentDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addComment(Comment comment) {
		return this.insert("Comment.insert", comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateComment(Comment comment) {
		return this.update("Comment.update", comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comment getCommentById(Long id) {
		return (Comment)this.queryForObject("Comment.getCommentById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comment getCommentByCommodityIdAndUserCode(CommentQuery commentQuery) {
		return (Comment)this.queryForObject("Comment.getCommentByCommodityIdAndUserCode", commentQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> queryCommentListByQueryBean(CommentQuery commentQuery) {
		return this.queryForList("Comment.queryCommentListByQueryBean",commentQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> queryCommentListPageByQueryBean(CommentQuery commentQuery) {
		return this.queryForList("Comment.queryCommentListPageByQueryBean", commentQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteCommentById(Long id) {
		return this.delete("Comment.deleteCommentById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryCommentCountByQueryBean(CommentQuery commentQuery) {
		return (Integer)this.queryForObject("Comment.queryCommentCountByQueryBean", commentQuery);
	}

}
