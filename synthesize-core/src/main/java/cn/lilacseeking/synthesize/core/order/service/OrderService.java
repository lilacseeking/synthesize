package cn.lilacseeking.synthesize.core.order.service;

import cn.lilacseeking.synthesize.core.shading.model.UserInfoPO;
import cn.lilacseeking.synthesize.infrastructure.utils.PageUtil;
import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;

import java.text.ParseException;
import java.util.List;

public interface OrderService {

    /**
     * 分页查查询所有用户
     * @param params
     * @return
     */
    PageUtil listAllUser(String params) throws ParseException;

    /**
     * 用户注册
     * @param registerDTO
     * @return
     */
    UserInfoDTO register(UserInfoDTO registerDTO);

    /**
     * 获取用户信息
     * @return
     */
    UserInfoPO getUserInfo(UserInfoDTO userDTO);

}
