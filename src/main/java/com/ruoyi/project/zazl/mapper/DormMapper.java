package com.ruoyi.project.zazl.mapper;

import com.ruoyi.project.zazl.domain.Dorm;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DormMapper{
    Dorm selectByPrimaryKey(String id);
    void updateByPrimaryKeySelective(Dorm dorm);
    List<Dorm> getList(Map<String,Object> map);
    String getResideCount(Map<String,Object> map);
    Dorm getRoomDetail(@Param("id")String id);
}
