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
    
    /**
     * 登录操作控制
     */
    @Autowired
    private LoginService loginService;
    
    /**
     * 用户操作控制
     */
    @Autowired
    private UserService userService;
    
    /**
     * 部门操作控制
     */
    @Autowired
    private DeptService deptService;
    
    /**
     * 公司操作控制
     */
    @Autowired
    private CorpService corpService;
    
    /**
     * 验证数据操作控制
     */
    @Autowired
    private AuxiliaryService auxiliaryService;
    
    /**
     * 角色数据控制
     */
    @Autowired
    private RoleService roleService;
    
    /**
     * 功能模块控制
     */
    @Autowired
    private ModuleService moduleService;
    
    /**
     * 功能模块组控制
     */
    @Autowired
    private ModuleGroupModuleService moduleGroupModuleService;
    
    /**
     * 产品类别控制
     */
    @Autowired
    private CategoryService categoryService;
    
    /**
     * 产品控制
     */
    @Autowired
    private ProductService productService;
    
    /**
     * 物料控制
     */
    @Autowired
    private MaterialService materialService;
    
    /**
     * 产品物料关联控制
     */
    @Autowired
    private ProductMaterialService productMaterialService;
    
    /**
     * 操作日志控制
     */
    @Autowired
    private OperateLogService operateLogService;
    
    /**
     * 订单控制
     */
    @Autowired
    private OrderService orderService;
    
    /**
     * 物料订单明细控制
     */
    @Autowired
    private OrderMaterialService orderMaterialService;
    
    /**
     * 产品订单明细控制
     */
    @Autowired
    private OrderProductService orderProductService;
    
    /**
     * 财务类型
     */
    @Autowired
    private AccountTypeService accountTypeService;
    
    /**
     * 财务单据
     */
    @Autowired
    private AccountOrderService accountOrderService;
    
    /**
     * 财务单据明细
     */
    @Autowired
    private AccountOrderDetailService accountOrderDetailService;
    
    /**
     * 账户管理
     */
    @Autowired
    private AccountService accountService;
    
    /**
     * 功能模块组
     */
    @Autowired
    private ModuleGroupService moduleGroupService;
    
    /**
     * 盘点差异
     */
    @Autowired
    private MaterialCheckDiffService materialCheckDiffService;
    
    /**
     * 供应商信息
     */
    @Autowired
    private SupplierService supplierService;
    
    /**
     * 客户信息
     */
    @Autowired
    private CustomerService customerService;
    
    /**
     * 客户类型信息
     */
    @Autowired
    private CustomerTypeService customerTypeService;
    
    /**
     * 同行信息
     */
    @Autowired
    private CounterPartsService counterPartsService;
    
    /**
     * 品牌信息
     */
    @Autowired
    private BrandService brandService;
    
    /**
     * 单位信息
     */
    @Autowired
    private UnitService unitService;
    
    /**
     * 颜色信息
     */
    @Autowired
    private ColorService colorService;
    
    /**
     * 付款方式信息
     */
    @Autowired
    private PaymentMethodService paymentMethodService;
    
    /**
     * 保修政策信息
     */
    @Autowired
    private WarrantyService warrantyService;
    
    /**
     * 其它商品信息
     */
    @Autowired
    private OtherGoodsService otherGoodsService;
    
    /**
     * 手机型号信息
     */
    @Autowired
    private PhoneModelService phoneModelService;
    
    /**
     * 供应商单据服务
     */
    @Autowired
    private SupplierOrderService supplierOrderService;
    
    /**
     * 供应商应收应付服务
     */
    @Autowired
    private SupplierReceivableService supplierReceivableService;
    
    /**
     * 供应商手机单据服务
     */
    @Autowired
    private SupplierPhoneOrderService supplierPhoneOrderService;
    
    /**
     * 供应商手机单据实收实付服务
     */
    @Autowired
    private SupplierPhoneOrderReceiptsService supplierPhoneOrderReceiptsService;
    
    /**
     * 获取 登录操作控制
     * @return loginService
     */
    public LoginService getLoginService() {
        return loginService;
    }
    
    /**
     * 获取 用户操作控制
     * @return userService
     */
    public UserService getUserService() {
        return userService;
    }
    
    /**
     * 获取 部门操作控制
     * @return deptService
     */
    public DeptService getDeptService() {
        return deptService;
    }
    
    /**
     * 获取 公司操作控制
     * @return corpService
     */
    public CorpService getCorpService() {
        return corpService;
    }
    
    /**
     * 获取 验证数据操作控制
     * @return auxiliaryService
     */
    public AuxiliaryService getAuxiliaryService() {
        return auxiliaryService;
    }
    
    /**
     * 获取 角色数据控制
     * @return roleService
     */
    public RoleService getRoleService() {
        return roleService;
    }
    
    /**
     * 获取 功能模块控制
     * @return moduleService
     */
    public ModuleService getModuleService() {
        return moduleService;
    }
    
    /**
     * 获取 功能模块组控制
     * @return moduleGroupModuleService
     */
    public ModuleGroupModuleService getModuleGroupModuleService() {
        return moduleGroupModuleService;
    }
    
    /**
     * 获取 产品类别控制
     * @return categoryService
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    /**
     * 获取 产品控制
     * @return productService
     */
    public ProductService getProductService() {
        return productService;
    }
    
    /**
     * 获取 物料控制
     * @return materialService
     */
    public MaterialService getMaterialService() {
        return materialService;
    }
    
    /**
     * 获取 产品物料关联控制
     * @return productMaterialService
     */
    public ProductMaterialService getProductMaterialService() {
        return productMaterialService;
    }
    
    /**
     * 获取 操作日志控制
     * @return operateLogService
     */
    public OperateLogService getOperateLogService() {
        return operateLogService;
    }
    
    /**
     * 获取 订单控制
     * @return orderService
     */
    public OrderService getOrderService() {
        return orderService;
    }
    
    /**
     * 获取 物料订单明细控制
     * @return orderMaterialService
     */
    public OrderMaterialService getOrderMaterialService() {
        return orderMaterialService;
    }
    
    /**
     * 获取 产品订单明细控制
     * @return orderProductService
     */
    public OrderProductService getOrderProductService() {
        return orderProductService;
    }
    
    /**
     * 获取 财务类型
     * @return accountTypeService
     */
    public AccountTypeService getAccountTypeService() {
        return accountTypeService;
    }
    
    /**
     * 获取 财务单据
     * @return accountOrderService
     */
    public AccountOrderService getAccountOrderService() {
        return accountOrderService;
    }
    
    /**
     * 获取 财务单据明细
     * @return accountOrderDetailService
     */
    public AccountOrderDetailService getAccountOrderDetailService() {
        return accountOrderDetailService;
    }
    
    /**
     * 获取 账户管理
     * @return accountService
     */
    public AccountService getAccountService() {
        return accountService;
    }
    
    /**
     * 获取 功能模块组
     * @return moduleGroupService
     */
    public ModuleGroupService getModuleGroupService() {
        return moduleGroupService;
    }
    
    /**
     * 获取 盘点差异
     * @return materialCheckDiffService
     */
    public MaterialCheckDiffService getMaterialCheckDiffService() {
        return materialCheckDiffService;
    }

	/**
	 * 获取:供应商信息操作控制
	 * @return supplierService
	 */
	public SupplierService getSupplierService() {
		return supplierService;
	}

	/**
	 * 获取:客户信息操作控制
	 * @return customerService
	 */
	public CustomerService getCustomerService() {
		return customerService;
	}

	/**
	 * 获取:客户类型信息操作控制
	 * @return customerTypeService
	 */
	public CustomerTypeService getCustomerTypeService() {
		return customerTypeService;
	}

	/**
	 * 获取:同行信息操作控制
	 * @return counterPartsService
	 */
	public CounterPartsService getCounterPartsService() {
		return counterPartsService;
	}

	/**
	 * 获取:品牌信息服务
	 * @return brandService
	 */
	public BrandService getBrandService() {
		return brandService;
	}

	/**
	 * 获取:单位信息服务
	 * @return unitService
	 */
	public UnitService getUnitService() {
		return unitService;
	}

	/**
	 * 获取:颜色信息服务
	 * @return colorService
	 */
	public ColorService getColorService() {
		return colorService;
	}

	/**
	 * 获取:付款方式服务
	 * @return paymentMethodService
	 */
	public PaymentMethodService getPaymentMethodService() {
		return paymentMethodService;
	}

	/**
	 * 获取:保修政策服务
	 * @return warrantyService
	 */
	public WarrantyService getWarrantyService() {
		return warrantyService;
	}

	/**
	 * 获取:其它商品信息
	 * @return otherGoodsService
	 */
	public OtherGoodsService getOtherGoodsService() {
		return otherGoodsService;
	}

	/**
	 * 获取:手机型号服务
	 * @return phoneModelService
	 */
	public PhoneModelService getPhoneModelService() {
		return phoneModelService;
	}

	/**
	 * 获取:供应商单据服务
	 * @return supplierOrderService
	 */
	public SupplierOrderService getSupplierOrderService() {
		return supplierOrderService;
	}

	/**
	 * 获取:供应商应收应付服务
	 * @return supplierReceivableService
	 */
	public SupplierReceivableService getSupplierReceivableService() {
		return supplierReceivableService;
	}

    
    /**
     * 获取 供应商手机单据服务
     * @return supplierPhoneOrderService
     */
    public SupplierPhoneOrderService getSupplierPhoneOrderService() {
        return supplierPhoneOrderService;
    }

    
    /**
     * 获取 供应商手机单据实收实付服务
     * @return supplierPhoneOrderReceiptsService
     */
    public SupplierPhoneOrderReceiptsService getSupplierPhoneOrderReceiptsService() {
        return supplierPhoneOrderReceiptsService;
    }
    
    
}
