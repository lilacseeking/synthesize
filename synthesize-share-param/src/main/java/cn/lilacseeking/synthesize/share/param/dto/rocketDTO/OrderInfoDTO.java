package cn.lilacseeking.synthesize.share.param.dto.rocketDTO;

import cn.lilacseeking.synthesize.share.param.dto.BaseEntityDTO;
import lombok.Data;

/**
 * @Auther: lilacseeking
 * @Date: 2020/8/8 15:27
 * @Description:
 */
@Data
public class OrderInfoDTO extends BaseEntityDTO {
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 支付方编号
     */
    private String payId;
    /**
     * 收款方编号
     */
    private String sellerId;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 交易完成时间
     */
    private String finishTime;
    /**
     * 交易方式
     */
    private String tradeMethod;
    /**
     * 描述
     */
    private String description;
    /**
     * 交易编号
     */
    private String tradeId;
}
