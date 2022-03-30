package com.ruoyi.project.zazl.service;

import com.ruoyi.project.zazl.domain.QyglPersonResumeSend;

import java.util.List;

/**
 * 推送给企业的简历Service接口
 *
 * @author ruoyi
 * @date 2022-03-03
 */
public interface IQyglPersonResumeSendService
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
     * 批量删除推送给企业的简历
     *
     * @param ids 需要删除的推送给企业的简历主键集合
     * @return 结果
     */
    public int deleteQyglPersonResumeSendByIds(String[] ids);

    /**
     * 删除推送给企业的简历信息
     *
     * @param id 推送给企业的简历主键
     * @return 结果
     */
    public int deleteQyglPersonResumeSendById(String id);
}
