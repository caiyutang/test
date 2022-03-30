package com.ruoyi.project.zazl.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.zazl.domain.Dorm;
import com.ruoyi.project.zazl.domain.PersonInfo;
import com.ruoyi.project.zazl.mapper.DormMapper;
import com.ruoyi.project.zazl.mapper.PersonInfoMapper;
import com.ruoyi.project.zazl.service.IPersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@DataSource(DataSourceType.SLAVE)
public class    PersonInfoServiceImpl implements IPersonInfoService {

    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public List<PersonInfo> selectPersonInfosByPhoneNo(String phoneNo) {
        Map<String,Object> map = new HashMap<>();
        map.put("phoneNo",phoneNo);
        return personInfoMapper.selectPersonInfos(map);
    }

    @Override
    public Map<String, Object> selectCompanyInfo(String regionId) {
        List<Map<String,Object>> list = personInfoMapper.selectCompanyInfo(regionId);
        Map<String, Object> collect = new HashMap<>();
        if(list != null && list.size()>0){
            collect = list.stream().collect(Collectors.toMap(s -> s.get("TYPE").toString(), s -> s.get("COUNT").toString()));
        }
        return collect;
    }

    @Override
    public List<PersonInfo> selectPersonInfos(Map<String, Object> map) {
        return personInfoMapper.selectPersonInfos(map);
    }

    @Override
    public List<PersonInfo> selectList(PersonInfo personInfo) {
        return personInfoMapper.selectList(personInfo);
    }

    @Override
    public PersonInfo selectByPrimaryKey(String personId) {
        return personInfoMapper.selectByPrimaryKey(personId);
    }
}
