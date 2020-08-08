package cn.lilacseeking.test;

import cn.lilacseeking.synthesize.core.aop.MathCalculator;
import cn.lilacseeking.synthesize.gateway.configration.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/25 23:40
 * @Description:
 */
public class IOCTest_AOP {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        applicationContext.register();

        mathCalculator.div(1, 0);

        applicationContext.close();
    }
    @Test
    public void test02(){
        System.out.println(new Random().nextInt() % 2);
    }
}
