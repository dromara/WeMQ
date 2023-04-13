package cn.mmanager.service.MQTT.impl;

import cn.mmanager.dao.MQTT.MqPageMapper;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.service.MQTT.MqPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 09:09
 */
@Service("mqPageService")
public class MqPageServiceImpl implements MqPageService {
    private MqPageMapper mqPageMapper;
    @Autowired
    public void setMqPageMapper(MqPageMapper mqPageMapper) {
        this.mqPageMapper = mqPageMapper;
    }

    @Override
    public List<MQPage> select(Map<String, Object> params) {
        return null;
    }

    @Override
    public MqPageDto selectById(Long id) {
        return mqPageMapper.selectById(id);
    }

    @Override
    public int insert(MQPage mqPage) {
        return 0;
    }

    @Override
    public int update(MQPage mqPage) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }
}
