package com.ruoyi.project.zazl.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.zazl.domain.PassResult;
import com.ruoyi.project.zazl.service.IPassResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/zazl/passResult")
public class PassResultController extends BaseController {

    @Autowired
    private IPassResultService iPassResultService;

    /**
     * 考勤结果记录查询
     * @param map
     * @return
     */
    @PreAuthorize("@ss.hasPermi('zazl:passResult:getPassResultList')")
    @PostMapping("/getPassResultList")
    public TableDataInfo getPassResultList(@RequestBody Map<String,Object> map) throws Exception{
        startPage();
        List<PassResult> list = null;
        try {
            list = iPassResultService.getList(map);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
            return getDataTable(list);
    }

    /**
     * 个人月考勤结果
     * @param map
     * @return
     */
    @PreAuthorize("@ss.hasPermi('zazl:passResult:getPersonMonth')")
    @PostMapping("/getPersonMonth")
    public AjaxResult getPersonMonth(@RequestBody Map<String,Object> map) throws Exception{
        startPage();
        List<PassResult> list = null;
        List<Map<String,Object>> result = new ArrayList<>();
        try {
            list = iPassResultService.getList(map);
            //针对正常班结算正常与否(resultType eq 1)
            List<PassResult> collect = list.stream().filter(passResult -> "1".equals(passResult.getResultType())).collect(Collectors.toList());
            //按天分组，循环计算每天的考勤状态(取status最小)
            Set<Map.Entry<Date, List<PassResult>>> entries = collect.stream().collect(Collectors.groupingBy(PassResult::getOnDutyDate, TreeMap::new, Collectors.toList())).entrySet();
            for (Map.Entry<Date, List<PassResult>> entry : entries) {
                Map<String,Object> rs = new HashMap<>();
                rs.put("date", DateUtils.parseDateToStr("yyyy-MM-dd",entry.getKey()));
                OptionalInt min = entry.getValue().stream().mapToInt(i -> Integer.parseInt(i.getStatus())).min();
                rs.put("status", min.getAsInt());
                result.add(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("查询失败");
        }
        return AjaxResult.success(result);
    }

    /**
     * 公司考勤详情
     * @param map
     * @return
     */
    @PreAuthorize("@ss.hasPermi('zazl:passResult:getCompanyPassResult')")
    @PostMapping("/getCompanyPassResult")
    public AjaxResult getCompanyPassResult(@RequestBody Map<String,Object> map) throws Exception{
        if(map.get("date") == null && map.get("month") == null){
            throw new Exception("日、月查询至少选择一种");
        }
        startPage();
        List<Map<String,Object>> list = null;
        try {
            String startTime = DateUtils.getDate();
            String endTime = DateUtils.getDate();
            //根据传入的查询类型设定数据库查询的范围
            if(map.get("date") != null){
                startTime = map.get("date").toString();
                endTime = DateUtils.parseDateToStr("yyyy-MM-dd",DateUtils.addDays(DateUtils.parseDate(map.get("date").toString(),"yyyy-MM-dd"),1));
            }else if(map.get("month") != null){
                startTime = DateUtils.parseDateToStr("yyyy-MM-dd",DateUtils.parseDate(map.get("month").toString(),"yyyy-MM"));
                endTime = DateUtils.parseDateToStr("yyyy-MM-dd",DateUtils.addMonths(DateUtils.parseDate(map.get("month").toString(),"yyyy-MM"),1));
            }
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            list = iPassResultService.statCompanyPassResult(map);
        } catch (Exception e) {
            throw new Exception("查询失败");
        }
        return AjaxResult.success(list);
    }
}
