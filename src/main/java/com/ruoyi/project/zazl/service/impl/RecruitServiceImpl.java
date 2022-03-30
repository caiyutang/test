package com.ruoyi.project.zazl.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.project.zazl.domain.Recruit;
import com.ruoyi.project.zazl.mapper.RecruitMapper;
import com.ruoyi.project.zazl.service.IRecruitService;
import com.ruoyi.project.zazl.service.impl.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@DataSource(DataSourceType.SLAVE)
public class RecruitServiceImpl extends BaseServiceImpl<RecruitMapper, Recruit> implements IRecruitService {

    @Override
    public void save(Recruit recruit) throws Exception {
        mapper.insertSelective(recruit);
    }

    @Override
    public void update(Recruit recruit) throws Exception {
        mapper.updateByPrimaryKeySelective(recruit);
    }

    @Override
    public Recruit getById(String id) throws Exception {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(String id) throws Exception {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Recruit> getList(Map<String, Object> map) throws Exception {
        return mapper.getListForPager(map);
    }
}
