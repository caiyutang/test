package com.ruoyi.project.zazl.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.project.zazl.domain.Inform;
import com.ruoyi.project.zazl.mapper.InformMapper;
import com.ruoyi.project.zazl.service.IInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@DataSource(DataSourceType.SLAVE)
public class InformServiceImpl implements IInformService {

    @Autowired
    private InformMapper informMapper;

    @Override
    public Inform selectByPrimaryKey(String id) {
        return informMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Inform inform) {
        informMapper.insertSelective(inform);
    }

    @Override
    public List<Inform> getList(Map<String, Object> map) throws Exception {
        return informMapper.getList(map);
    }
}
