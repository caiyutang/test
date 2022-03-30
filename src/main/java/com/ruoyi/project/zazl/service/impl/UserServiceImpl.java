package com.ruoyi.project.zazl.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.project.zazl.domain.User;
import com.ruoyi.project.zazl.mapper.UserMapper;
import com.ruoyi.project.zazl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(DataSourceType.SLAVE)
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectCompanyList(User user) {
        return userMapper.selectCompanyList(user);
    }
}
