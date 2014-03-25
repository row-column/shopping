package com.shopping.web.action.level.json;

import com.shopping.common.util.action.BaseAction;
import com.shopping.common.util.page.ResultCollection;
import com.shopping.domain.level.Level;
import com.shopping.service.level.LevelService;


/**
 * Level information JsonAction
 * @author WangYue
 *
 */
public class LevelJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(LevelJsonAction.class);
    
	private static final long serialVersionUID = 1L;

	/**
     * Level information service interface
     */
    private LevelService levelService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     * Level information value class
     */
    private Level level;

    /**
     * ids array
     */
    private Long[]ids;


    /**
     * Add level method
     *
     * @return
     */
    public String addLevel() {
        if (null != level) {

            ResultCollection serviceResult = levelService.addLevel(level);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * Update level method
     *
     * @return
     */
    public String updateLevel() {
        if (null != level) {

            ResultCollection serviceResult = levelService.updateLevel(level);
            
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
     * Delete Level method
     *
     * @return
     */
    public String deleteLevel() {
        if (null != level.getId() && level.getId().intValue() > 0) {
            ResultCollection serviceResult = levelService.deleteLevelById(level.getId());
            
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
     * Delete levels method
     *
     * @return
     */
    public String deleteLevels() {
        if (null != ids && ids.length > 0) {
            ResultCollection serviceResult = levelService.deleteLevelByIds(ids);
            
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
     * Check level code method
     *
     * @return
     */
	public String checkLevelCode() {
		if (null != level) {

			ResultCollection serviceResult = levelService.getLevelByLevelCode(level
					.getLevelCode());
			if (null != serviceResult) {
				if (serviceResult.getSuccess()) {
					Level level = (Level) serviceResult.get("level");
					if (null != level) {
						if (level.getLevelCode() != null) {
							result = "exist";
						} else {
							result = "ok";
						}
					} else {
						result = "level id 不正确";
					}

				} else {
					result = "level id 不正确";
				}
			} else {
				result = "level id 不正确";
			}

		} else {
			result = "level empty";
		}
		return "out";
	}


    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public LevelService getLevelService() {
		return levelService;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
    
  
}
