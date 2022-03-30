package com.ruoyi.project.zazl.mapper;

import com.ruoyi.project.zazl.domain.PersonInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PersonInfoMapper{
    PersonInfo selectByPrimaryKey(String personId);
    void updateByPrimaryKeySelective(PersonInfo personInfo);
    List<PersonInfo> selectPersonInfos(Map<String,Object> map);
    PersonInfo selectPersonInfo(Map<String,Object> map);
    List<Map<String,Object>> selectCompanyInfo(String regionId);
    void personOutDorm(String personId);
    List<PersonInfo> selectList(PersonInfo personInfo);
}
