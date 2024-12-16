package org.dromara.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.dromara.mapper.AdminMapper;
import org.dromara.model.pojo.Admin;
import org.dromara.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/27 19:21
 */
@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    private final AdminMapper adminMapper;

    @Override
    public List<Admin> getAdminListByMap(Map<String, Object> params) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();

        if (params == null) {
            params = new HashMap<>();
        }

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            queryWrapper.eq(entry.getKey(), entry.getValue());
        }
        return adminMapper.selectList(queryWrapper);
    }

    @Override
    public Integer getAdminCountByMap(Map<String, Object> params) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();

        if (params == null) {
            params = new HashMap<>();
        }

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            queryWrapper.eq(entry.getKey(), entry.getValue());
        }
        return Math.toIntExact(adminMapper.selectCount(queryWrapper));
    }

    @Override
    public int insertAdmin(Admin admin) {
        String password = admin.getPassword();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        admin.setPassword(hashPassword);
        return adminMapper.insert(admin);
    }

    @Override
    public int updateAdminById(Admin admin) {
        String password = admin.getPassword();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        admin.setPassword(hashPassword);
        return adminMapper.updateById(admin);
    }

    @Override
    public int deleteAdminById(Long id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public Admin getAdminByMap(Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }

        return adminMapper.selectOne(new QueryWrapper<Admin>().allEq(params));
    }

    @Override
    public boolean checkPassword(String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }
}
