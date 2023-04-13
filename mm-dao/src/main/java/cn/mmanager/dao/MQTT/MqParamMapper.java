package cn.mmanager.dao.MQTT;

import cn.mmanager.model.pojo.MQParam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 调试参数Mapper
 * @author 梁晓惠、袁祎阳、纪雨佳
 * @createTime 2023/4/8 15:16
 */
@Repository("mqParamMapper")
public interface MqParamMapper {
    /**
     * 添加
     * @param mqParam 参数实体类
     * @return 返回值
     */
    int add(MQParam mqParam);

    /**
     * 通过id修改
     * @param mqParam 参数实体类
     * @return 返回值
     */
    int update(MQParam mqParam);
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 查询
     * @param id 参数id
     * @return 返回值
     */
    List<MQParam> select (Long id);

}
