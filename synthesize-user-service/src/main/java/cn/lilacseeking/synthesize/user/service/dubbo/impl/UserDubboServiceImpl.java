package cn.lilacseeking.synthesize.user.service.dubbo.impl;

import cn.lilacseeking.synthesize.api.user.IUserService;
import cn.lilacseeking.synthesize.core.shading.service.UserInfoService;
import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/28 21:19
 * @Description:
 */
@Service
public class UserDubboServiceImpl implements IUserService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserInfoDTO saveUserInfo(UserInfoDTO userInfoDTO) {
        return userInfoService.register(userInfoDTO);
    }
}
