package cn.lilacseeking.synthesize.gateway.pattern.creational.factoryMethod;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 00:26
 * @Description:
 */
@Slf4j
public class JavaVideo extends Video {

    public JavaVideo() {
        log.info("javaVideo被实例化了，时间：{}", DateUtil.now());
    }
}
