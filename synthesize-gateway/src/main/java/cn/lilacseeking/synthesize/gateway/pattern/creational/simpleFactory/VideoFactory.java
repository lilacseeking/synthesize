package cn.lilacseeking.synthesize.gateway.pattern.creational.simpleFactory;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/29 00:27
 * @Description:
 */
public class VideoFactory {

    public static Video getVideo(String type) {
        if (StringUtils.equals(type, "java")) {
            return new JavaVideo();
        } else if (StringUtils.equals(type, "python")) {
            return new PythonVideo();
        } else {
            return null;
        }
    }

    public static Video getVideo(Class classes) {
        try {
            return (Video) Class.forName(classes.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
