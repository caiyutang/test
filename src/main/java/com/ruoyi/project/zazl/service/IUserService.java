package com.ruoyi.project.zazl.service;

import com.ruoyi.project.zazl.domain.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    User selectByPrimaryKey(String id);
    List<User> selectCompanyList(User user);
}
