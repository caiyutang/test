package com.ruoyi.project.zazl.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.zazl.domain.PassResult;
import com.ruoyi.project.zazl.domain.PersonInfo;
import com.ruoyi.project.zazl.service.IPersonInfoService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/zazl/personInfo")
public class PersonInfoController extends BaseController {

    @Autowired
    private IPersonInfoService iPersonInfoService;

    /**
     * 用户列表查询
     * @param map
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:personInfo:getPersonInfoList')")
    @PostMapping("/getPersonInfoList")
    public TableDataInfo getPersonInfoList(@RequestBody Map<String,Object> map) throws Exception{
        startPage();
        List<PersonInfo> list = null;
        try {
            list = iPersonInfoService.selectPersonInfos(map);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        return getDataTable(list);
    }

    /**
     * 用户列表查询
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:personInfo:getPersonInfoList')")
    @GetMapping("/selectList")
    public AjaxResult selectList(PersonInfo personInfo) throws Exception{
        startPage();
        List<PersonInfo> list = null;
        try {
            list = iPersonInfoService.selectList(personInfo);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        return AjaxResult.success(getDataTable(list));
    }

    /**
     * 人员信息查询
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:personInfo:getPersonInfo')")
    @GetMapping("/getPersonInfo/{id}")
    public AjaxResult getCompanyDetail(@PathVariable("id")String id) throws Exception{
        return AjaxResult.success(iPersonInfoService.selectByPrimaryKey(id));
    }
}
