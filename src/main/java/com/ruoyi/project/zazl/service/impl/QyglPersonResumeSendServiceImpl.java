package com.ruoyi.project.zazl.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sign.GenerateCodeUtil;
import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.project.zazl.domain.QyglPersonResume;
import com.ruoyi.project.zazl.domain.QyglPersonResumeSend;
import com.ruoyi.project.zazl.domain.Recruit;
import com.ruoyi.project.zazl.mapper.QyglPersonResumeMapper;
import com.ruoyi.project.zazl.mapper.QyglPersonResumeSendMapper;
import com.ruoyi.project.zazl.mapper.RecruitMapper;
import com.ruoyi.project.zazl.service.IQyglPersonResumeSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 推送给企业的简历Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-03
 */
@Service
@DataSource(DataSourceType.SLAVE)
public class QyglPersonResumeSendServiceImpl implements IQyglPersonResumeSendService
{
    @Autowired
    private QyglPersonResumeSendMapper qyglPersonResumeSendMapper;
    @Autowired
    private QyglPersonResumeMapper qyglPersonResumeMapper;
    @Autowired
    private RecruitMapper recruitMapper;
    /**
     * 查询推送给企业的简历
     *
     * @param id 推送给企业的简历主键
     * @return 推送给企业的简历
     */
    @Override
    public QyglPersonResumeSend selectQyglPersonResumeSendById(String id)
    {
        return qyglPersonResumeSendMapper.selectQyglPersonResumeSendById(id);
    }

    /**
     * 查询推送给企业的简历列表
     *
     * @param qyglPersonResumeSend 推送给企业的简历
     * @return 推送给企业的简历
     */
    @Override
    public List<QyglPersonResumeSend> selectQyglPersonResumeSendList(QyglPersonResumeSend qyglPersonResumeSend)
    {
        return qyglPersonResumeSendMapper.selectQyglPersonResumeSendList(qyglPersonResumeSend);
    }

    /**
     * 新增推送给企业的简历
     *
     * @param qyglPersonResumeSend 推送给企业的简历
     * @return 结果
     */
    @Override
    public int insertQyglPersonResumeSend(QyglPersonResumeSend qyglPersonResumeSend)
    {
        if(StringUtils.isBlank(qyglPersonResumeSend.getPhoneNo()))throw new ServiceException("手机号不能为空");

        QyglPersonResume search = new QyglPersonResume();
        search.setPhoneNo(qyglPersonResumeSend.getPhoneNo());
        List<QyglPersonResume> qyglPersonResumes = qyglPersonResumeMapper.selectQyglPersonResumeList(search);
        if(qyglPersonResumes == null || qyglPersonResumes.size() == 0)throw new ServiceException("简历不存在，请先完善个人简历");

        Recruit recruit = null;
        try {
            recruit = recruitMapper.selectByPrimaryKey(qyglPersonResumeSend.getRegionId());//前端传错了，regionId传成了id，自行后台查一下招聘信息了4
            if(recruit == null)throw new ServiceException("招聘信息不存在");

        } catch (Exception e) {
            throw new ServiceException("获取招聘信息失败");
        }

        QyglPersonResumeSend searchSend = new QyglPersonResumeSend();
        searchSend.setCreateDate_start(DateUtil.format(new Date(),"yyyy-MM-dd 00:00:00"));
        searchSend.setRegionId(recruit.getRegionId());
        searchSend.setPhoneNo(qyglPersonResumeSend.getPhoneNo());
        List<QyglPersonResumeSend> qyglPersonResumeSends = qyglPersonResumeSendMapper.selectQyglPersonResumeSendList(searchSend);
        if(qyglPersonResumeSends != null &&  qyglPersonResumeSends.size()>0)throw new ServiceException("今天已经给该企业投过简历，请勿频繁投递");


        BeanUtil.copyProperties(qyglPersonResumes.get(0),qyglPersonResumeSend);
        qyglPersonResumeSend.setReadStatus("0");
        qyglPersonResumeSend.setId(GenerateCodeUtil.getUUIDString());
        qyglPersonResumeSend.setRegionId(recruit.getRegionId());
        return qyglPersonResumeSendMapper.insertQyglPersonResumeSend(qyglPersonResumeSend);
    }

    /**
     * 修改推送给企业的简历
     *
     * @param qyglPersonResumeSend 推送给企业的简历
     * @return 结果
     */
    @Override
    public int updateQyglPersonResumeSend(QyglPersonResumeSend qyglPersonResumeSend)
    {
        return qyglPersonResumeSendMapper.updateQyglPersonResumeSend(qyglPersonResumeSend);
    }

    /**
     * 批量删除推送给企业的简历
     *
     * @param ids 需要删除的推送给企业的简历主键
     * @return 结果
     */
    @Override
    public int deleteQyglPersonResumeSendByIds(String[] ids)
    {
        return qyglPersonResumeSendMapper.deleteQyglPersonResumeSendByIds(ids);
    }

    /**
     * 删除推送给企业的简历信息
     *
     * @param id 推送给企业的简历主键
     * @return 结果
     */
    @Override
    public int deleteQyglPersonResumeSendById(String id)
    {
        return qyglPersonResumeSendMapper.deleteQyglPersonResumeSendById(id);
    }
}
