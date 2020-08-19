package cn.lilacseeking.synthesize.gateway.mq.rocketMQ;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * @Auther: lilacseeking
 * @Date: 2020/8/9 01:21
 * @Description:
 */
@Component
public class OrderInfoProducer {

    /**
     * 生产组，生产者必须在生产组内
     */
    private String producerGroup = "newTest_group";

    /**
     * nameSrv IP及端口
     */
    private String nameSrv = "127.0.0.1:9876";

    /**
     * 生产者
     */
    private DefaultMQProducer producer;

    /**
     * 设置producer对应的组及namesrv信息，并启动producer
     */
    public OrderInfoProducer(){
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(nameSrv);
        start();
    }

    /**
     * 获取producer
     * @return
     */
    public DefaultMQProducer getProducer(){
        return producer;
    }

    /**
     * 对象在使用之前必须调用一次,并且只能初始化一次
     */
    public void start(){
        try{
            this.producer.start();
        }catch (MQClientException e){
            e.printStackTrace();
        }
    }

    /**
     * 一般在应用上下文,使用上下文监听器,进行关闭
     */
    public void shutdown(){
        producer.shutdown();;
    }
}
