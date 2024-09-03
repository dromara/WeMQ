package cn.mmanager.dao.System;

import cn.mmanager.model.dto.LoginLogDto;
import cn.mmanager.model.pojo.LoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 登录日志Mapper
 * @author NicholasLD
 * @createTime 2023/4/8 15:16
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
}
