package com.haos.web.action.integral.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.level.Level;
import com.haos.service.level.LevelService;


/**
 * �ȼ���Ϣ��صĲ��� JsonAction
 * @author WangYue
 *
 */
public class IntegralJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(LevelJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �ȼ���Ϣ Service �ӿ�
     */
    private LevelService levelService;
    
    /**
     * json���صĽ��
     */
    private String result;
    
    /**
     * ��ʾ��Ϣ
     */
    private String resultMsg;
    
    /**
     * �ȼ���Ϣ����
     */
    private Level level;

    /**
     * �ȼ���������
     */
    private Long[]ids;


    /**
     * ��ӵȼ���Ϣ
     *
     * @return
     */
    public String addLevel() {
        Map<String, String> map = new HashMap<String, String>();
        if (null != level) {

        	level.setCreateTime(new Date()); //���ô���ʱ��
        	level.setUpdateTime(new Date()); //���ø���ʱ��
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
     * �޸ĵȼ���Ϣ
     *
     * @return
     */
    public String updateLevel() {
        Map<String, String> map = new HashMap<String, String>();
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
     * ɾ��ȼ���Ϣ
     *
     * @return
     */
    public String deleteLevel() {
        Map<String, String> map = new HashMap<String, String>();
        if (null != level.getId() && level.getId().intValue() > 0) {
            //ɾ��ȼ���Ϣ
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
     * ɾ�����ȼ���Ϣ
     *
     * @return
     */
    public String deleteLevels() {
        Map<String, String> map = new HashMap<String, String>();
        if (null != level.getId() && level.getId().intValue() > 0) {
            //ɾ��ȼ���Ϣ
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
     * ��ѯ�ȼ�����
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
							result = "�ô����Ѿ����ڣ�����";
						} else {
							result = "��ϲ�㣬�ô�����ã�����";
						}
					} else {
						result = "��ϲ�㣬�ô�����ã�����";
					}

				} else {
					result = "��ϲ�㣬�ô�����ã�����";
				}
			} else {
				result = "ϵͳ���ִ�������ϵ����Ա������";
			}

		} else {
			result = "ϵͳ���ִ�������ϵ����Ա������";
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
