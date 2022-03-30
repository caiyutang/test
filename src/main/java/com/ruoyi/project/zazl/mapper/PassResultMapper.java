package com.ruoyi.project.zazl.mapper;

import com.ruoyi.project.zazl.domain.PassResult;

import java.util.List;
import java.util.Map;

public interface PassResultMapper extends BaseMapper<PassResult> {
    List<Map<String,Object>> statCompanyPassResult(Map<String,Object> map);
}
