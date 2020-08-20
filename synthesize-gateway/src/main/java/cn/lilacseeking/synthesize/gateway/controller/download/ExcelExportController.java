package cn.lilacseeking.synthesize.gateway.controller.download;

import cn.lilacseeking.synthesize.gateway.configration.ProcessMessageUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "excelExport")
public class ExcelExportController {

    @Autowired
    private ProcessMessageUtils messageUtils;

    @RequestMapping(value = "exportUserInfo",method = RequestMethod.POST)
    public void exportUserInfo(@RequestBody JSONObject params, HttpServletResponse response){
        // 通用数据生成

        // 写入Excel

        // 上传oss

    }
}
