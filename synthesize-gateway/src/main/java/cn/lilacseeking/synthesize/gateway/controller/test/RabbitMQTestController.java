package cn.lilacseeking.synthesize.gateway.controller.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.lilacseeking.synthesize.infrastructure.utils.RandomValueUtil;
import cn.lilacseeking.synthesize.infrastructure.utils.StringUtil;
import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 20:18
 * @Description:
 */
@RestController
@RequestMapping(value = "/testRabbitMQ")
@Slf4j
public class RabbitMQTestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/testRegisterUserSimple", method = RequestMethod.POST)
    public void testRegisterUserSimple() {
        sendMessage("http://synthesize/rabbitMQ/registerUserSimple");
    }

    @RequestMapping(value = "/testRegisterUserWork", method = RequestMethod.POST)
    public void testRegisterUserWork() {
        sendMessage("http://synthesize/rabbitMQ/registerUserWork");
    }

//    @RequestMapping(value = "/testRegisterUserWork", method = RequestMethod.POST)
//    public void testRegisterUserWork() {
//        sendMessage("http://synthesize/rabbitMQ/registerUserWork");
//    }
//
//    @RequestMapping(value = "/testRegisterUserWork", method = RequestMethod.POST)
//    public void testRegisterUserWork() {
//        sendMessage("http://synthesize/rabbitMQ/registerUserWork");
//    }
//    @RequestMapping(value = "/testRegisterUserWork", method = RequestMethod.POST)
//    public void testRegisterUserWork() {
//        sendMessage("http://synthesize/rabbitMQ/registerUserWork");
//    }
//

    public void sendMessage(String url){
        int i = 5;
        while (i>0) {
            DateTime randomBirthday = DateUtil.date();
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setAge(StringUtil.getAge(randomBirthday));//由出生日期获取年龄
            userInfoDTO.setBirthday(randomBirthday);
            userInfoDTO.setEmail(RandomValueUtil.getEmail(8, 12));
            userInfoDTO.setGender(Math.random() > 0.5 ? 1 : 0);//随机生成性别
            userInfoDTO.setMobile(RandomValueUtil.getTelephone());//随机生成手机号码
            userInfoDTO.setPassword("123456");
            userInfoDTO.setUsername(RandomValueUtil.getRandomUserName((int) (2 + Math.random() * 3)));
            userInfoDTO.setName(RandomValueUtil.getChineseName());
            userInfoDTO.setUserId(new Random().nextInt());
            userInfoDTO.setDatabaseId(new Random().nextInt());
            log.info("用户注册信息：{}", JSON.toJSONString(userInfoDTO));
            String result = restTemplate.postForObject(url, userInfoDTO, String.class);
            log.info("调用注册接口返回结果：{}", result);
            i--;
        }
    }
}
