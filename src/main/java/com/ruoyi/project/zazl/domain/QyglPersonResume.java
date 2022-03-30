package com.ruoyi.project.zazl.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 人员简历对象 qygl_person_resume
 *
 * @author ruoyi
 * @date 2022-03-03
 */
public class QyglPersonResume extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String personId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String personName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNo;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthday;

    /** 现居地 */
    @Excel(name = "现居地")
    private String village;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 专业 */
    @Excel(name = "专业")
    private String majorKill;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String marryType;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String outlookType;

    /** 身高 */
    @Excel(name = "身高")
    private String height;

    /** 体重 */
    @Excel(name = "体重")
    private String weight;

    /** 期望薪资 */
    @Excel(name = "期望薪资")
    private String salary;

    /** 自我介绍 */
    @Excel(name = "自我介绍")
    private String introduce;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setPersonId(String personId)
    {
        this.personId = personId;
    }

    public String getPersonId()
    {
        return personId;
    }
    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getPersonName()
    {
        return personName;
    }
    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }
    public void setVillage(String village)
    {
        this.village = village;
    }

    public String getVillage()
    {
        return village;
    }
    public void setEducation(String education)
    {
        this.education = education;
    }

    public String getEducation()
    {
        return education;
    }
    public void setMajorKill(String majorKill)
    {
        this.majorKill = majorKill;
    }

    public String getMajorKill()
    {
        return majorKill;
    }
    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public String getNation()
    {
        return nation;
    }
    public void setMarryType(String marryType)
    {
        this.marryType = marryType;
    }

    public String getMarryType()
    {
        return marryType;
    }
    public void setOutlookType(String outlookType)
    {
        this.outlookType = outlookType;
    }

    public String getOutlookType()
    {
        return outlookType;
    }
    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getHeight()
    {
        return height;
    }
    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getWeight()
    {
        return weight;
    }
    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public String getSalary()
    {
        return salary;
    }
    public void setIntroduce(String introduce)
    {
        this.introduce = introduce;
    }

    public String getIntroduce()
    {
        return introduce;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("personId", getPersonId())
            .append("personName", getPersonName())
            .append("phoneNo", getPhoneNo())
            .append("email", getEmail())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("village", getVillage())
            .append("education", getEducation())
            .append("majorKill", getMajorKill())
            .append("nation", getNation())
            .append("marryType", getMarryType())
            .append("outlookType", getOutlookType())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("salary", getSalary())
            .append("introduce", getIntroduce())
            .toString();
    }
}
