package com.shopping.manager.comment.impl;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.shopping.common.util.manager.BaseManager;
import com.shopping.common.util.page.PageModel;
import com.shopping.common.util.page.PageModelImpl;
import com.shopping.dao.comment.CommentDao;
import com.shopping.domain.comment.Comment;
import com.shopping.domain.comment.query.CommentQuery;
import com.shopping.manager.comment.CommentManager;

public class CommentManagerImpl extends BaseManager implements CommentManager {

	/**
	 * 日志
	 */
	private static final Logger log = LogManager
			.getLogger(CommentManagerImpl.class);

	/**
	 * comment information dao interface
	 */
	private CommentDao commentDao;
	
	@Override
	public boolean addComment(final Comment comment) {
		// 操作结果
		boolean resultFlag = true;
		try {
			// 事务 多个数据处理时，放入事务处理中 （此处作为实例，没有多个数据处理时，无需进行事务处理）
			TransactionTemplate template = this
					.getDataSourceTransactionManager();
			template.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(
						TransactionStatus transactionStatus) {
					try {
						boolean insertFlag = false;
						if (comment != null) {
						
							insertFlag = commentDao.addComment(comment); //call add comment method

							// 新增失败
							if (!insertFlag) {
								// 添加失败，抛出异常
								throw new RuntimeException(
										"CommentManagerImpl.addComment.error.");
							} else {
								// 事务中的其他数据处理
								// 调用内部方法
							}

						} else {
							// 对象为null，抛出异常
							log.debug("CommentManagerImpl.addComment.parameter.empty.");
							throw new RuntimeException(
									"CommentManagerImpl.addComment.parameter.empty.");
						}
					} catch (Exception e) {
						// 日志记录
						log.error(e);
						// 回滚
						transactionStatus.setRollbackOnly();
						throw new RuntimeException(
								"CommentManagerImpl.addComment.exception:", e);
					}
				}

				// 添加 事务中的其他数据处理的内部方法

			});

		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
		}
		return resultFlag;
	}

	@Override
	public boolean updateComment(Comment comment) {
		// 操作结果
		boolean resultFlag = true;
		try {
			if (null != comment) {
				
				boolean updateRouteFlag = commentDao.updateComment(comment); // call update comment method
 
				if (!updateRouteFlag) {

					// 更新失败，抛出异常
					throw new RuntimeException(
							"CommentManagerImpl.updateComment.fail.");
				}
			} else {
				// 功能对象为null，抛出异常
				log.debug("CommentManagerImpl.updateComment.parameter.empty.");
				throw new RuntimeException(
						"CommentManagerImpl.updateComment.parameter.empty.");
			}
		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
			// System.out.println(e);
		}
		return resultFlag;
	}

	@Override
	public Comment getCommentById(Long id) {
		return commentDao.getCommentById(id);
	}

	@Override
	public Comment getCommentByCommodityIdAndUserCode(CommentQuery commentQuery) {
		return commentDao.getCommentByCommodityIdAndUserCode(commentQuery);
	}

	@Override
	public List<Comment> queryCommentListByQueryBean(CommentQuery commentQuery) {
		return commentDao.queryCommentListByQueryBean(commentQuery);
	}

	@Override
	public PageModel<Comment> queryCommentListPageByQueryBean(
			CommentQuery commentQuery, int pageIndex, int pageSize) {

		// 必须有这行代码
		if (null == commentQuery) {
			commentQuery = new CommentQuery();
		}
		// 查询总数
		int totalItem = commentDao.queryCommentCountByQueryBean(commentQuery);

		// 创建翻页集合,根据第几页和每页大小
		PageModel<Comment> comments = new PageModelImpl<Comment>(
				pageIndex, pageSize);

		// 设置总数,同时将会计算出开始行和结束行
		comments.setTotalItem(totalItem);

		// 设置开始行
		commentQuery.setStartRow(comments.getStartRow());

		// 设置最后行
		commentQuery.setEndRow(comments.getEndRow());

		// 调用Dao翻页方法
		List<Comment> commentList = commentDao
				.queryCommentListPageByQueryBean(commentQuery);

		// 添加到翻页集合中
		comments.addAll(commentList);

		return comments;
	}

	@Override
	public boolean deleteCommentById(Long id) {

		// 操作结果
		boolean resultFlag = true;
		try {
			if (null != id && !("").equals(id)) {
				// 删除
				boolean deleteFlag = commentDao.deleteCommentById(id);
				if (!deleteFlag) {
					// 删除失败，抛出异常
					throw new RuntimeException(
							"CommentManagerImpl.deleteComment.fail.");
				}
			} else {
				// 记录id 为null，抛出异常
				log.debug("CommentManagerImpl.deleteComment.empty.");
				throw new RuntimeException("");
			}
		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
		}
		return resultFlag;
	}

	@Override
	public boolean deleteCommentByIds(final Long[] ids) {

		// result flag
		boolean resultFlag = true;
		try {
			// deal with many data of transaction, you should execute this
			// transaction.
			TransactionTemplate template = this
					.getDataSourceTransactionManager();
			template.execute(new TransactionCallbackWithoutResult() {

				@Override
				protected void doInTransactionWithoutResult(
						TransactionStatus transactionStatus) {
					try {
						boolean deleteFlag = false; // delete result flag
						// judge on ids whether null or not
						if (ids != null && ids.length > 0) {
							// Traverse array ids
							for (Long id : ids) {
								deleteFlag = commentDao.deleteCommentById(id);
							}
							if (!deleteFlag) {
								throw new RuntimeException(
										"CommentManagerImpl.deleteCommentByIds(),Fail.");
							}
						} else {
							throw new RuntimeException(
									"CommentManagerImpl.deleteCommentByIds(), ids param null.");
						}

					} catch (Exception e) {
						// record log
						log.error(e);
						// roll back
						transactionStatus.setRollbackOnly();
						throw new RuntimeException(
								"CommentManagerImpl.deleteCommentByIds.exception:",
								e);
					}
				}
			});
		} catch (Exception e) {
			resultFlag = false;
			log.error(e);
		}
		return resultFlag;
	}

	@Override
	public int queryCommentCountByQueryBean(CommentQuery commentQuery) {
		return commentDao.queryCommentCountByQueryBean(commentQuery);
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}


}
