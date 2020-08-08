package cn.lilacseeking.synthesize.gateway.controller.zookeeper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 13:25
 * @Description:
 */
@RestController
@RequestMapping(value = "pro")
public class ProController {

    @RequestMapping("/test")
    public String test() {
        return "hello-zookepper";
    }
}
