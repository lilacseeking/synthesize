package cn.lilacseeking.synthesize.gateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/16 02:10
 * @Description:
 */
@SpringBootApplication
@RestController
//@EnableApolloConfig
@EntityScan({"cn.lilacseeking.*"})
@ComponentScan(basePackages = {"cn.lilacseeking.*"})
@EnableDiscoveryClient
@EnableAspectJAutoProxy
@EnableDubbo(scanBasePackages = "cn.lilacseeking.synthesize.*")
public class GatewayApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(GatewayApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
