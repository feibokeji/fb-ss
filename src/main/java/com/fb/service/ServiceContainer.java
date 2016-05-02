package com.fb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 基础Service
 * @since 2015-6-18 下午4:56:51
 * @author Liu bo
 */
@Service
public class ServiceContainer {
    
    
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private DeptService deptService;
    
    @Autowired
    private CorpService corpService;
    
    @Autowired
    private AuxiliaryService auxiliaryService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private ModuleService moduleService;
    
    @Autowired
    private ModuleGroupModuleService moduleGroupModuleService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    public LoginService getLoginService() {
        return loginService;
    }
    
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
    
    public UserService getUserService() {
        return userService;
    }
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public DeptService getDeptService() {
        return deptService;
    }
    
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }
    
    public CorpService getCorpService() {
        return corpService;
    }
    
    public void setCorpService(CorpService corpService) {
        this.corpService = corpService;
    }
    
    public AuxiliaryService getAuxiliaryService() {
        return auxiliaryService;
    }
    
    public void setAuxiliaryService(AuxiliaryService auxiliaryService) {
        this.auxiliaryService = auxiliaryService;
    }
    
    public RoleService getRoleService() {
        return roleService;
    }
    
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    
    public ModuleService getModuleService() {
        return moduleService;
    }
    
    public void setModuleService(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
    
    public ModuleGroupModuleService getModuleGroupModuleService() {
        return moduleGroupModuleService;
    }
    
    public void setModuleGroupModuleService(ModuleGroupModuleService moduleGroupModuleService) {
        this.moduleGroupModuleService = moduleGroupModuleService;
    }
    
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    public ProductService getProductService() {
        return productService;
    }
    
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
}
