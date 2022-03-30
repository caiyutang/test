package com.ruoyi.project.zazl.service;

import com.ruoyi.project.zazl.domain.Inform;

import java.util.List;
import java.util.Map;

public interface IInformService {
    List<Inform> getList(Map<String,Object> map) throws Exception;
    Inform selectByPrimaryKey(String id);
    void insertSelective(Inform inform);
}
