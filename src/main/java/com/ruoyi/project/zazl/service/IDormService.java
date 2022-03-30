package com.ruoyi.project.zazl.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.zazl.domain.Dorm;

import java.util.List;
import java.util.Map;

public interface IDormService {
    List<Dorm> getList(Map<String,Object> map) throws Exception;
    String getResideCount(Map<String,Object> map);
    AjaxResult personReside(Map<String,Object> map) throws Exception;
    AjaxResult personOutDorm(Map<String,Object> map) throws Exception;
}
