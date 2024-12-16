package org.dromara.wemq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dromara.wemq.model.pojo.MQParam;

import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/20 14:23
 */
public interface MqParamService extends IService<MQParam> {
    MQParam selectById(Long id);

    int insert(MQParam mqParam, Long pageId);

    int delete(Long id);

    int update(MQParam param);

    List<MQParam> selectByPageId(Long id);
}
