package cn.mmanager.service.MQTT.impl;

import cn.hutool.core.util.StrUtil;
import cn.mmanager.dao.MQTT.MqPageMapper;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.service.MQTT.MqPageService;
import cn.mmanager.service.MQTT.MqParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 09:09
 */
@Service("mqPageService")
public class MqPageServiceImpl implements MqPageService {
    private MqPageMapper mqPageMapper;
    private MqParamService mqParamService;
    @Autowired
    public void setMqPageMapper(MqPageMapper mqPageMapper) {
        this.mqPageMapper = mqPageMapper;
    }

    @Autowired
    public void setMqParamService(MqParamService mqParamService) {
        this.mqParamService = mqParamService;
    }

    @Override
    public List<MQPage> select(Map<String, Object> params) {
        if (params.get("commonPage") == null || (Integer) params.get("commonPage") == 0){
            return mqPageMapper.select(params);
        }
        return mqPageMapper.select(params).stream().filter(mqPage -> !StrUtil.isEmpty(mqPage.getPageFileName())).collect(Collectors.toList());
    }

    @Override
    public MqPageDto selectById(Long id) {
        return mqPageMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(MQPage mqPage) {
        if (mqPageMapper.insert(mqPage) <= 0){
            return 0;
        }
        return mqPageMapper.insertPage_Customer(mqPage.getId(), mqPage.getCustomer().getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(MqPageDto mqPage) {
        if (mqPageMapper.updatePage_Customer(mqPage.getId(), mqPage.getCustomer().getId()) <= 0){
            if (mqPageMapper.insertPage_Customer(mqPage.getId(), mqPage.getCustomer().getId()) <= 0){
                return 0;
            }
            return mqPageMapper.update(mqPage);
        }
        return mqPageMapper.update(mqPage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id) {
        if (mqPageMapper.deletePage_Customer(id) <= 0){
            return 0;
        }
        return mqPageMapper.deleteById(id);
    }
}
