package com.ruoyi.project.zazl.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.zazl.domain.Recruit;
import com.ruoyi.project.zazl.service.IRecruitService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/zazl/recruit")
public class RecruitController extends BaseController {

    @Autowired
    private IRecruitService iRecruitService;

    /**
     * 招聘列表查询
     * @param map
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:recruit:getRecruitList')")
    @PostMapping("/getRecruitList")
    public TableDataInfo getRecruitList(@RequestBody Map<String,Object> map) throws Exception{
        startPage();
        List<Recruit> list = null;
        try {
            list = iRecruitService.getList(map);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        return getDataTable(list);
    }

    /**
     * 招聘发布
     * @param recruit
     * @return
     */
    @PreAuthorize("@ss.hasPermi('zazl:recruit:recruitSubmit')")
    @PostMapping("/recruitSubmit")
    public AjaxResult recruitSubmit(@RequestBody Recruit recruit) {
        try {
            if(StringUtils.isBlank(recruit.getId())){
                SysUser user = SecurityUtils.getLoginUser().getUser();
                recruit.setId(UUID.randomUUID().toString());
                recruit.setCreateId(String.valueOf(user.getUserId()));
                recruit.setCreateUserName(user.getUserName());
                iRecruitService.save(recruit);
            }else{
                iRecruitService.update(recruit);
            }
            return AjaxResult.success("操作成功");
        } catch (Exception e) {
            logger.error("提交招聘信息异常", e);
        }
        return AjaxResult.error("操作失败");
    }

    /**
     * 招聘详情
     * @param id
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:recruit:getRecruitInfo')")
    @PostMapping("/getRecruitInfo/{id}")
    public AjaxResult getRecruitInfo(@PathVariable String id) throws Exception{
        startPage();
        Recruit byId = null;
        try {
             byId = iRecruitService.getById(id);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        return AjaxResult.success(byId);
    }
}
