package cn.lilacseeking.synthesize.core.shading.model;

import cn.lilacseeking.synthesize.core.common.BaseEntityPO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/26 07:36
 * @Description:
 */
@Table(name = "synthesize_user_info")
@Entity
@Data
public class UserInfoPO extends BaseEntityPO {

    /**
     * 用户名
     */
    @Column(name="username", nullable=false, length = 20, unique = true)
    private String username;

    /**
     * 密码
     */
    @Column(name="password", nullable=false, length = 50)
    private String password;

    /**
     * 默认用户
     */
    @Column(name="default_user")
    private Integer defaultUser = 0;

    /**
     * 姓名
     */
    @Column(name="name", length = 20)
    private String name;

    /**
     * 邮箱
     */
    @Column(name="email", nullable=false, length = 50,unique = true)
    private String email;

    /**
     * 手机
     */
    @Column(name="mobile", nullable=false, unique = true,length = 11)
    private String mobile;

    /**
     * 年龄
     */
    @Column(name="age")
    private Integer age = 0;

    /**
     * 性别
     */
    @Column(name="gender")
    private Integer gender = 0;

    /**
     * 生日
     */
    @Column(name="birthday")
    private Date birthday;

    /**
     * 密码加密盐值
     */
    @Column(name="yanzhi", nullable=false, length = 32)
    private String yanzhi = "YouAreMySunshine";
    /**
     * 用户Id
     */
    @Column(name="user_id", nullable=false)
    private Integer userId;
    /**
     * 数据库Id
     */
    @Column(name="database_id", nullable=false)
    private Integer databaseId;

}
