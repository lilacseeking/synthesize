package cn.lilacseeking.synthesize.api.user;

import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;
import cn.lilacseeking.synthesize.share.param.vo.rabbitMQ.UserInfoVO;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/28 21:15
 * @Description:
 */
public interface IUserService {

    UserInfoDTO saveUserInfo(UserInfoDTO userInfoDTO);
}
