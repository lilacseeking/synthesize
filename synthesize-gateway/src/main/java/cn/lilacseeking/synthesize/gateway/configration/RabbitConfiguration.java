package cn.lilacseeking.synthesize.gateway.configration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 19:36
 * @Description:
 * Broker:它提供一种传输服务,它的角色就是维护一条从生产者到消费者的路线，保证数据能按照指定的方式进行传输,
 * Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
 * Queue:消息的载体,每个消息都会被投到一个或多个队列。
 * Binding:绑定，它的作用就是把exchange和queue按照路由规则绑定起来.
 * Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
 * vhost:虚拟主机,一个broker里可以有多个vhost，用作不同用户的权限分离。
 * Producer:消息生产者,就是投递消息的程序.
 * Consumer:消息消费者,就是接受消息的程序.
 * Channel:消息通道,在客户端的每个连接里,可建立多个channel.
 */
@Configuration
public class RabbitConfiguration {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;


    public static final String REGISTER_WORK_EXCHANGE = "register-work-exchange";
    public static final String REGISTER_PUBLISH_EXCHANGE = "register-publish-exchange";


    public static final String REGISTER_WORK_QUEUE = "register-work-queue";
    public static final String REGISTER_SIMPLE_QUEUE = "register-simple-queue";
    public static final String REGISTER_PUBLISH_QUEUE = "register-publish-queue";

    public static final String REGISTER_WORK_ROUTING_KEY = "register-work-routing-key";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange workExchange() {
        return new DirectExchange(REGISTER_WORK_EXCHANGE);
    }

    @Bean
    public DirectExchange publishExchange() {
        return new DirectExchange(REGISTER_PUBLISH_EXCHANGE);
    }
    /**
     * 获取用户注册队列-简单模式
     * @return
     */
    @Bean
    public Queue registerSimpleQueue(){
        return new Queue(REGISTER_SIMPLE_QUEUE,true);
    }

    /**
     * 获取用户注册-工作模式
     * @return
     */
    @Bean
    public Queue registerWorkQueue(){
        return new Queue(REGISTER_WORK_QUEUE,true);
    }

    /**
     * 获取用户注册-发布订阅模式
     * @return
     */
    @Bean
    public Queue registerPublishQueue(){
        return new Queue(REGISTER_PUBLISH_EXCHANGE,true);
    }

    /**
     * 绑定用户注册工作模式队列至路由
     * @return
     */
    @Bean
    public Binding bindingRegisterSampleQueue(){
        return BindingBuilder.bind(registerWorkQueue()).to(workExchange()).with(RabbitConfiguration.REGISTER_WORK_ROUTING_KEY);
    }

    /**
     * 绑定用户注册发布订阅模式队列至路由
     * @return
     */
    @Bean
    public Binding bindingRegisterPublishQueue(){
        return BindingBuilder.bind(registerPublishQueue()).to(publishExchange()).with("");
    }
}
