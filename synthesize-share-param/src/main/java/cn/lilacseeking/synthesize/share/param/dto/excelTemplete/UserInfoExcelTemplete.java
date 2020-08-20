package cn.lilacseeking.synthesize.share.param.dto.excelTemplete;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserInfoExcelTemplete {

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ExcelProperty(value = "用户名")
    private String password;

    /**
     * 默认用户
     */
    @ExcelProperty(value = "用户名")
    private Integer defaultUser = 0;

    /**
     * 姓名
     */
    @ExcelProperty(value = "用户名")
    private String name;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "用户名")
    private String email;

    /**
     * 手机
     */
    @ExcelProperty(value = "用户名")
    private String mobile;

    /**
     * 年龄
     */
    @ExcelProperty(value = "用户名")
    private Integer age = 0;

    /**
     * 性别
     */
    @ExcelProperty(value = "用户名")
    private Integer gender = 0;

    /**
     * 生日
     */
    @ExcelProperty(value = "用户名")
    private Date birthday;

    /**
     * 用户Id
     */
    @ExcelProperty(value = "用户名")
    private Integer userId;

    /**
     * 数据库Id
     */
    @ExcelProperty(value = "用户名")
    private Integer databaseId;

    /**
     * 记录编号
     */
    @ExcelProperty(value = "用户名")
    public Long id ;
    /**
     * 系统唯一码
     */
    @ExcelProperty(value = "用户名")
    public String guid = UUID.randomUUID().toString().replace("-","").toLowerCase();
    /**
     * 创建时间
     */
    @ExcelProperty(value = "用户名")
    public Date gmtCreate = new Date();
    /**
     * 创建人
     */
    @ExcelProperty(value = "用户名")
    public Long creater = 1L;
    /**
     * 修改时间
     */
    @ExcelProperty(value = "用户名")
    public Date gmtModify;
    /**
     * 修改人
     */
    @ExcelProperty(value = "用户名")
    public Long modifier ;
    /**
     * 删除时间
     */
    @ExcelProperty(value = "用户名")
    public Date gmtDelete ;
    /**
     * 删除人
     */
    @ExcelProperty(value = "用户名")
    public Long deleter;
    /**
     * 版本号
     */
    @ExcelProperty(value = "用户名")
    public Integer version = 0;
    /**
     * 归档
     */
    @ExcelProperty(value = "用户名")
    public Integer achieve = 0;
}
