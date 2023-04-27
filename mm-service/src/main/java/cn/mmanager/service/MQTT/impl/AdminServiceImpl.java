package cn.mmanager.service.MQTT.impl;

import cn.hutool.crypto.digest.BCrypt;
import cn.mmanager.dao.System.AdminMapper;
import cn.mmanager.model.pojo.Admin;
import cn.mmanager.service.MQTT.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/27 19:21
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private AdminMapper adminMapper;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Admin> getAdminListByMap(Map<String, Object> params) {
        return adminMapper.getAdminListByMap(params);
    }

    @Override
    public Integer getAdminCountByMap(Map<String, Object> params) {
        return adminMapper.getAdminCountByMap(params);
    }

    @Override
    public int insertAdmin(Admin admin) {
        String password = admin.getPassword();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        admin.setPassword(hashPassword);
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public int updateAdminById(Admin admin) {
        String password = admin.getPassword();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        admin.setPassword(hashPassword);
        return adminMapper.updateAdminById(admin);
    }

    @Override
    public int deleteAdminById(Long id) {
        return adminMapper.deleteAdminById(id);
    }

    @Override
    public Admin getAdminByMap(Map<String, Object> params) {
        return adminMapper.getAdminByMap(params);
    }

    @Override
    public boolean checkPassword(String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }
}
