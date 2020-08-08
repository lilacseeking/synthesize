package cn.lilacseeking.synthesize.gateway.pattern.creational.builder;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 02:58
 * @Description:
 */
public class Coach {
CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }
    public Course makeCourse(String courseName, String coursePPT, String courseVideo, String courseArticle, String courseQA){
        this.courseBuilder.buildCourseArticle(courseArticle);
        this.courseBuilder.buildCourseName(courseName);
        this.courseBuilder.buildCoursePPT(coursePPT);
        this.courseBuilder.buildCourseVideo(courseVideo);
        this.courseBuilder.buildCourseQA(courseQA);
        return this.courseBuilder.makeCourse();
    }
}
