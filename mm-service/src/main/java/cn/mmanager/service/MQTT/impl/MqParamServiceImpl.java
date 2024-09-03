package cn.mmanager.service.MQTT.impl;

import cn.mmanager.dao.MQTT.MqParamMapper;
import cn.mmanager.model.pojo.MQParam;
import cn.mmanager.service.MQTT.MqParamService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/20 14:25
 */
@Service
@RequiredArgsConstructor
public class MqParamServiceImpl extends ServiceImpl<MqParamMapper, MQParam> implements MqParamService {
    private final MqParamMapper mqParamMapper;

    @Override
    public MQParam selectById(Long id) {
        return mqParamMapper.select(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(MQParam mqParam, Long pageId) {
        mqParam.setPageId(pageId);
        return mqParamMapper.insert(mqParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long id) {
        return mqParamMapper.deleteById(id);
    }

    @Override
    public int update(MQParam param) {
        return mqParamMapper.update(param);
    }

    @Override
    public List<MQParam> selectByPageId(Long id) {
        QueryWrapper<MQParam> queryWrapper = new QueryWrapper<>();

        //通过sort字段进行排序
        queryWrapper.orderByAsc("sort");

        queryWrapper.eq("page_id", id);
        return mqParamMapper.selectList(queryWrapper);
    }
}
