package cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.work;

import cn.lilacseeking.synthesize.gateway.configration.RabbitConfiguration;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 19:54
 * @Description:
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitConfiguration.REGISTER_WORK_QUEUE)
public class RabbitMqWorkConsumerSecondService {

    @RabbitHandler
    public void process(Object content) {
        log.info("WORK模式下消费者Second接收处理队列当中的消息： {}" ,JSON.toJSONString(content));
    }
}
