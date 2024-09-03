package cn.mmanager.dao.System;


import cn.mmanager.model.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author RR
 * @since 2023/4/8 15:49
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
