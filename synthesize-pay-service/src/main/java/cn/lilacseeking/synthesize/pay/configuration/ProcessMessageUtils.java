package cn.lilacseeking.synthesize.pay.configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/16 01:41
 * @Description:
 */
@Slf4j
@Component
public class ProcessMessageUtils {

    private static final ThreadLocal<LinkedHashMap<String, Object>> TL_MESSAGE_MAP = new ThreadLocal<LinkedHashMap<String, Object>>();
    private static final ThreadLocal<TreeMap<String, Object>> TL_CONTENT_MAP = new ThreadLocal<TreeMap<String, Object>>();
    private String defalutSuccess;
    private String defalutException;

    @PostConstruct
    public void initDefault() {
        this.defalutSuccess = "success";
        this.defalutException = "error";
    }

    public void put(int code, String messg, Object content) {
        try {
            LinkedHashMap<String, Object> resultMap = getMessageMap();
            resultMap.put("code", code);
            resultMap.put("msg", messg);
            resultMap.put("content", content);
        } catch (Throwable th) {
            log.warn("异常信息为: ", th);
        }
    }

    private LinkedHashMap<String, Object> getMessageMap() {
        LinkedHashMap<String, Object> lhm = TL_MESSAGE_MAP.get();
        if (null == lhm) {
            lhm = new LinkedHashMap<>();
            TL_MESSAGE_MAP.set(lhm);
        }
        return lhm;
    }

    private TreeMap<String, Object> getContentMap() {

        TreeMap<String, Object> ss = TL_CONTENT_MAP.get();
        if (ss == null) {
            ss = new TreeMap<>();
            TL_CONTENT_MAP.set(ss);
        }
        return ss;
    }

    public void putSuccess() {
        Object content = "";
        TreeMap<String, Object> treeMap = getContentMap();
        if (null != treeMap && treeMap.size() > 0) {
            content = treeMap;
        }
        put(0, defalutSuccess, content);
    }

    public void putSuccess(Object content) {
        put(0, defalutSuccess, content);
    }

    public void putSuccess(String msg, Object content) {
        put(0, msg, content);
    }

    public void putError() {
        Object content = "";
        TreeMap<String, Object> treeMap = getContentMap();
        if (null != treeMap && treeMap.size() > 0) {
            content = treeMap;
        }
        put(1, defalutException, content);
    }

    public void putError(Object content) {
        put(1, defalutException, content);
    }

    public void putError(String msg, Object content) {
        putError(1, msg, content);
    }

    public void putErrorStr(String errorCode, String errorMsg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errorCode",errorCode);
        jsonObject.put("errorMsg",errorMsg);
        putError(1, errorCode, jsonObject);
    }

    public void putError(int code, String msg, Object content) {
        put(code, msg, content);
    }

    public Object getJSON() {
        LinkedHashMap<String, Object> resultMap = getMessageMap();
        return (null != resultMap && resultMap.size() > 0) ? JSON.toJSON(resultMap) : null;
    }

    public void writeMessage(HttpServletResponse response) {
        writeMessage(response, false);
    }

    public void writeMessage() {
        HttpServletResponse res = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        writeMessage(res);
    }

    public String getMessage(SerializerFeature... features) {
        LinkedHashMap<String, Object> resultMap = getMessageMap();
        return (null != resultMap && resultMap.size() > 0) ? JSON.toJSONString(resultMap, features) : null;
    }

    public void writeMessage(HttpServletResponse response, boolean isWriteJsonObject ) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            // 设置ContentType
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            // 避免乱码
            response.setCharacterEncoding("UTF-8");
            //客户端不用CACHE
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            //输出到客户端
            pw.print( isWriteJsonObject? getJSON() : getMessage(SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(pw);
            //清理本线程的THREADLOCAL变量
            TL_CONTENT_MAP.remove();
            TL_MESSAGE_MAP.remove();
        }
    }

}
