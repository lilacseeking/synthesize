package cn.lilacseeking.synthesize.share.param.vo.rabbitMQ;

import cn.lilacseeking.synthesize.share.param.dto.BaseEntityDTO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 19:57
 * @Description:
 */
@Data
public class UserInfoVO extends BaseEntityDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 默认用户
     */
    private Integer defaultUser = 0;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 年龄
     */
    private Integer age = 0;

    /**
     * 性别
     */
    private Integer gender = 0;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 密码加密盐值
     */
    private String yanzhi = "YouAreMySunshine";

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 数据库Id
     */
    private Integer databaseId;

}
