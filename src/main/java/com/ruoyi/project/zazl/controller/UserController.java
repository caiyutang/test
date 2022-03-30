package com.ruoyi.project.zazl.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.SysRole;
import com.ruoyi.project.zazl.domain.User;
import com.ruoyi.project.zazl.service.IPersonInfoService;
import com.ruoyi.project.zazl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/zazl/user")
public class UserController extends BaseController {

    @Autowired
    private IPersonInfoService iPersonInfoService;
    @Autowired
    private IUserService iUserService;

    /**
     * 企业各类信息统计
     * @param map
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:user:getCompanyInfo')")
    @PostMapping("/getCompanyInfo")
    public AjaxResult getCompanyInfo(@RequestBody Map<String,Object> map) throws Exception{
        String regionId = map.get("regionId").toString();
        Map<String,Object> result = iPersonInfoService.selectCompanyInfo(regionId);
        return AjaxResult.success(result);
    }

    /**
     * 企业列表查询
     * @param user
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:user:getCompanyList')")
    @GetMapping("/getCompanyList")
    public AjaxResult getCompanyList(User user) throws Exception{
        List<SysRole> roles = getLoginUser().getUser().getRoles();
        SysRole sysRole = roles.get(0);
        if(sysRole == null){
            return AjaxResult.error("您无权限");
        }
        if("xsq_admin".equals(sysRole.getRoleKey())){
            user.setGaId(String.valueOf(getLoginUser().getDeptId()));
        }else if("pcs_admin".equals(sysRole.getRoleKey())){
            user.setDeptId(String.valueOf(getLoginUser().getDeptId()));
        }
        startPage();
        List<User> users = iUserService.selectCompanyList(user);
        TableDataInfo dataTable = getDataTable(users);
        return AjaxResult.success(dataTable);
    }

    /**
     * 企业信息查询
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:user:getCompanyDetail')")
    @GetMapping("/getCompanyDetail/{id}")
    public AjaxResult getCompanyDetail(@PathVariable("id")String id) throws Exception{
        return AjaxResult.success(iUserService.selectByPrimaryKey(id));
    }
}
