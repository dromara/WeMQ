package org.dromara.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.model.pojo.NmqsToken;

import java.util.List;
import java.util.Map;

/**
 * NmqsMapper
 * @author NicholasLD
 * @createTime 2023/4/13 14:18
 */
@Mapper
public interface NmqsMapper extends BaseMapper<NmqsToken> {
    /**
     * 查询所有的Nmqs
     * @return 查询结果
     */
    List<NmqsToken> select(Map<String, Object> params);

    /**
     * 根据id查询NmqsToken详细信息
     * @param id NmqsToken id
     * @return 查询结果
     */
    NmqsToken selectById(Long id);

    /**
     * 更新NmqsToken
     * @param nmqsToken NmqsToken对象
     * @return 更新结果
     */
    int update(NmqsToken nmqsToken);

    /**
     * 根据id删除NmqsToken
     * @param id NmqsToken id
     * @return 删除结果
     */
    int deleteById(Long id);

    NmqsToken getInfoByToken(String token);
}
