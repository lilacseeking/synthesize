package cn.lilacseeking.test;

import cn.lilacseeking.synthesize.gateway.pattern.creational.protoType.Mail;
import cn.lilacseeking.synthesize.gateway.pattern.creational.protoType.MailUtil;
import org.junit.Test;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 03:44
 * @Description:
 */
public class ProtoTypeTest {
    @Test
    public void sendMail(){
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        for (int i = 0;i<10;i++){
            mail.setName("姓名"+i);
            mail.setEmailAddress("地址"+i);
            mail.setContent("内容"+i);
            MailUtil.saveMailContent();
        }
    }
}
