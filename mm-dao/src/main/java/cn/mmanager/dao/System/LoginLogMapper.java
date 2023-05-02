package cn.mmanager.dao.System;

import cn.mmanager.model.dto.LoginLogDto;
import cn.mmanager.model.pojo.LoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 登录日志Mapper
 * @author NicholasLD
 * @createTime 2023/4/8 15:16
 */
public interface LoginLogMapper {
    /**
     * 根据条件查询所有
     * @param params 查询条件
     * @return 查询结果
     */
    List<LoginLog> select(Map<String, Object> params);

    /**
     * 插入一条登录日志
     * @param loginLog 登录日志对象
     * @return 插入结果
     */
    int insert(LoginLog loginLog);

    /**
     * 更新登录日志
     * @param loginLog 登录日志对象
     * @return 更新结果
     */
    int update(LoginLog loginLog);

    /**
     * 根据id删除登录日志
     * @param id 登录日志id
     * @return 删除结果
     */
    int deleteById(Long id);

    List<LoginLogDto> getLoginLogList(@Param("time") String time);
}
