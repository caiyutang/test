package com.ruoyi.project.zazl.mapper;

import com.ruoyi.project.zazl.domain.QyglPersonResume;

import java.util.List;

/**
 * 人员简历Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-03
 */
public interface QyglPersonResumeMapper
{
    /**
     * 查询人员简历
     *
     * @param id 人员简历主键
     * @return 人员简历
     */
    public QyglPersonResume selectQyglPersonResumeById(String id);

    /**
     * 查询人员简历列表
     *
     * @param qyglPersonResume 人员简历
     * @return 人员简历集合
     */
    public List<QyglPersonResume> selectQyglPersonResumeList(QyglPersonResume qyglPersonResume);

    /**
     * 新增人员简历
     *
     * @param qyglPersonResume 人员简历
     * @return 结果
     */
    public int insertQyglPersonResume(QyglPersonResume qyglPersonResume);

    /**
     * 修改人员简历
     *
     * @param qyglPersonResume 人员简历
     * @return 结果
     */
    public int updateQyglPersonResume(QyglPersonResume qyglPersonResume);

    /**
     * 删除人员简历
     *
     * @param id 人员简历主键
     * @return 结果
     */
    public int deleteQyglPersonResumeById(String id);

    /**
     * 批量删除人员简历
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQyglPersonResumeByIds(String[] ids);
}
