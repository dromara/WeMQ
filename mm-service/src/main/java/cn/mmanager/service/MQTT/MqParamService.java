package cn.mmanager.service.MQTT;

import cn.mmanager.model.pojo.MQParam;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/20 14:23
 */
public interface MqParamService {
    MQParam selectById(Long id);

    int insert(MQParam mqParam, Long pageId);

    int delete(Long id);

    int update(MQParam param);
}
