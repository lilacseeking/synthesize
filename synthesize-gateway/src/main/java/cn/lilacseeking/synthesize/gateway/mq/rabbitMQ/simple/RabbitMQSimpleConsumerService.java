package cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.simple;

import cn.lilacseeking.synthesize.api.user.IUserService;
import cn.lilacseeking.synthesize.core.shading.service.UserInfoService;
import cn.lilacseeking.synthesize.gateway.configration.RabbitConfiguration;
import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/18 01:59
 * @Description:
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitConfiguration.REGISTER_SIMPLE_QUEUE)
public class RabbitMQSimpleConsumerService {

    private static final String UTF8 = "UTF-8";

    @Autowired
    private UserInfoService userInfoService;
    @Reference
    private IUserService iUserService;

    @RabbitHandler
    public void process(Object object) throws Exception{
        Message message = (Message) object;
        UserInfoDTO userInfoDTO = analysisMqMessage(message, UserInfoDTO.class);
        log.info("简单模式下接收处理队列当中的消息： {}" ,JSON.toJSONString(userInfoDTO));
//        userInfoService.register(userInfoDTO);
        iUserService.saveUserInfo(userInfoDTO);
    }

    /**
     * 解析mq message
     * @param message
     * @param clazz
     * @param <T>
     * @return
     * @throws UnsupportedEncodingException
     */
    private static <T> T analysisMqMessage(Message message, Class<T> clazz) throws IOException {
        byte[] body = message.getBody();
        String msg = new String(body, UTF8);
        return JSON.parseObject(msg, clazz);
    }
}
