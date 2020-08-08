package cn.lilacseeking.synthesize.gateway.pattern.creational.builder;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 02:51
 * @Description:
 */
public abstract class CourseBuilder {

    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();
}
