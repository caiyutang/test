package com.ruoyi.project.zazl.service;

import com.ruoyi.project.zazl.domain.Recruit;
import com.ruoyi.project.zazl.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface IRecruitService extends BaseService<Recruit> {
    List<Recruit> getList(Map<String,Object> map) throws Exception;
}
