package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 无户口人员登记对象 qygl_household_domicile
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public class QyglHouseholdDomicile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 登记记录ID111111111 主键 */
    private Long id;

    /** 登录人手机号 */
    @Excel(name = "登录人手机号")
    private String loginPhone;

    /** 微信OpenId */
    @Excel(name = "微信OpenId")
    private String openId;

    /** 无户口人员姓名 */
    @Excel(name = "无户口人员姓名")
    private String personName;

    /** 无户口人员出生日期 */
    @Excel(name = "无户口人员出生日期")
    private String personDate;

    /** 无户口人员详细地址 */
    @Excel(name = "无户口人员详细地址")
    private String personAddress;

    /** 无户口登记类型 */
    @Excel(name = "无户口登记类型")
    private String registerType;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String contactName;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactPhone;

    /** 备注说明 */
    @Excel(name = "备注说明")
    private String remarks;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLoginPhone(String loginPhone) 
    {
        this.loginPhone = loginPhone;
    }

    public String getLoginPhone() 
    {
        return loginPhone;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setPersonName(String personName) 
    {
        this.personName = personName;
    }

    public String getPersonName() 
    {
        return personName;
    }
    public void setPersonDate(String personDate) 
    {
        this.personDate = personDate;
    }

    public String getPersonDate() 
    {
        return personDate;
    }
    public void setPersonAddress(String personAddress) 
    {
        this.personAddress = personAddress;
    }

    public String getPersonAddress() 
    {
        return personAddress;
    }
    public void setRegisterType(String registerType) 
    {
        this.registerType = registerType;
    }

    public String getRegisterType() 
    {
        return registerType;
    }
    public void setContactName(String contactName) 
    {
        this.contactName = contactName;
    }

    public String getContactName() 
    {
        return contactName;
    }
    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("loginPhone", getLoginPhone())
            .append("openId", getOpenId())
            .append("personName", getPersonName())
            .append("personDate", getPersonDate())
            .append("personAddress", getPersonAddress())
            .append("registerType", getRegisterType())
            .append("contactName", getContactName())
            .append("contactPhone", getContactPhone())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .toString();
    }
}
