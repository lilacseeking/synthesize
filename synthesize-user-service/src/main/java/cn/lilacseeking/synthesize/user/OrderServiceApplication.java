package cn.lilacseeking.synthesize.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/16 02:10
 * @Description:
 */
@SpringBootApplication
@EntityScan({"cn.lilacseeking.*"})
@ComponentScan(basePackages = {"cn.lilacseeking.*"})
@EnableDiscoveryClient
@EnableDubbo(scanBasePackages = "cn.lilacseeking.synthesize.*")
public class OrderServiceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(OrderServiceApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
