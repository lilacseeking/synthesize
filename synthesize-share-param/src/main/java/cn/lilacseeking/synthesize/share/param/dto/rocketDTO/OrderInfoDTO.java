package cn.lilacseeking.synthesize.share.param.dto.rocketDTO;

import cn.lilacseeking.synthesize.share.param.dto.BaseEntityDTO;
import com.alibaba.fastjson.JSON;
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

//    public static void main(String[] args) {
//        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
//        orderInfoDTO.setUserId("123456789");
//        orderInfoDTO.setPayId("12345");
//        orderInfoDTO.setSellerId("425325436");
//        orderInfoDTO.setTradeMethod("PAY");
//        orderInfoDTO.setDescription("单笔支付");
//        orderInfoDTO.setFinishTime("2020-08-09 02:22:02");
//        orderInfoDTO.setOrderNo("52354326");
//        orderInfoDTO.setOrderStatus("PAY_SUBMIT");
//
//        System.out.println(JSON.toJSONString(orderInfoDTO));
//    }
}
