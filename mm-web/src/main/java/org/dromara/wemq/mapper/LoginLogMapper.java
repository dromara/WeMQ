package org.dromara.wemq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.wemq.model.pojo.LoginLog;

/**
 * 登录日志Mapper
 * @author NicholasLD
 * @createTime 2023/4/8 15:16
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
}
