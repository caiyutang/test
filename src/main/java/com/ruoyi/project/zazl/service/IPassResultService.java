package com.ruoyi.project.zazl.service;

import com.ruoyi.project.zazl.domain.PassResult;
import com.ruoyi.project.zazl.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface IPassResultService extends BaseService<PassResult> {
    List<PassResult> getList(Map<String,Object> map) throws Exception;
    List<Map<String,Object>> statCompanyPassResult(Map<String,Object> map);
}
