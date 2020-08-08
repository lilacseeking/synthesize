package cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.work;


import cn.lilacseeking.synthesize.gateway.configration.RabbitConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 21:03
 * @Description:
 */
@Component
@Slf4j
public class RabbitMQWorkProducerService implements RabbitTemplate.ConfirmCallback{

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public RabbitMQWorkProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息成功消费");
        } else {
            log.info("消息消费失败:" + cause);
        }
    }

    /**
     * 用户注册-工作模式
     * @param content
     */
    public void sendUserRegisterSimpleRabbitMQMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfiguration.REGISTER_WORK_EXCHANGE, RabbitConfiguration.REGISTER_WORK_ROUTING_KEY, content,correlationId);
    }
}
