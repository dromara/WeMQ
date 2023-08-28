package cn.mmanager.service.MQTT.impl;

import cn.mmanager.dao.MQTT.MqParamMapper;
import cn.mmanager.model.pojo.MQParam;
import cn.mmanager.service.MQTT.MqParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/20 14:25
 */
@Service("mqParamService")
public class MqParamServiceImpl implements MqParamService {
    private MqParamMapper mqParamMapper;

    @Autowired
    public void setMqParamMapper(MqParamMapper mqParamMapper) {
        this.mqParamMapper = mqParamMapper;
    }

    @Override
    public MQParam selectById(Long id) {
        return mqParamMapper.select(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(MQParam mqParam, Long pageId) {
        if (mqParamMapper.add(mqParam) <= 0)
            return 0;
        if (mqParamMapper.insertPage_Param(pageId, mqParam.getId()) <= 0)
            return 0;
        return mqParamMapper.add(mqParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long id) {
        if (mqParamMapper.deletePage_Param(id) <= 0)
            return 0;
        return mqParamMapper.deleteById(id);
    }

    @Override
    public int update(MQParam param) {
        return mqParamMapper.update(param);
    }
}
