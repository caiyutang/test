package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.QyglHouseholdDomicileMapper;
import com.ruoyi.project.system.domain.QyglHouseholdDomicile;
import com.ruoyi.project.system.service.IQyglHouseholdDomicileService;

/**
 * 无户口人员登记Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
@Service
public class QyglHouseholdDomicileServiceImpl implements IQyglHouseholdDomicileService 
{
    @Autowired
    private QyglHouseholdDomicileMapper qyglHouseholdDomicileMapper;

    /**
     * 查询无户口人员登记
     * 
     * @param id 无户口人员登记主键
     * @return 无户口人员登记
     */
    @Override
    public QyglHouseholdDomicile selectQyglHouseholdDomicileById(Long id)
    {
        return qyglHouseholdDomicileMapper.selectQyglHouseholdDomicileById(id);
    }

    /**
     * 查询无户口人员登记列表
     * 
     * @param qyglHouseholdDomicile 无户口人员登记
     * @return 无户口人员登记
     */
    @Override
    public List<QyglHouseholdDomicile> selectQyglHouseholdDomicileList(QyglHouseholdDomicile qyglHouseholdDomicile)
    {
        return qyglHouseholdDomicileMapper.selectQyglHouseholdDomicileList(qyglHouseholdDomicile);
    }

    /**
     * 新增无户口人员登记
     * 
     * @param qyglHouseholdDomicile 无户口人员登记
     * @return 结果
     */
    @Override
    public int insertQyglHouseholdDomicile(QyglHouseholdDomicile qyglHouseholdDomicile)
    {
        qyglHouseholdDomicile.setCreateTime(DateUtils.getNowDate());
        return qyglHouseholdDomicileMapper.insertQyglHouseholdDomicile(qyglHouseholdDomicile);
    }

    /**
     * 修改无户口人员登记
     * 
     * @param qyglHouseholdDomicile 无户口人员登记
     * @return 结果
     */
    @Override
    public int updateQyglHouseholdDomicile(QyglHouseholdDomicile qyglHouseholdDomicile)
    {
        return qyglHouseholdDomicileMapper.updateQyglHouseholdDomicile(qyglHouseholdDomicile);
    }

    /**
     * 批量删除无户口人员登记
     * 
     * @param ids 需要删除的无户口人员登记主键
     * @return 结果
     */
    @Override
    public int deleteQyglHouseholdDomicileByIds(Long[] ids)
    {
        return qyglHouseholdDomicileMapper.deleteQyglHouseholdDomicileByIds(ids);
    }

    /**
     * 删除无户口人员登记信息
     * 
     * @param id 无户口人员登记主键
     * @return 结果
     */
    @Override
    public int deleteQyglHouseholdDomicileById(Long id)
    {
        return qyglHouseholdDomicileMapper.deleteQyglHouseholdDomicileById(id);
    }
}
