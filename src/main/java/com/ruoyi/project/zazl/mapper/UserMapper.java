package com.ruoyi.project.zazl.mapper;

import com.ruoyi.project.zazl.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User selectByPrimaryKey(String id);
    List<User> selectCompanyList(User user);
}
