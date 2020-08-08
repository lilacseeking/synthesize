package cn.lilacseeking.test;

import cn.lilacseeking.synthesize.gateway.pattern.creational.factoryMethod.JavaVideoFactory;
import cn.lilacseeking.synthesize.gateway.pattern.creational.factoryMethod.VideoFactory;
import org.junit.Test;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 01:52
 * @Description:
 */
public class FactoryMethodTest {
    @Test
    public void getJavaVideo(){
        VideoFactory videoFactory = new JavaVideoFactory();
        videoFactory.getVideo();
    }
}
