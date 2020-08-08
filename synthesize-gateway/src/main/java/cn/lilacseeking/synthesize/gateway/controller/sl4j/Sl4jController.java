package cn.lilacseeking.synthesize.gateway.controller.sl4j;

import cn.lilacseeking.synthesize.gateway.configration.ProcessMessageUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/16 01:02
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping(value = "/sl4j")
public class Sl4jController {

    @Autowired
    private ProcessMessageUtils messageUtils;

    @RequestMapping(value = "/printSl4JLog",method = RequestMethod.POST)
    public void printSl4JLog(@RequestBody JSONObject params , HttpServletResponse response){
        log.error("请求参数为：{}",params.toJSONString());
        messageUtils.putSuccess("请求成功");
    }
}
