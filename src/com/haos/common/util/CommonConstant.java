package com.haos.common.util;

/**
 * Common Constant
 * @author Helios
 *
 */
public class CommonConstant {

	 /**
     * 没有删除标志
     */
    public static  final int YN_NO_DELETE = 0;

    /**
     * 删除标志
     */
    public static  final int YN_DELETE = 1;
    /**
     *  员工是否加入权限功能池（没有加入）
     */
    public static  final Byte STATUS_DISAVAILABLE = 0;
    /**
     *  员工是否加入权限功能池（已经加入）
     */
    public static  final Byte STATUS_AVAILABLE = 1;

    /**
     * 每页大小
     */
    public static final int PAGESIZE = 15; 
    
    /**
     * 订单状态->订单处理中
     */
    public static  final Byte ORDER_DEALING = 1;
    
    /**
     * 订单状态->订单已经出库
     */
    public static  final Byte ORDER_OUTBOUND = 2;
    
    /**
     * 订单状态->订单配送中
     */
    public static  final Byte ORDER_DISPATCHING = 3;
    
    /**
     * 订单状态->订单完成
     */
    public static  final Byte ORDER_FINISH = 4;
    
    /**
     * 支付方式->货到付款
     */
    public static final  Byte PAYMENT_METHOD_ONE=1;
    /**
     * 支付方式->邮政付款
     */
    public static final  Byte PAYMENT_METHOD_TWO=2;
    /**
     * 配送方式->只工作日送货（双休日、假日不用送）
     */
    public static final  Byte SHIPPING_METHOD_ONE=1;
    
    /**
     * 配送方式->工作日、双休日与假日均可送货
     */
    public static final  Byte SHIPPING_METHOD_TWO=2;
    

    /**
     * 配送方式->只双休日、假日送货（工作日不用送）
     */
    public static final  Byte SHIPPING_METHOD_THREE=3;
    
    /**
     * 用户每次下订单赠送2积分
     */
    public static  final Byte INTEGRAL_ORDER = 2;
    
    /**
     * 用户每次评价所购买的商品赠送4积分
     */
    public static  final Byte INTEGRAL_COMMENT = 4;

    /**
     * 功能信息默认父节点
     */
    public static final String DEFAULT_PARENT_CODE="001";

    /**
     * 员工&权限管理
     */
    public static final Byte SYSTEM_MODULE_ONE=1;
    
    /**
     * 商品&商品类别管理
     */
    public static final Byte SYSTEM_MODULE_TWO=2;

    /**
     * 用户&订单&消费记录管理
     */
    public static final Byte SYSTEM_MODULE_THREE=3;

    /**
     * 配送&配送类别管理
     */
    public static final Byte SYSTEM_MODULE_FOUR=4;

    /**
     * 是否是配送员工
     */
    public static final String IS_SENDEMPLOYEE_FLAG="PS";

    

}
