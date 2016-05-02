package com.fb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.EncryptionUtils;
import com.fb.dao.TLoginLogDao;
import com.fb.dao.TModuleDao;
import com.fb.dao.TModuleGroupModuleDao;
import com.fb.dao.TRoleDao;
import com.fb.dao.TRoleModuleGroupDao;
import com.fb.dao.TUserDao;
import com.fb.domain.po.TLoginLog;
import com.fb.domain.po.TModule;
import com.fb.domain.po.TModuleGroupModule;
import com.fb.domain.po.TRole;
import com.fb.domain.po.TRoleModuleGroup;
import com.fb.domain.po.TUser;
import com.fb.domain.vo.RoleContainer;
import com.fb.service.LoginService;
import com.fb.service.SimpServiceAbstract;

@Service
public class LoginServiceImpl extends SimpServiceAbstract implements LoginService {
    
    @Autowired
    private TUserDao userDao;
    
    @Autowired
	private TRoleDao roleDao;
    
    @Autowired
    private TRoleModuleGroupDao roleModuleGroupDao;
    
    @Autowired
    private TModuleGroupModuleDao moduleGroupModuleDao;
    
    @Autowired
    private TModuleDao moduleDao;
    
    @Autowired
    private TLoginLogDao loginLogDao;

    public Map<String, Object> login(String code, String password, String verifycodeInSession, String verifyCode, RoleContainer container, Map<String, Object> loginResulteMsg, TLoginLog log,
                                     Integer errorcount) {
        if (DataUtils.defaultString(verifyCode).equalsIgnoreCase(verifycodeInSession)) {// 验证码填写正确
            TUser user = userDao.getUserByCode(code);
            if (user != null) {
                log.setUid(DataUtils.newUUID());
                log.setUuserid(user.getUid());
                if ("autoLogin".equals(verifyCode) ? user.getCpassword().equals(password) : user.getCpassword().equals(EncryptionUtils.MD5(password))) {
                    container.setUser(user);
                    // 用户相关信息初始化，权限，部门，
                    List<TRole> roleList = roleDao.getRoleByUserId(user.getUid());
                    if(roleList != null && roleList.size() > 0){
                    	//账户存在角色
                    	if(roleList.size() > 1){
                    		//账号存在多个角色
                    		container.setRoles(roleList);
                    		//.....................待开发
                    	}else{
                    		//此账号只存在一个角色
                    		container.setRole(roleList.get(0));
                    		loadingModuleStr(container);
                    		loginResulteMsg.put("result", SUCCESS);
		                    loginResulteMsg.put("info", "登录成功");
		                    loginResulteMsg.put("errorcount",0);
		                    loginResulteMsg.put("isSuccess", true);
                    	}
                    }else{
                    	//账户不存在角色,此系统中作为未审核来判定
                    	loginResulteMsg.put("result", FAILURE);
                        loginResulteMsg.put("info", "此账号未审核,请联系管理员!");
                        loginResulteMsg.put("isSuccess", false);
                    }
                } else {
                    loginResulteMsg.put("result", FAILURE);
                    loginResulteMsg.put("info", "密码错误");
                    loginResulteMsg.put("isSuccess", false);
                    log.setCmemo("密码错误");
                }
            } else {
                loginResulteMsg.put("result", FAILURE);
                loginResulteMsg.put("info", "用户不存在");
                loginResulteMsg.put("isSuccess", false);
            }
        } else {
            loginResulteMsg.put("result", FAILURE);
            loginResulteMsg.put("info", "验证码错误");
            loginResulteMsg.put("isSuccess", false);
        }
        return loginResulteMsg;
    }
    
    private void loadingModuleStr(RoleContainer roleContainer){
        List<TRoleModuleGroup> roleModuleGroupList = roleModuleGroupDao.getRoleModuleGroupByRoleId(roleContainer.getRole().getUid());
        StringBuilder moduleCodes = new StringBuilder("|");
        if(roleModuleGroupList != null && roleModuleGroupList.size() > 0){
            for(TRoleModuleGroup roleGroup : roleModuleGroupList){
                List<TModuleGroupModule> moduleGroupList = moduleGroupModuleDao.getModuleGroupModuleByModuleGroupId(roleGroup.getUmodulegroupid());
                if(moduleGroupList != null && moduleGroupList.size() > 0){
                    for(TModuleGroupModule moduleGroup : moduleGroupList){
                        TModule module = moduleDao.getModuleByUid(moduleGroup.getUmoduleid());
                        moduleCodes.append(module.getCcode() + "|");
                    }
                }
            }
        }
        roleContainer.setModuleCodes(moduleCodes.toString());
    }

	public List<TModule> loadingModule(RoleContainer roleContainer) {
		List<TModule> moduleList = new ArrayList<TModule>();
		if(roleContainer != null && roleContainer.getRole() != null){
    		List<TRoleModuleGroup> roleModuleGroupList = roleModuleGroupDao.getRoleModuleGroupByRoleId(roleContainer.getRole().getUid());
    		if(roleModuleGroupList != null && roleModuleGroupList.size() > 0){
    			for(TRoleModuleGroup roleGroup : roleModuleGroupList){
    				List<TModuleGroupModule> moduleGroupList = moduleGroupModuleDao.getModuleGroupModuleByModuleGroupId(roleGroup.getUmodulegroupid());
    				if(moduleGroupList != null && moduleGroupList.size() > 0){
    					for(TModuleGroupModule moduleGroup : moduleGroupList){
    						TModule module = moduleDao.getModuleByUid(moduleGroup.getUmoduleid());
    						moduleList.add(module);
    					}
    				}
    			}
    		}
		}
		return moduleList;
	}

    public int addLoginLog(TLoginLog loginLog) {
        return loginLogDao.addLoginLog(loginLog);
    }
    
}
