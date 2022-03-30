package com.ruoyi.project.zazl.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.zazl.domain.Dorm;
import com.ruoyi.project.zazl.service.IDormService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/zazl/dorm")
public class DormController extends BaseController {

    @Autowired
    private IDormService iDormService;

    /**
     * 宿舍列表查询
     * @param map
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:dorm:getDormList')")
    @PostMapping("/getDormList")
    public TableDataInfo getDormList(@RequestBody Map<String,Object> map) throws Exception{
        startPage();
        List<Dorm> list = null;
        try {
            list = iDormService.getList(map);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        TableDataInfo dataTable = getDataTable(list);
        Map<String,Object> resideSearchMap = new HashMap<>();
        resideSearchMap.put("regionId",map.get("regionId"));
        String msg = iDormService.getResideCount(resideSearchMap    );
        dataTable.setMsg(StringUtils.isNotBlank(msg)?msg:"0");
        return dataTable;
    }

    /**
     * 员工入住/换房
     * @param map
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:dorm:personReside')")
    @PostMapping("/personReside")
    public AjaxResult personReside(@RequestBody Map<String,Object> map) throws Exception{
        AjaxResult ar = new AjaxResult();
        try {
            ar = iDormService.personReside(map);
        } catch (Exception e) {
            throw new Exception("操作失败");
        }
        return ar;
    }

    /**
     * 员工离房
     * @param map
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('zazl:dorm:personOutDorm')")
    @PostMapping("/personOutDorm")
    public AjaxResult personOutDorm(@RequestBody Map<String,Object> map) throws Exception{
        AjaxResult ar = new AjaxResult();
        try {
            ar = iDormService.personOutDorm(map);
        } catch (Exception e) {
            throw new Exception("操作失败");
        }
        return ar;
    }

}
