package cn.lilacseeking.synthesize.gateway.controller.zookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 11:17
 * @Description:
 */
@RestController
@RequestMapping(value = "/zookeeper")
public class ZookeeperController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test() {
        String s = restTemplate.getForObject("http://synthesize/pro/test", String.class);
        return s;
    }
}
