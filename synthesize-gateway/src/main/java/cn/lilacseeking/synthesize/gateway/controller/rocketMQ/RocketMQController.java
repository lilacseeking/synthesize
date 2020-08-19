package cn.lilacseeking.synthesize.gateway.controller.rocketMQ;

import cn.lilacseeking.synthesize.gateway.configration.ProcessMessageUtils;
import cn.lilacseeking.synthesize.gateway.mq.rocketMQ.OrderInfoProducer;
import cn.lilacseeking.synthesize.share.param.dto.rocketDTO.OrderInfoDTO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
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

    @Autowired
    private OrderInfoProducer orderInfoProducer;

    /**
     * topic
     */
    private static final String topic = "my_topic_test01";

    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public void createOrder(@RequestBody OrderInfoDTO orderInfoDTO, HttpServletResponse response){

        // 把请求放入RocketMQ中
        Message message = new Message(topic,"lcl",("hello RocketMQ"+JSON.toJSONString(orderInfoDTO)).getBytes());
        SendResult sendResult = null;
        try {
            sendResult = orderInfoProducer.getProducer().send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Http返回
        messageUtils.putSuccess(JSON.toJSONString(sendResult));
        messageUtils.writeMessage();
    }
}
