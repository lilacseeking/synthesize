package cn.lilacseeking.synthesize.core.order.repository;

import cn.lilacseeking.synthesize.core.common.AbstractRepository;
import cn.lilacseeking.synthesize.core.shading.model.QUserInfoPO;
import cn.lilacseeking.synthesize.core.shading.model.UserInfoPO;
import cn.lilacseeking.synthesize.infrastructure.utils.PageUtil;
import cn.lilacseeking.synthesize.share.param.dto.rabbitDTO.UserInfoDTO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class OrderRepository extends AbstractRepository<UserInfoPO> {

    QUserInfoPO qUserInfoPO = QUserInfoPO.userInfoPO;
    /**
     * 保存或更新
     * @return
     */
    @Transactional
    public UserInfoPO saveOrUpdate(UserInfoPO UserInfoPO){
        return entityManager.merge(UserInfoPO);
    }

    /**
     * 分页查询
     * @param PageUtil
     * @return
     */
    public PageUtil list(PageUtil PageUtil, String filter) throws ParseException {
//        // 参数组装
        JSONObject value = JSONObject.parseObject(filter);
        String name = value.getString("name");
        String email = value.getString("email");
        String mobile = value.getString("mobile");
        String username = value.getString("username");
        Date birthday = StringUtils.isBlank(value.getString("birthday"))?null:new SimpleDateFormat("yyyy-MM-dd").parse(value.getString("birthday"));
        JSONArray gmtCreateList = value.getJSONArray("gmtCreateList");
        Integer gender =  StringUtils.isBlank(value.getString("gender"))?null:Integer.valueOf(value.getString("gender"));
        Integer age =  StringUtils.isBlank(value.getString("age"))?null:Integer.valueOf(value.getString("age"));
        Integer achieve =  StringUtils.isBlank(value.getString("achieve"))?null:Integer.valueOf(value.getString("achieve"));
        JPAQueryBase query = new JPAQuery<>(entityManager).from(qUserInfoPO);
        query.where(qUserInfoPO.achieve.eq(0));
        // 姓名查询
        if (!StringUtils.isBlank(name)){
            query.where(qUserInfoPO.name.like("%" + name + "%"));
        }
        // 手机号查询
        if (!StringUtils.isBlank(mobile)){
            query.where(qUserInfoPO.mobile.eq(mobile));
        }
        // 邮箱查询
        if (!StringUtils.isBlank(email)){
            query.where(qUserInfoPO.email.eq(email));
        }
        // 用户名
        if (!StringUtils.isBlank(username)){
            query.where(qUserInfoPO.username.like("%" + username + "%"));
        }
        // 出生日期
        if (birthday !=null){
            query.where(qUserInfoPO.birthday.eq(birthday));
        }
        // 创建日期
        if (null != gmtCreateList && gmtCreateList.size()>0){
            query.where(qUserInfoPO.gmtCreate.in(new SimpleDateFormat("yyyy-MM-dd").parse(gmtCreateList.get(0).toString())
                    ,new SimpleDateFormat("yyyy-MM-dd").parse(gmtCreateList.get(1).toString())));
        }
        // 性别查询
        if (gender != null){
            query.where(qUserInfoPO.gender.eq(gender));
        }
        // 年龄查询
        if (age != null){
            query.where(qUserInfoPO.age.eq(age));
        }
        // 归档查询
        if (achieve != null){
            query.where(qUserInfoPO.achieve.eq(achieve));
        }
        int count = (int)query.fetchCount();//总记录数
        query.limit(PageUtil.getRows());//每页记录数
        query.offset(PageUtil.getRows() * (PageUtil.getCurrentPage() - 1));//偏移量
        query.orderBy(qUserInfoPO.id.desc());
        List<UserInfoPO> userPOList = query.fetch();
        //组装返回参数
        PageUtil.setCount(count);
        PageUtil.setResultList(userPOList);
        return PageUtil;
    }

    /**
     * 删除用户单个用户，数据库不保留数据
     * @return
     */
    @Transactional
    public Integer delete(UserInfoPO UserInfoPO){
        UserInfoPO userPODelete = entityManager.find(UserInfoPO.class, UserInfoPO);
        entityManager.remove(userPODelete);
        return 1;
    }

    /**
     * 封存用户
     * @param UserInfoPO
     * @return
     */
    public Integer achieve(UserInfoPO UserInfoPO){
        return null;
    }

    /**
     * 根据手机号或用户名或邮箱获取用户信息
     * @param param
     * @return
     */
    public UserInfoPO getUserByMobileOrEmailOrUsername(String param){
        JPAQueryBase query = new JPAQuery(entityManager).from(qUserInfoPO);
        query.where(qUserInfoPO.achieve.eq(0));
        // 根据手机号获取用户信息
        if (match("0?(13|14|15|18|17)[0-9]{9}",param)){
            query.where(qUserInfoPO.mobile.eq(param));
        }
        // 根据邮箱获取用户信息
        else if (match("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}",param)){
            query.where(qUserInfoPO.email.eq(param));
        } else {
            query.where(qUserInfoPO.username.eq(param));
        }
        UserInfoPO UserInfoPO = (UserInfoPO)query.fetchFirst();
        return UserInfoPO;
    }

    /**
     * 正则匹配
     * @param regex
     * @param str
     * @return
     */
    private boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 获取用户信息
     * @param userInfoDTO
     * @return
     */
    public UserInfoPO getUserInfo(UserInfoDTO userInfoDTO){
        JPAQuery query = new JPAQuery<>(entityManager).from(qUserInfoPO);
        query.where(qUserInfoPO.id.eq(userInfoDTO.getId()));
        query.where(qUserInfoPO.achieve.eq(0));
        return (UserInfoPO)query.fetchFirst();
    }
}
