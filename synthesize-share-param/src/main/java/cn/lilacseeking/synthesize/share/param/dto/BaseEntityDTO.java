package cn.lilacseeking.synthesize.share.param.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/17 19:59
 * @Description:
 */
@Data
public class BaseEntityDTO implements Serializable {

    private static final long serialVersionUID = 2424179903340800612L;
    /**
     * 记录编号
     */
    public Long id ;
    /**
     * 系统唯一码
     */
    public String guid = UUID.randomUUID().toString().replace("-","").toLowerCase();
    /**
     * 创建时间
     */
    public Date gmtCreate = new Date();
    /**
     * 创建人
     */
    public Long creater = 1L;
    /**
     * 修改时间
     */
    public Date gmtModify;
    /**
     * 修改人
     */
    public Long modifier ;
    /**
     * 删除时间
     */
    public Date gmtDelete ;
    /**
     * 删除人
     */
    public Long deleter;
    /**
     * 版本号
     */
    public Integer version = 0;
    /**
     * 归档
     */
    public Integer achieve = 0;

}
