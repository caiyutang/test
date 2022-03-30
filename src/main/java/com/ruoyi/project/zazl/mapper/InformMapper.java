package com.ruoyi.project.zazl.mapper;

import com.ruoyi.project.zazl.domain.Inform;

import java.util.List;
import java.util.Map;

public interface InformMapper {
    Inform selectByPrimaryKey(String id);
    void insertSelective(Inform inform);
    List<Inform> getList(Map<String,Object> map);
}
