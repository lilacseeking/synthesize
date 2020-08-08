package cn.lilacseeking.synthesize.gateway.controller.rocketMQ;

import cn.lilacseeking.synthesize.gateway.configration.ProcessMessageUtils;
import cn.lilacseeking.synthesize.share.param.dto.rocketDTO.OrderInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: lilacseeking
 * @Date: 2020/8/8 15:03
 * @Description:
 */
@RestController
@RequestMapping(value = "/rocketMQ")
@Slf4j
public class RocketMQController {

    @Autowired
    private ProcessMessageUtils messageUtils;

    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public void createOrder(@RequestBody OrderInfoDTO orderInfoDTO, HttpServletResponse response){

        // 把请求放入RocketMQ中

        // Http返回
        messageUtils.putSuccess();
        messageUtils.writeMessage();
    }
}
