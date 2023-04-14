package cn.mmanager.dao.System;


import cn.mmanager.model.pojo.Admin;

import java.util.List;
import java.util.Map;

/**
 * @author RR
 * @since 2023/4/8 15:49
 */
public interface AdminMapper {
    /**
     * 分页查询
     * @param params 参数条件
     * @return 返回查询到的结果
     */
    List<Admin> getAdminListByMap(Map<String,Object> params);

    /**
     * 根据条件获取数据信息的数量
     * @param params 条件集合
     * @return 返回查询到数据的数量
     */
    Integer getAdminCountByMap(Map<String,Object> params);

    /**
     * 增加管理员
     * @param admin 管理员对象
     * @return 返回受影响的行数
     */
    int insertAdmin(Admin admin);

    /**
     * 根据id修改管理员信息
     * @param admin 要修改的管理员数据
     * @return 返回受影响的行数
     */
    int updateAdminById(Admin admin);

    /**
     * 根据id删除对应的管理员信息
     * @param id 条件id
     * @return 返回受影响的行数
     */
    int deleteAdminById(Long id);
}
