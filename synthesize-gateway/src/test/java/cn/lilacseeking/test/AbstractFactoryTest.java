package cn.lilacseeking.test;

import cn.lilacseeking.synthesize.gateway.pattern.creational.abstractFactory.Article;
import cn.lilacseeking.synthesize.gateway.pattern.creational.abstractFactory.CourseFactory;
import cn.lilacseeking.synthesize.gateway.pattern.creational.abstractFactory.JavaCourseFactory;
import cn.lilacseeking.synthesize.gateway.pattern.creational.abstractFactory.Video;
import org.junit.Test;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 02:32
 * @Description:
 */
public class AbstractFactoryTest {
    @Test
    public void getAbstractFactory(){
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        video.process();
        Article article = courseFactory.getArticle();
        article.process();
    }
}
