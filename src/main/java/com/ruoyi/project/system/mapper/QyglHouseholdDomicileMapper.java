package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.QyglHouseholdDomicile;

/**
 * 无户口人员登记Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public interface QyglHouseholdDomicileMapper 
{
    /**
     * 查询无户口人员登记
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
     * 删除无户口人员登记
     * 
     * @param id 无户口人员登记主键
     * @return 结果
     */
    public int deleteQyglHouseholdDomicileById(Long id);

    /**
     * 批量删除无户口人员登记
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQyglHouseholdDomicileByIds(Long[] ids);
}
