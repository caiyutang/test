package com.ruoyi.project.zazl.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.zazl.domain.Dorm;
import com.ruoyi.project.zazl.domain.PersonInfo;
import com.ruoyi.project.zazl.mapper.DormMapper;
import com.ruoyi.project.zazl.mapper.PersonInfoMapper;
import com.ruoyi.project.zazl.service.IDormService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@DataSource(DataSourceType.SLAVE)
public class DormServiceImpl implements IDormService {

    @Autowired
    private DormMapper dormMapper;
    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public List<Dorm> getList(Map<String, Object> map) throws Exception {
        return dormMapper.getList(map);
    }

    @Override
    public String getResideCount(Map<String, Object> map) {
        return dormMapper.getResideCount(map);
    }

    @Override
    @Transactional
    public AjaxResult personReside(Map<String, Object> map) throws Exception {
        if(map.get("phoneNo") == null || map.get("dormId") == null || map.get("regionId") == null){
            return AjaxResult.error("手机号、房间编号、企业区域编号不能为空");
        }
        PersonInfo personInfo = personInfoMapper.selectPersonInfo(map);
        Dorm dorm = dormMapper.selectByPrimaryKey(map.get("dormId").toString());
        if(personInfo == null || !map.get("regionId").toString().equals(personInfo.getSrcParentIndex())){
           return AjaxResult.error("本企业无可操作的员工");
        }
        if(dorm == null){
            return AjaxResult.error("宿舍不存在");
        }
        String oldRoomId = personInfo.getTempAddress();
        personInfo.setTempAddress(dorm.getId());
        personInfo.setTempAddressName(dorm.getRoomNameUpdate());
        personInfoMapper.updateByPrimaryKeySelective(personInfo);
        //更新原先宿舍的基本信息
        if(StringUtils.isNotBlank(oldRoomId)){
            Dorm oldDormDetail = dormMapper.getRoomDetail(oldRoomId);
            if(oldDormDetail != null){
                dormMapper.updateByPrimaryKeySelective(oldDormDetail);
            }
        }
        //更新新入住宿舍的基本信息
        Dorm dormDetail = dormMapper.getRoomDetail(dorm.getId());
        dormMapper.updateByPrimaryKeySelective(dormDetail);
        return AjaxResult.success("操作成功");
    }

    @Override
    @Transactional
    public AjaxResult personOutDorm(Map<String, Object> map) throws Exception {
        PersonInfo personInfo = personInfoMapper.selectByPrimaryKey(map.get("personId").toString());
        //人员移出宿舍
        personInfoMapper.personOutDorm(personInfo.getPersonId());
        //更新宿舍基本信息
        Dorm dormDetail = dormMapper.getRoomDetail(personInfo.getTempAddress());
        dormMapper.updateByPrimaryKeySelective(dormDetail);
        return AjaxResult.success("操作成功");
    }
}
