package cn.mmanager.service.MQTT;

import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 08:22
 */
public interface MqPageService {
    /**
     * 根据条件查询所有
     * @param params 查询条件
     * @return 查询结果
     */
    List<MQPage> select(Map<String, Object> params);

    /**
     * 根据id查询调试页面详细信息
     * @param id 调试页面id
     * @return 查询结果
     */
    MqPageDto selectById(Long id);

    /**
     * 插入调试页面
     * @param mqPage 调试页面对象
     * @return 插入结果
     */
    int insert(MQPage mqPage);

    /**
     * 更新调试页面
     * @param mqPage 调试页面对象
     * @return 更新结果
     */
    int update(MqPageDto mqPage);

    /**
     * 根据id删除调试页面
     * @param id 调试页面id
     * @return 删除结果
     */
    int deleteById(Long id);
}
