package cn.lilacseeking.synthesize.order.service.dubbo.impl;

import cn.lilacseeking.synthesize.api.order.IOrderService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/28 21:17
 * @Description:
 */
@Service
public class OrderDubboServiceImpl implements IOrderService {

    @Override
    public Object getOrderById() {
        return null;
    }
}
