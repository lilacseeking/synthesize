package cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.simple;

import cn.lilacseeking.synthesize.gateway.configration.RabbitConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Auther: lilacseeking
 * @Date: 2020/5/18 01:46
 * @Description:
 */
@Component
@Slf4j
public class RabbitMQProduceSimpleService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProduceSimpleService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 用户注册-简单模式
     * @param content
     */
    public void sendUserRegisterSimpleRabbitMQMsg(String content) {
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfiguration.REGISTER_SIMPLE_QUEUE, content);
    }
}
