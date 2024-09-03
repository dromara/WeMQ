package cn.mmanager.service.MQTT.impl;

import cn.mmanager.dao.MQTT.MqPageMapper;
import cn.mmanager.dao.MQTT.NmqsMapper;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.model.pojo.NmqsToken;
import cn.mmanager.service.MQTT.MqPageService;
import cn.mmanager.service.MQTT.NmqsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 14:36
 */
@Service
@RequiredArgsConstructor
public class NmqsServiceImpl extends ServiceImpl<NmqsMapper, NmqsToken> implements NmqsService {
    private final NmqsMapper nmqsMapper;
    private final MqPageMapper mqPageMapper;

    @Override
    public List<NmqsToken> select(Map<String, Object> params) {
        return nmqsMapper.select(params);
    }

    @Override
    public NmqsToken selectById(Long id) {
        return nmqsMapper.selectById(id);
    }

    @Override
    public int insert(NmqsToken nmqsToken) {
        return nmqsMapper.insert(nmqsToken);
    }

    @Override
    public int update(NmqsToken nmqsToken) {
        return nmqsMapper.update(nmqsToken);
    }

    @Override
    public int deleteById(Long id) {
        //查询id下的token是否有页面正在使用
        QueryWrapper<MQPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nmqs_id", id);
        List<MQPage> mqPages = mqPageMapper.selectList(queryWrapper);
        if (!mqPages.isEmpty()) {
            return -1;
        }
        return nmqsMapper.deleteById(id);
    }
}
