package cn.mmanager.service.MQTT.impl;

import cn.mmanager.dao.MQTT.NmqsMapper;
import cn.mmanager.model.pojo.NmqsToken;
import cn.mmanager.service.MQTT.NmqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 14:36
 */
@Service("nmqsService")
public class NmqsServiceImpl implements NmqsService {
    private NmqsMapper nmqsMapper;
    @Autowired
    public void setNmqsMapper(NmqsMapper nmqsMapper) {
        this.nmqsMapper = nmqsMapper;
    }

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
        return nmqsMapper.deleteById(id);
    }

    @Override
    public NmqsToken getInfoByToken(String token) {
        return nmqsMapper.getInfoByToken(token);
    }
}
