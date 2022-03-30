package com.ruoyi.project.zazl.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.project.zazl.domain.PassResult;
import com.ruoyi.project.zazl.mapper.PassResultMapper;
import com.ruoyi.project.zazl.service.IPassResultService;
import com.ruoyi.project.zazl.service.impl.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@DataSource(DataSourceType.SLAVE)
public class PassResultServiceImpl extends BaseServiceImpl<PassResultMapper, PassResult> implements IPassResultService {

    @Autowired
    private PassResultMapper passResultMapper;

    @Override
    public List<PassResult> getList(Map<String,Object> map) throws Exception {
        return passResultMapper.getListForPager(map);
    }

    @Override
    public List<Map<String, Object>> statCompanyPassResult(Map<String, Object> map) {
        return passResultMapper.statCompanyPassResult(map);
    }
}
