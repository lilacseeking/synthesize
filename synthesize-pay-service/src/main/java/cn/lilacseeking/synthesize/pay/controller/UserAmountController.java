package cn.lilacseeking.synthesize.pay.controller;

import cn.lilacseeking.synthesize.pay.configuration.ProcessMessageUtils;
import cn.lilacseeking.synthesize.pay.service.AbstractUserAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: lilacseeking
 * @Date: 2020/8/2 00:13
 * @Description:
 */
@RestController
@RequestMapping(value = "/userAmount", method = RequestMethod.POST)
public class UserAmountController {

    @Autowired
    private ProcessMessageUtils messageUtils;

    /**
     * 获取用户余额
     *
     * @return
     */
    @RequestMapping(value = "/getUserAmount", method = RequestMethod.POST)
    public void getUserAmount(@RequestBody Object object, HttpServletResponse res) {
        // 获取支付策略

        messageUtils.putSuccess();
        messageUtils.writeMessage();
    }

}
