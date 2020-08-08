package cn.lilacseeking.test;

import cn.lilacseeking.synthesize.gateway.pattern.creational.simpleFactory.JavaVideo;
import cn.lilacseeking.synthesize.gateway.pattern.creational.simpleFactory.PythonVideo;
import cn.lilacseeking.synthesize.gateway.pattern.creational.simpleFactory.Video;
import cn.lilacseeking.synthesize.gateway.pattern.creational.simpleFactory.VideoFactory;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 00:30
 * @Description:
 */
@Slf4j
public class VideoFactoryTest {
    @Test
    public void getVideo(){
        JavaVideo javaVideo = (JavaVideo) VideoFactory.getVideo("java");
        log.info(JSONObject.toJSONString(javaVideo));
        PythonVideo pythonVideo = (PythonVideo) VideoFactory.getVideo(PythonVideo.class);
        log.info(JSONObject.toJSONString(pythonVideo));
    }
}
