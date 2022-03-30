package com.ruoyi.project.zazl.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.project.zazl.domain.QyglPersonResume;
import com.ruoyi.project.zazl.mapper.QyglPersonResumeMapper;
import com.ruoyi.project.zazl.service.IQyglPersonResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员简历Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-03
 */
@Service
@DataSource(DataSourceType.SLAVE)
public class QyglPersonResumeServiceImpl implements IQyglPersonResumeService
{
    @Autowired
    private QyglPersonResumeMapper qyglPersonResumeMapper;

    /**
     * 查询人员简历
     *
     * @param id 人员手机号
     * @return 人员简历
     */
    @Override
    public QyglPersonResume selectQyglPersonResumeById(String id)
    {
        QyglPersonResume search = new QyglPersonResume();
        search.setPhoneNo(id);
        List<QyglPersonResume> qyglPersonResumes = qyglPersonResumeMapper.selectQyglPersonResumeList(search);
        return qyglPersonResumes!=null&&qyglPersonResumes.size()>0?qyglPersonResumes.get(0):null;
    }

    /**
     * 查询人员简历列表
     *
     * @param qyglPersonResume 人员简历
     * @return 人员简历
     */
    @Override
    public List<QyglPersonResume> selectQyglPersonResumeList(QyglPersonResume qyglPersonResume)
    {
        return qyglPersonResumeMapper.selectQyglPersonResumeList(qyglPersonResume);
    }

    /**
     * 新增人员简历
     *
     * @param qyglPersonResume 人员简历
     * @return 结果
     */
    @Override
    public int insertQyglPersonResume(QyglPersonResume qyglPersonResume)
    {
        if(StringUtils.isBlank(qyglPersonResume.getPhoneNo()))throw new ServiceException("手机号不能为空");
        QyglPersonResume search = new QyglPersonResume();
        search.setPhoneNo(qyglPersonResume.getPhoneNo());
        List<QyglPersonResume> qyglPersonResumes = qyglPersonResumeMapper.selectQyglPersonResumeList(search);
        if(qyglPersonResumes != null && qyglPersonResumes.size() >0)throw new ServiceException("简历已存在,请勿重复添加");
        return qyglPersonResumeMapper.insertQyglPersonResume(qyglPersonResume);
    }

    /**
     * 修改人员简历
     *
     * @param qyglPersonResume 人员简历
     * @return 结果
     */
    @Override
    public int updateQyglPersonResume(QyglPersonResume qyglPersonResume)
    {
        return qyglPersonResumeMapper.updateQyglPersonResume(qyglPersonResume);
    }

    /**
     * 批量删除人员简历
     *
     * @param ids 需要删除的人员简历主键
     * @return 结果
     */
    @Override
    public int deleteQyglPersonResumeByIds(String[] ids)
    {
        return qyglPersonResumeMapper.deleteQyglPersonResumeByIds(ids);
    }

    /**
     * 删除人员简历信息
     *
     * @param id 人员简历主键
     * @return 结果
     */
    @Override
    public int deleteQyglPersonResumeById(String id)
    {
        return qyglPersonResumeMapper.deleteQyglPersonResumeById(id);
    }
}
