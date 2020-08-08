package cn.lilacseeking.synthesize.gateway.pattern.creational.builder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 02:49
 * @Description:
 */
@Data
@Slf4j
public class Course {

    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA;

}
