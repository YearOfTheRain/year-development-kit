package org.year.zookeeper.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单
 *
 * @author dell
 * @email 7049629@qq.com
 * @date 2021-10-09 09:44:52
 */
@Data
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String id;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 商品类型
     */
    private String goodsType;
    /**
     * 当商品类型是course为课程id，是商品类型是会员对应动态参数id，企业打包购买对应动态参数id
     */
    private String goodsId;

    private String goodsName;
    /**
     * 归属企业ID
     */
    private String ownerEnterpriseId;

    /**
     * 代理商可见；0-不可见；1-可见
     */
    private Integer proxyCanSee;
    /**
     * 商品数量
     */
    private String goodsQuantity;
    /** 可用数量（目前做易管产品购买数量） */
    private Integer availableQuantity;
    /**
     * 0是主订单，1是子订单
     */
    private String isMain;
    /**
     * 当订单是子订单填写主订单id
     */
    private String mainOrderId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 第三方支付流水号
     */
    private String paymentNo;
    /**
     * 活动id
     */
    private String activityId;
    /**
     * 支付活动(正常购买/拼团/秒杀...)
     */
    private String activityType;
    /**
     * 拼团id
     */
    private String groupInfoId;
    /**
     * 成团人数
     */
    private Integer groupNumber;
    /**
     * 活动商品中间id
     */
    private String activityCourseId;
    /**
     * 用户优惠券Id
     */
    private String userCouponId;
    /**
     * 原价
     */
    private BigDecimal originalPrice;
    /**
     * 优惠后价格
     */
    private BigDecimal discountedPrice;
    /**
     * 实际支付价格
     */
    private BigDecimal amountPay;
    /**
     * 支付方式
     */
    private String payType;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 企业id(企业账号购买才有)
     */
    private String enterpriseId;
    /**
     * 创建用户id
     */
    private String createUserId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 订单未支付过期时间
     */
    private LocalDateTime cancelTime;
    /**
     * 修改用户id
     */
    private String updateUserId;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 删除标识(0未删除 1删除)
     */
    private String ifDelete;
    /**
     * 下单渠道(公众号/h5/app/...)
     */
    private String source;

    private String sysUserId;

    private String clerkId;

    /** 交付时间  */
    private LocalDateTime deliveryCheck;


    private String shareId;


    private String placeId;


    private Integer ifBuyOut;

    /**
     * 代理企业序列号
     */

    private String enterpriseSerialNo;

    /**
     * 代理员工序列号
     */

    private String employeeSerialNo;
    /** 前端传值渠道码（最高优先级） */

    private String serialNumber;



    /**
     * 复制一份用于纯更新操作的对象
     * @return
     */
    public static OrderEntity create(String id) {
        OrderEntity order = new OrderEntity();
        order.setId(id);
        return order;
    }


}
