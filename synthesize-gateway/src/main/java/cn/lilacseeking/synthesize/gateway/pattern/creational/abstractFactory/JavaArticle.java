package cn.lilacseeking.synthesize.gateway.pattern.creational.abstractFactory;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 02:24
 * @Description:
 */
@Slf4j
public class JavaArticle extends Article{
    @Override
    public void process() {
        log.info("abstractFactory---获取Java文章成功,时间:{}", DateUtil.now());
    }
}
