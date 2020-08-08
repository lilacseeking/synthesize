package cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.publish;

import cn.lilacseeking.synthesize.gateway.configration.RabbitConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/18 02:04
 * @Description:
 */
@Component
@Slf4j
public class RabbitMQPublishProducerService {
    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public RabbitMQPublishProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 用户注册-发布订阅模式
     * @param content
     */
    public void sendUserRegisterPublishRabbitMQMsg(String content) {
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfiguration.REGISTER_SIMPLE_QUEUE, content);
    }
}
