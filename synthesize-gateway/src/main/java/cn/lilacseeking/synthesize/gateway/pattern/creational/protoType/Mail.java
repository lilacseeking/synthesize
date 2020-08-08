package cn.lilacseeking.synthesize.gateway.pattern.creational.protoType;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 03:41
 * @Description:
 */
@Slf4j
@Data
public class Mail {

    private String name;
    private String emailAddress;
    private String content;

    public Mail() {
        log.info("原型模式：{}","Mail Constructor");
    }

}
