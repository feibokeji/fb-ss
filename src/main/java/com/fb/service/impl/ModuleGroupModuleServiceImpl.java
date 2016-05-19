package com.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.dao.TModuleGroupModuleDao;
import com.fb.domain.po.TModuleGroupModule;
import com.fb.service.ModuleGroupModuleService;
import com.fb.service.SimpServiceAbstract;

@Service
public class ModuleGroupModuleServiceImpl extends SimpServiceAbstract implements ModuleGroupModuleService {
    
    @Autowired
    private TModuleGroupModuleDao moduleGroupModuleDao;
    
    public int getModuleGroupModuleCountByUModuleId(String umoduleid) {
        return moduleGroupModuleDao.getModuleGroupModuleCountByUModuleId(umoduleid);
    }
    
    public int getModuleGroupModuleCountByUModuleGroupId(String umodulegroupid) {
        return moduleGroupModuleDao.getModuleGroupModuleCountByUModuleGroupId(umodulegroupid);
    }
    
    public boolean saveModuleGroupModule(String umodulegroupid, String umoduleids) {
        if (DataUtils.isUid(umodulegroupid) && !DataUtils.isNullOrEmpty(umoduleids)) {
            if (umoduleids.contains(",")) {
                String[] ids = umoduleids.split(",");
                for (String id : ids) {
                    if (!DataUtils.isUid(id)) {
                        return false;
                    }
                }
                moduleGroupModuleDao.deleteModuleGroupModuleByUModuleGroupId(umodulegroupid);
                for (String id : ids) {
                    TModuleGroupModule item = new TModuleGroupModule();
                    item.setUid(DataUtils.newUUID());
                    item.setUmodulegroupid(umodulegroupid);
                    item.setUmoduleid(id);
                    moduleGroupModuleDao.addModuleGroupModule(item);
                }
                return true;
            } else {
                if (DataUtils.isUid(umoduleids)) {
                    moduleGroupModuleDao.deleteModuleGroupModuleByUModuleGroupId(umodulegroupid);
                    TModuleGroupModule item = new TModuleGroupModule();
                    item.setUid(DataUtils.newUUID());
                    item.setUmodulegroupid(umodulegroupid);
                    item.setUmoduleid(umoduleids);
                    moduleGroupModuleDao.addModuleGroupModule(item);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
}
