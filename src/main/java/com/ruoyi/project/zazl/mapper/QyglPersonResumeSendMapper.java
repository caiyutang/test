package com.ruoyi.project.zazl.mapper;

import com.ruoyi.project.zazl.domain.QyglPersonResumeSend;

import java.util.List;

/**
 * 推送给企业的简历Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-03
 */
public interface QyglPersonResumeSendMapper
{
    /**
     * 查询推送给企业的简历
     *
     * @param id 推送给企业的简历主键
     * @return 推送给企业的简历
     */
    public QyglPersonResumeSend selectQyglPersonResumeSendById(String id);

    /**
     * 查询推送给企业的简历列表
     *
     * @param qyglPersonResumeSend 推送给企业的简历
     * @return 推送给企业的简历集合
     */
    public List<QyglPersonResumeSend> selectQyglPersonResumeSendList(QyglPersonResumeSend qyglPersonResumeSend);

    /**
     * 新增推送给企业的简历
     *
     * @param qyglPersonResumeSend 推送给企业的简历
     * @return 结果
     */
    public int insertQyglPersonResumeSend(QyglPersonResumeSend qyglPersonResumeSend);

    /**
     * 修改推送给企业的简历
     *
     * @param qyglPersonResumeSend 推送给企业的简历
     * @return 结果
     */
    public int updateQyglPersonResumeSend(QyglPersonResumeSend qyglPersonResumeSend);

    /**
     * 删除推送给企业的简历
     *
     * @param id 推送给企业的简历主键
     * @return 结果
     */
    public int deleteQyglPersonResumeSendById(String id);

    /**
     * 批量删除推送给企业的简历
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQyglPersonResumeSendByIds(String[] ids);
}
