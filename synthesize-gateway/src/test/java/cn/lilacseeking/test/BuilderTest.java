package cn.lilacseeking.test;

import cn.lilacseeking.synthesize.gateway.pattern.creational.builder.Coach;
import cn.lilacseeking.synthesize.gateway.pattern.creational.builder.Course;
import cn.lilacseeking.synthesize.gateway.pattern.creational.builder.CourseActualBuilder;
import cn.lilacseeking.synthesize.gateway.pattern.creational.builder.CourseBuilder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 03:03
 * @Description:
 */
@Slf4j
public class BuilderTest {
    @Test
    public void getCourse(){
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("Java设计模式", "Java.pptx", "java.mp4", "java.txt", "学不会怎么办？");
        log.info("建造者模式：{}", JSON.toJSONString(course));
    }
}
