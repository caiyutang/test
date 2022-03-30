package com.ruoyi.project.zazl.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.zazl.domain.PersonInfo;
import org.aspectj.weaver.loadtime.Aj;

import java.util.List;
import java.util.Map;

public interface IPersonInfoService {
    List<PersonInfo> selectPersonInfosByPhoneNo(String phoneNo);
    Map<String,Object> selectCompanyInfo(String regionId);
    List<PersonInfo> selectPersonInfos(Map<String,Object> map);
    List<PersonInfo> selectList(PersonInfo personInfo);
    PersonInfo selectByPrimaryKey(String personId);
}
