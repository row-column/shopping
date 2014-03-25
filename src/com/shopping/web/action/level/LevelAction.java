package com.shopping.web.action.level;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopping.common.util.CommonConstant;
import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.level.Level;
import com.shopping.domain.level.query.LevelQuery;
import com.shopping.service.level.LevelService;


/**
 * Level information  action
 * @author WangYue
 *
 */
public class LevelAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Log log = LogFactory.getLog(LevelAction.class);
    
    /**
     * Level information Service
     */
    private LevelService levelService;
    /**
     * Level information query value class
     */
    private LevelQuery levelQuery;
    
    /**
     * Level information
     */
    private Level level;
    
    /**
     *  Page size 
     */
    private int pageSize = CommonConstant.PAGESIZE;

    /**
     * To level information list page
     *
     * @return
     */
    public String levelMain() {
        if (null == levelQuery) {
            levelQuery = new LevelQuery();
        }
        levelQuery.setYn(CommonConstant.YN_NO_DELETE);     // not delete
        ResultCollection result = levelService.queryLevelListPageByQueryBean(levelQuery, page, pageSize);
        setValueStack(result);
        return "levelMain";
    }

    /**
     * 
     * To add level information page
     * @return
     */
    public String toAddLevel() {
        this.setValueStack(null);
        return "toAddLevel";
    }

    /**
     * 
     * To update level information page
     * @return
     */
    public String toUpdateLevel() {
    	
        if (null != level) {
            // get level information by id
            ResultCollection result = levelService.getLevelById(level.getId());
            setValueStack(result);
        } else {
            log.error("LevelAction!toUpdateLevel() error!");
        }
        return "toUpdateLevel";
    }
    
    /**
     * 
     * To delete level information page
     * @return
     */
    public String toDeleteLevel() {
    	
        if (null != level) {
            // get level information by id
            ResultCollection result = levelService.getLevelById(level.getId());
            setValueStack(result);
        } else {
            log.error("LevelAction!toDeleteLevel() error!");
        }
        return "toDeleteLevel";
    }

	public LevelService getLevelService() {
		return levelService;
	}

	public void setLevelService(LevelService levelService) {
		this.levelService = levelService;
	}

	public LevelQuery getLevelQuery() {
		return levelQuery;
	}

	public void setLevelQuery(LevelQuery levelQuery) {
		this.levelQuery = levelQuery;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

    
  
}
