package cn.mmanager.service.MQTT;

import cn.mmanager.model.pojo.NmqsToken;

import java.util.List;
import java.util.Map;

/**
 * NMQS服务接口
 * @author NicholasLD
 * @createTime 2023/4/13 14:35
 */
public interface NmqsService {
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
     * 插入NmqsToken
     * @param nmqsToken NmqsToken对象
     * @return 插入结果
     */
    int insert(NmqsToken nmqsToken);

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
}
