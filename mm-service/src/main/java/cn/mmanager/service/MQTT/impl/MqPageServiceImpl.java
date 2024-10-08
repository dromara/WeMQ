package cn.mmanager.service.MQTT.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.mmanager.dao.MQTT.CustomerMapper;
import cn.mmanager.dao.MQTT.MqPageMapper;
import cn.mmanager.dao.MQTT.NmqsMapper;
import cn.mmanager.framework.utils.StringUtils;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.model.pojo.NmqsToken;
import cn.mmanager.model.vo.MQPageVo;
import cn.mmanager.service.MQTT.MqPageService;
import cn.mmanager.service.MQTT.MqParamService;
import cn.mmanager.service.MQTT.NmqsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 09:09
 */
@Service
@RequiredArgsConstructor
public class MqPageServiceImpl extends ServiceImpl<MqPageMapper, MQPage> implements MqPageService {
    private final MqPageMapper mqPageMapper;
    private final MqParamService mqParamService;
    private final CustomerMapper customerMapper;
    private final NmqsMapper nmqsMapper;

    @Override
    public List<MqPageDto> select(Map<String, Object> params) {
        QueryWrapper<MQPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");

        if (params != null){
            if (params.get("id") != null){
                queryWrapper.eq("id", params.get("id"));
            }
            if (params.get("pageName") != null){
                queryWrapper.like("pageName", params.get("pageName"));
            }
            if (params.get("customerID") != null){
                queryWrapper.eq("customer_id", params.get("customerID"));
            }
            if (params.get("commonPage") != null){
                // 判断page_filename是否有值，如果为1，筛选出page_filename不为空和不为null的数据
                if (params.get("commonPage").equals(1)){
                    queryWrapper.ne("page_filename", "");
                } else {
                    queryWrapper.eq("page_filename", "");
                }
            }
        }

        List<MQPage> mqPages = mqPageMapper.selectList(queryWrapper);
        if (mqPages == null){
            return Collections.emptyList();
        }

        List<MqPageDto> mqPageDtos = new ArrayList<>();
        for (MQPage mqPage : mqPages){
            MqPageDto mqPageDto = new MqPageDto();
            BeanUtils.copyProperties(mqPage, mqPageDto);

            mqPageDto.setCustomer(customerMapper.selectById(mqPage.getCustomerId()));
            mqPageDto.setMqParams(mqParamService.selectByPageId(mqPage.getId()));
            mqPageDto.setSettings(nmqsMapper.selectById(mqPage.getNmqsTokenId()));
            mqPageDtos.add(mqPageDto);
        }

        return mqPageDtos;
    }

    @Override
    public MqPageDto selectById(Long id) {
        QueryWrapper<MQPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        MQPage mqPage = mqPageMapper.selectOne(queryWrapper);
        if (mqPage == null){
            return null;
        }

        MqPageDto mqPageDto = new MqPageDto();
        BeanUtils.copyProperties(mqPage, mqPageDto);

        mqPageDto.setCustomer(customerMapper.selectById(mqPage.getCustomerId()));
        mqPageDto.setMqParams(mqParamService.selectByPageId(id));
        mqPageDto.setSettings(nmqsMapper.selectById(mqPage.getNmqsTokenId()));

        return mqPageDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(MQPageVo mqPage) {
        MQPage mq = new MQPage();
        BeanUtils.copyProperties(mqPage, mq);

        mq.setNmqsTokenId(Long.valueOf(mqPage.getNmqsTokenId()));

        // 如果为自定义
        if (Long.parseLong(mqPage.getNmqsTokenId()) != 0) {
            return mqPageMapper.insert(mq);
        }

        NmqsToken nmqsToken = new NmqsToken();
        nmqsToken.setName(RandomUtil.randomString(12));
        nmqsToken.setToken(RandomUtil.randomString(12));
        nmqsToken.setProtocol(mqPage.getProtocol());
        nmqsToken.setMqttServer(mqPage.getMqttServer());
        nmqsToken.setMqttPort(mqPage.getMqttPort());
        nmqsToken.setMqttUsername(mqPage.getMqttUsername());
        nmqsToken.setMqttPassword(mqPage.getMqttPassword());

        int insert = nmqsMapper.insert(nmqsToken);

        if (insert > 0){
            mq.setNmqsTokenId(nmqsToken.getId());
            return mqPageMapper.insert(mq);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(MQPageVo mqPage) {
        MQPage mq = new MQPage();
        BeanUtils.copyProperties(mqPage, mq);
        // 如果为自定义
        if (Long.parseLong(mqPage.getNmqsTokenId()) != 0) {
            return mqPageMapper.updateById(mq);
        }

        NmqsToken nmqsToken = new NmqsToken();
        nmqsToken.setName(RandomUtil.randomString(12));
        nmqsToken.setToken(RandomUtil.randomString(12));
        nmqsToken.setProtocol(mqPage.getProtocol());
        nmqsToken.setMqttServer(mqPage.getMqttServer());
        nmqsToken.setMqttPort(mqPage.getMqttPort());
        nmqsToken.setMqttUsername(mqPage.getMqttUsername());
        nmqsToken.setMqttPassword(mqPage.getMqttPassword());

        int insert = nmqsMapper.insert(nmqsToken);

        if (insert > 0){
            mq.setNmqsTokenId(nmqsToken.getId());
            return mqPageMapper.updateById(mq);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return mqPageMapper.deleteById(id);
    }

    @Override
    public MqPageDto selectByURL(String url) {
        QueryWrapper<MQPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("page_url", url);
        MQPage mqPage = mqPageMapper.selectOne(queryWrapper);
        if (mqPage == null){
            return null;
        }

        MqPageDto mqPageDto = new MqPageDto();
        BeanUtils.copyProperties(mqPage, mqPageDto);

        mqPageDto.setCustomer(customerMapper.selectById(mqPage.getCustomerId()));
        mqPageDto.setMqParams(mqParamService.selectByPageId(mqPage.getId()));
        mqPageDto.setSettings(nmqsMapper.selectById(mqPage.getNmqsTokenId()));

        return mqPageDto;
    }
}
