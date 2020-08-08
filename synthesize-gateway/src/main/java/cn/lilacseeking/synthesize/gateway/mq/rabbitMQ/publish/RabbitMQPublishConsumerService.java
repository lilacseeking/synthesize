package cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.publish;

import cn.lilacseeking.synthesize.gateway.configration.RabbitConfiguration;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/18 13:31
 * @Description:
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitConfiguration.REGISTER_PUBLISH_EXCHANGE)
public class RabbitMQPublishConsumerService {

    @RabbitHandler
    public void process(Object content) {
        log.info("发布订阅模式下接收处理队列当中的消息： {}" ,JSON.toJSONString(content));
    }
}
