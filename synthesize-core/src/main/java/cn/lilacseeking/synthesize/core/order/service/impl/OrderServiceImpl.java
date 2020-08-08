package cn.lilacseeking.synthesize.core.order.service.impl;

import cn.lilacseeking.synthesize.core.shading.model.UserInfoPO;
import cn.lilacseeking.synthesize.core.shading.service.UserInfoService;
import cn.lilacseeking.synthesize.infrastructure.utils.BeanCopyUtil;
import cn.lilacseeking.synthesize.infrastructure.utils.MD5Util;
import cn.lilacseeking.synthesize.infrastructure.utils.PageUtil;
import cn.lilacseeking.synthesize.infrastructure.utils.StringUtil;
import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;
import cn.lilacseeking.synthesize.share.param.enums.ErrorCodeEumn;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.text.ParseException;
import java.util.Date;
import cn.lilacseeking.synthesize.core.shading.repository.UserInfoRepository;



@Service
public class OrderServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository UserInfoRepository;


    /**
     * 分页查查询所有用户
     * @param params
     * @return
     * @throws ParseException
     */
    @Override
    public PageUtil listAllUser(String params) throws ParseException {
        JSONObject value = JSONObject.parseObject(params).getJSONObject("params");
        int rows = Integer.valueOf(value.getString("rows"));
        int page = Integer.valueOf(value.getString("page"));
        String filter = value.getString("optionParam");
        PageUtil page1 = new PageUtil();
        page1.setCurrentPage(page);
        page1.setRows(rows);
        return UserInfoRepository.list(page1, filter);
    }

    /**
     * 用户注册
     * @param userInfoDTO
     * @return
     */
    @Override
    public UserInfoDTO register(UserInfoDTO userInfoDTO){
        Date birthdayDate = userInfoDTO.getBirthday();
        int age = StringUtil.getAge(birthdayDate);
        UserInfoPO userPO = new UserInfoPO();
        BeanCopyUtil.copyPropertiesIgnoreNull(userInfoDTO,userPO);
        //密码加密
        userPO.setPassword(MD5Util.MD5(userPO.getPassword()));
        userPO.setAge(age);
        userPO.setYanzhi(StringUtil.getRandomString(12));
        userPO.setBirthday(birthdayDate);
//        密码加密
//        持久化数据
        UserInfoPO result = UserInfoRepository.saveOrUpdate(userPO);
        UserInfoDTO userBasicInfoDTO = new UserInfoDTO();
        BeanCopyUtil.copyPropertiesIgnoreNull(result,userBasicInfoDTO);
        return userBasicInfoDTO;
    }


    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public UserInfoPO getUserInfo(UserInfoDTO userDTO) {
        Assert.isTrue(null != userDTO.getId(), ErrorCodeEumn.USER_ID_NOT_NULL.getName());
        return UserInfoRepository.getUserInfo(userDTO);
    }

}
