package cn.lilacseeking.synthesize.gateway.controller.rabbitMQ;

import cn.lilacseeking.synthesize.core.shading.service.UserInfoService;
import cn.lilacseeking.synthesize.gateway.configration.ProcessMessageUtils;
import cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.simple.RabbitMQProduceSimpleService;
import cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.publish.RabbitMQPublishProducerService;
import cn.lilacseeking.synthesize.gateway.mq.rabbitMQ.work.RabbitMQWorkProducerService;
import cn.lilacseeking.synthesize.infrastructure.utils.PageUtil;
import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 20:02
 * @Description:
 */
@RestController
@RequestMapping(value = "/rabbitMQ")
@Slf4j
public class RabbitMQController {

    @Autowired
    private ProcessMessageUtils messageUtils;

    @Autowired
    private RabbitMQWorkProducerService workProducerService;

    @Autowired
    private RabbitMQProduceSimpleService produceSimpleService;

    @Autowired
    private RabbitMQPublishProducerService publishProducerService;
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 分页查询用户列表
     * @param params
     * @param response
     */

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public void getUserById(@RequestBody String params , HttpServletResponse response){
        PageUtil page = null;
        try {
            page = userInfoService.listAllUser(params);
            messageUtils.putSuccess(page);
        }catch (Exception e){
            e.printStackTrace();
            messageUtils.putError(e);
        }
        messageUtils.writeMessage(response);
    }

    /**
     * 用户注册-简单模式
     */
    @RequestMapping(value = "/registerUserSimple",method = RequestMethod.POST)
    public void registerUserSimple(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response){
        log.info("用户注册请求参数：{}", JSON.toJSONString(userInfoDTO));
        // 存入RabbitMQ
        produceSimpleService.sendUserRegisterSimpleRabbitMQMsg(JSON.toJSONString(userInfoDTO));
        messageUtils.putSuccess();
        messageUtils.writeMessage(response);
    }

    /**
     * 用户注册-工作模式
     */
    @RequestMapping(value = "/registerUserWork",method = RequestMethod.POST)
    public void registerUserWork(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response){
        log.info("用户注册请求参数：{}", JSON.toJSONString(userInfoDTO));
        // 存入RabbitMQ
        workProducerService.sendUserRegisterSimpleRabbitMQMsg(JSON.toJSONString(userInfoDTO));
        messageUtils.putSuccess();
        messageUtils.writeMessage(response);
    }

    /**
     * 用户注册-发布订阅模式
     */
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public void registerUser(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response){
        log.info("用户注册请求参数：{}", JSON.toJSONString(userInfoDTO));
        // 存入RabbitMQ
        publishProducerService.sendUserRegisterPublishRabbitMQMsg(JSON.toJSONString(userInfoDTO));
        messageUtils.putSuccess();
        messageUtils.writeMessage(response);
    }
//
//    /**
//     * 用户注册-路由模式
//     */
//    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
//    public void registerUser(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response){
//        log.info("用户注册请求参数：{}", JSON.toJSONString(userInfoDTO));
//        // 存入RabbitMQ
//        rabbitMqProducerService.sendUserRegisterRabbitMQMsg(JSON.toJSONString(userInfoDTO));
//        messageUtils.putSuccess();
//        messageUtils.writeMessage(response);
//    }
//
//    /**
//     * 用户注册-topic模式
//     */
//    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
//    public void registerUser(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response){
//        log.info("用户注册请求参数：{}", JSON.toJSONString(userInfoDTO));
//        // 存入RabbitMQ
//        rabbitMqProducerService.sendUserRegisterRabbitMQMsg(JSON.toJSONString(userInfoDTO));
//        messageUtils.putSuccess();
//        messageUtils.writeMessage(response);
//    }
//
//    /**
//     * 用户注册-RPC
//     */
//    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
//    public void registerUser(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response){
//        log.info("用户注册请求参数：{}", JSON.toJSONString(userInfoDTO));
//        // 存入RabbitMQ
//        rabbitMqProducerService.sendUserRegisterRabbitMQMsg(JSON.toJSONString(userInfoDTO));
//        messageUtils.putSuccess();
//        messageUtils.writeMessage(response);
//    }
//
//    /**
//     * 用户注册
//     */
//    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
//    public void registerUser(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response){
//        log.info("用户注册请求参数：{}", JSON.toJSONString(userInfoDTO));
//        // 存入RabbitMQ
//        rabbitMqProducerService.sendUserRegisterRabbitMQMsg(JSON.toJSONString(userInfoDTO));
//        messageUtils.putSuccess();
//        messageUtils.writeMessage(response);
//    }
}
