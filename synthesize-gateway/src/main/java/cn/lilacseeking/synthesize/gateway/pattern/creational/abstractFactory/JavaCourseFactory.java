package cn.lilacseeking.synthesize.gateway.pattern.creational.abstractFactory;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 02:20
 * @Description:
 */
public class JavaCourseFactory  implements CourseFactory{

    @Override
    public Video getVideo(){
        return new JavaVideo();
    }

    @Override
    public Article getArticle(){
        return new JavaArticle();
    }


}
