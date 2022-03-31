package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.QyglHouseholdDomicile;

/**
 * 无户口人员登记接口
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public interface IQyglHouseholdDomicileService 
{
    /**
     * 查询无户口人员登记数据
     * 
     * @param id 无户口人员登记主键
     * @return 无户口人员登记
     */
    public QyglHouseholdDomicile selectQyglHouseholdDomicileById(Long id);

    /**
     * 查询无户口人员登记列表
     * 
     * @param qyglHouseholdDomicile 无户口人员登记
     * @return 无户口人员登记集合
     */
    public List<QyglHouseholdDomicile> selectQyglHouseholdDomicileList(QyglHouseholdDomicile qyglHouseholdDomicile);

    /**
     * 新增无户口人员登记
     * 
     * @param qyglHouseholdDomicile 无户口人员登记
     * @return 结果
     */
    public int insertQyglHouseholdDomicile(QyglHouseholdDomicile qyglHouseholdDomicile);

    /**
     * 修改无户口人员登记
     * 
     * @param qyglHouseholdDomicile 无户口人员登记
     * @return 结果
     */
    public int updateQyglHouseholdDomicile(QyglHouseholdDomicile qyglHouseholdDomicile);

    /**
     * 批量删除无户口人员登记
     * 
     * @param ids 需要删除的无户口人员登记主键集合
     * @return 结果
     */
    public int deleteQyglHouseholdDomicileByIds(Long[] ids);

    /**
     * 删除无户口人员登记信息
     * 
     * @param id 无户口人员登记主键
     * @return 结果
     */
    public int deleteQyglHouseholdDomicileById(Long id);
}
