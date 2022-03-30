package com.ruoyi.project.zazl.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.zazl.domain.Inform;
import com.ruoyi.project.zazl.domain.PassResult;
import com.ruoyi.project.zazl.service.IInformService;
import org.apache.poi.ss.usermodel.DateUtil;
import org.aspectj.weaver.AjAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/zazl/inform")
public class InformController extends BaseController {

    @Autowired
    private IInformService iInformService;

    /**
     * 通知通告查询
     * @param map
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:inform:getInformList')")
    @PostMapping("/getInformList")
    public TableDataInfo getInformList(@RequestBody Map<String,Object> map) throws Exception{
        startPage();
        List<Inform> list = null;
        try {
            SysUser user = SecurityUtils.getLoginUser().getUser();
            map.put("phoneNo",user.getUserName());
            list = iInformService.getList(map);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        return getDataTable(list);
    }

    /**
     * 获取通知通告详情
     * @param id
     * @return
     */
    @PreAuthorize("@ss.hasPermi('zazl:inform:getInformInfo')")
    @GetMapping("/getInformInfo/{id}")
    public AjaxResult getInformInfo(@PathVariable String id) {
        return AjaxResult.success(iInformService.selectByPrimaryKey(id));
    }

    /**
     * 通知通告发布
     * @param inform
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:inform:informSubmit')")
    @PostMapping("/informSubmit")
    public AjaxResult informSubmit(@RequestBody Inform inform) throws Exception{
        try {
            SysUser user = SecurityUtils.getLoginUser().getUser();
            inform.setCreater(user.getUserName());inform.setCreateTime(DateUtils.getNowDate());
            inform.setModifier(user.getUserName());inform.setModifyTime(inform.getCreateTime());inform.setStatus("发布");
            inform.setRemark("微信通知");inform.setSource("微信通知");
            iInformService.insertSelective(inform);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        return AjaxResult.success("操作成功");
    }
}
