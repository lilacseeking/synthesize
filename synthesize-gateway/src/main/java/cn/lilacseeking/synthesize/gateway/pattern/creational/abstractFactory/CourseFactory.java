package cn.lilacseeking.synthesize.gateway.pattern.creational.abstractFactory;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 02:18
 * @Description:
 */
public interface CourseFactory {

    Video getVideo();

    Article getArticle();
}
