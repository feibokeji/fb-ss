package com.fb.domain.vo;

import com.fb.core.base.domain.BaseDomain;

/**
 * 前台销售按商品汇总EXCEL实体类
 * @since 2016年5月10日 下午8:05:44
 * @author Liu bo
 */
public class ExcelProductSell extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2531253989802705500L;
    
    /**
     * 序号
     */
    private Integer number;
    
    /**
     * 类别
     */
    private String category_name;
    
    /**
     * 产品编码
     */
    private String product_code;
    
    /**
     * 产品名称
     */
    private String product_name;
    
    /**
     * 销售数量
     */
    private Double s_qty;
    
    /**
     * 销售金额
     */
    private Double s_amount;
    
    /**
     * 退货数量
     */
    private Double b_qty;
    
    /**
     * 退货金额
     */
    private Double b_amount;
    
    /**
     * 赠送数量
     */
    private Double g_qty;
    
    /**
     * 赠送金额
     */
    private Double g_amount;
    
    /**
     * 数量小计
     */
    private Double qty_subtotal;
    
    /**
     * 金额小计
     */
    private Double amount_subtotal;
    
    /**
     * 参考进价
     */
    private Double reference_price;
    
    /**
     * 进价金额
     */
    private Double purchase_price;
    
    /**
     * 参考利润
     */
    private Double reference_profits;
    
    /**
     * 获取 序号
     * @return number
     */
    public Integer getNumber() {
        return number;
    }
    
    /**
     * 设置 序号
     * @param number 序号
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    /**
     * 获取 类别
     * @return category_name
     */
    public String getCategory_name() {
        return category_name;
    }
    
    /**
     * 设置 类别
     * @param category_name 类别
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
    /**
     * 获取 产品编码
     * @return product_code
     */
    public String getProduct_code() {
        return product_code;
    }
    
    /**
     * 设置 产品编码
     * @param product_code 产品编码
     */
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
    
    /**
     * 获取 产品名称
     * @return product_name
     */
    public String getProduct_name() {
        return product_name;
    }
    
    /**
     * 设置 产品名称
     * @param product_name 产品名称
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    
    /**
     * 获取 销售数量
     * @return s_qty
     */
    public Double getS_qty() {
        return s_qty;
    }
    
    /**
     * 设置 销售数量
     * @param s_qty 销售数量
     */
    public void setS_qty(Double s_qty) {
        this.s_qty = s_qty;
    }
    
    /**
     * 获取 销售金额
     * @return s_amount
     */
    public Double getS_amount() {
        return s_amount;
    }
    
    /**
     * 设置 销售金额
     * @param s_amount 销售金额
     */
    public void setS_amount(Double s_amount) {
        this.s_amount = s_amount;
    }
    
    /**
     * 获取 退货数量
     * @return b_qty
     */
    public Double getB_qty() {
        return b_qty;
    }
    
    /**
     * 设置 退货数量
     * @param b_qty 退货数量
     */
    public void setB_qty(Double b_qty) {
        this.b_qty = b_qty;
    }
    
    /**
     * 获取 退货金额
     * @return b_amount
     */
    public Double getB_amount() {
        return b_amount;
    }
    
    /**
     * 设置 退货金额
     * @param b_amount 退货金额
     */
    public void setB_amount(Double b_amount) {
        this.b_amount = b_amount;
    }
    
    /**
     * 获取 赠送数量
     * @return g_qty
     */
    public Double getG_qty() {
        return g_qty;
    }
    
    /**
     * 设置 赠送数量
     * @param g_qty 赠送数量
     */
    public void setG_qty(Double g_qty) {
        this.g_qty = g_qty;
    }
    
    /**
     * 获取 赠送金额
     * @return g_amount
     */
    public Double getG_amount() {
        return g_amount;
    }
    
    /**
     * 设置 赠送金额
     * @param g_amount 赠送金额
     */
    public void setG_amount(Double g_amount) {
        this.g_amount = g_amount;
    }
    
    /**
     * 获取 数量小计
     * @return qty_subtotal
     */
    public Double getQty_subtotal() {
        return qty_subtotal;
    }
    
    /**
     * 设置 数量小计
     * @param qty_subtotal 数量小计
     */
    public void setQty_subtotal(Double qty_subtotal) {
        this.qty_subtotal = qty_subtotal;
    }
    
    /**
     * 获取 金额小计
     * @return amount_subtotal
     */
    public Double getAmount_subtotal() {
        return amount_subtotal;
    }
    
    /**
     * 设置 金额小计
     * @param amount_subtotal 金额小计
     */
    public void setAmount_subtotal(Double amount_subtotal) {
        this.amount_subtotal = amount_subtotal;
    }
    
    /**
     * 获取 参考进价
     * @return reference_price
     */
    public Double getReference_price() {
        return reference_price;
    }
    
    /**
     * 设置 参考进价
     * @param reference_price 参考进价
     */
    public void setReference_price(Double reference_price) {
        this.reference_price = reference_price;
    }
    
    /**
     * 获取 进价金额
     * @return purchase_price
     */
    public Double getPurchase_price() {
        return purchase_price;
    }
    
    /**
     * 设置 进价金额
     * @param purchase_price 进价金额
     */
    public void setPurchase_price(Double purchase_price) {
        this.purchase_price = purchase_price;
    }
    
    /**
     * 获取 参考利润
     * @return reference_profits
     */
    public Double getReference_profits() {
        return reference_profits;
    }
    
    /**
     * 设置 参考利润
     * @param reference_profits 参考利润
     */
    public void setReference_profits(Double reference_profits) {
        this.reference_profits = reference_profits;
    }
    
}
