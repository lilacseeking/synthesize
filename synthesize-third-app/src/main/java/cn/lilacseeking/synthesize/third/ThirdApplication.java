package cn.lilacseeking.synthesize.third;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/16 02:10
 * @Description:
 */
@SpringBootApplication
@EntityScan({"cn.lilacseeking.*"})
@ComponentScan(basePackages = {"cn.lilacseeking.synthesize.third.*"})
@EnableDubbo(scanBasePackages = "cn.lilacseeking.synthesize.third.*")
public class ThirdApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ThirdApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
