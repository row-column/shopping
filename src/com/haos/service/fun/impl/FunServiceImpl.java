package com.haos.service.fun.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.haos.common.util.CommonConstant;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.fun.Fun;
import com.haos.domain.fun.query.FunQuery;
import com.haos.manager.fun.FunManager;
import com.haos.service.fun.FunService;

/**
 * Fun information service interface
 * @author WangYue
 *
 */
public class FunServiceImpl implements FunService {
    private static final Logger log = LogManager.getLogger(FunServiceImpl.class);
    /**
     *  Fun information manager interface
     */
	private FunManager funManager;
	
	@Override
	public ResultCollection addFun(Fun fun) {
		if(null!=fun){
			ResultCollection result = new ResultCollection();
			fun.setCreateTime(new Date());
			fun.setUpdateTime(new Date());
			//判断父节点是否为空
			if(StringUtils.isBlank(fun.getParentCode())){
			    //设置父节点默认值
				fun.setParentCode(CommonConstant.DEFAULT_PARENT_CODE);
			}
			
			fun.setYn(CommonConstant.YN_NO_DELETE);
			try {
				boolean resultFlag = funManager.addFun(fun); //call addFun() method
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(resultFlag);
			} catch (Exception e) {
				log.error("FunServiceImpl -> addFun() error!!", e);
			}
			return result;
			
		}else{
			log.error("FunServiceImpl -> addFun() fun empty!!");
			throw new RuntimeException("FunServiceImpl -> addFun() fun empty !!");
		}
	}

	@Override
	public ResultCollection updateFun(Fun fun) {
		if(null!=fun){
			ResultCollection result = new ResultCollection();
			fun.setUpdateTime(new Date());
			//判断父节点是否为空
			if(StringUtils.isBlank(fun.getParentCode())){
			    //设置父节点默认值
				fun.setParentCode(CommonConstant.DEFAULT_PARENT_CODE);
			}
			try {
				boolean resultFlag = funManager.updateFun(fun); //call updateFun() method
				result.addDefaultModel("resultFlag", resultFlag); 
				result.setSuccess(resultFlag);
			} catch (Exception e) {
				log.error("FunServiceImpl -> updateFun() error!!", e);
			}
			return result;
			
		}else{
			log.error("FunServiceImpl -> updateFun() fun empty!!");
			throw new RuntimeException("FunServiceImpl -> updateFun() fun empty !!");
		}
	}

	@Override
	public ResultCollection getFunById(Long id) {
		if(null!=id){
			ResultCollection result = new ResultCollection();
			try {
				Fun fun = funManager.getFunById(id);
				result.addDefaultModel("fun", fun);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("FunServiceImpl -> getFunById() error!!", e);
			}
			return result;
		}else{
			log.error("FunServiceImpl -> addFun() id empty!!");
			throw new RuntimeException("FunServiceImpl -> addFun() id empty !!");
		}
	}

	@Override
	public ResultCollection getFunByFunCode(String funCode) {
		if(!StringUtils.isBlank(funCode)){
			ResultCollection result = new ResultCollection();
			try {
				Fun fun = funManager.getFunByFunCode(funCode);
				result.addDefaultModel("fun", fun);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("FunServiceImpl -> getFunByFunCode() error!!", e);
			}
			return result;
			
		}else{
			log.error("FunServiceImpl -> getFunByFunCode() funCode empty!!");
			throw new RuntimeException("FunServiceImpl -> getFunByFunCode() funCode empty !!");
		}
	}

	@Override
	public ResultCollection queryFunListByQueryBean(FunQuery funQuery) {
		if(null!=funQuery){
			ResultCollection result = new ResultCollection();
			try {
				List<Fun> funList = funManager.queryFunListByQueryBean(funQuery);
				result.addDefaultModel("funList", funList);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("FunServiceImpl -> queryFunListByQueryBean() error!!", e);
			}
			return result;
			
		}else{
			log.error("FunServiceImpl -> queryFunListByQueryBean() funQuery empty!!");
			throw new RuntimeException("FunServiceImpl -> queryFunListByQueryBean() funQuery empty !!");
		}
	}

	@Override
	public ResultCollection queryFunListPageByQueryBean(FunQuery funQuery,
			int pageIndex, int pageSize) {
		if(null!=funQuery){
			ResultCollection result = new ResultCollection();
			funQuery.setYn(CommonConstant.YN_NO_DELETE);     //set  not delete
			try {
				List<Fun> funList = funManager.queryFunListPageByQueryBean(funQuery,pageIndex,pageSize);  // call queryFunListPageByQueryBean() method
				result.addDefaultModel("funList", funList);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("FunServiceImpl -> queryFunListPageByQueryBean() error!!", e);
			}
			return result;
			
		}else{
			log.error("FunServiceImpl -> addFun() funQuery empty!!");
			throw new RuntimeException("FunServiceImpl -> addFun() funQuery empty !!");
		}
	}

	@Override
	public ResultCollection deleteFunById(Long id) {
		if(null!=id){
			ResultCollection result = new ResultCollection();
			try {
				boolean resultFlag = funManager.deleteFunById(id);
				result.addDefaultModel("resultFlag", resultFlag);
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("FunServiceImpl -> deleteFunById() error!!", e);
			}
			return result;
			
		}else{
			log.error("FunServiceImpl -> deleteFunById() id empty!!");
			throw new RuntimeException("FunServiceImpl -> deleteFunById() id empty !!");
		}
	}
	
	
	@Override
	public ResultCollection deleteFunByIds(Long ids[]){
		if(null!=ids){
			ResultCollection result = new ResultCollection();
			try {
				if(null!=ids&&ids.length>0){
					boolean resultFlag = funManager.deleteFunByIds(ids);
					result.addDefaultModel("resultFlag", resultFlag);
					result.setSuccess(true);
					
				}else{
					log.error("FunServiceImpl -> deleteFunById() ids param null!!");
				}
			} catch (Exception e) {
				log.error("FunServiceImpl -> deleteFunById() error!!", e);
			}
			return result;
			
		}else{
			log.error("FunServiceImpl -> deleteFunByIds() ids empty!!");
			throw new RuntimeException("FunServiceImpl -> deleteFunByIds() ids empty !!");
		}
	}


	public void setFunManager(FunManager funManager) {
		this.funManager = funManager;
	}


}
