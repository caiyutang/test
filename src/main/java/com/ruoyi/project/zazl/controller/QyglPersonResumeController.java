package com.ruoyi.project.zazl.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.zazl.domain.QyglPersonResume;
import com.ruoyi.project.zazl.service.IQyglPersonResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人员简历Controller
 *
 * @author ruoyi
 * @date 2022-03-03
 */
@RestController
@RequestMapping("/api/zazl/resume")
public class QyglPersonResumeController extends BaseController
{
    @Autowired
    private IQyglPersonResumeService qyglPersonResumeService;

    /**
     * 查询人员简历列表
     */
    @PreAuthorize("@ss.hasPermi('system:resume:list')")
    @GetMapping("/list")
    public TableDataInfo list(QyglPersonResume qyglPersonResume)
    {
        startPage();
        List<QyglPersonResume> list = qyglPersonResumeService.selectQyglPersonResumeList(qyglPersonResume);
        return getDataTable(list);
    }

    /**
     * 导出人员简历列表
     */
    @PreAuthorize("@ss.hasPermi('system:resume:export')")
    @Log(title = "人员简历", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(QyglPersonResume qyglPersonResume)
    {
        List<QyglPersonResume> list = qyglPersonResumeService.selectQyglPersonResumeList(qyglPersonResume);
        ExcelUtil<QyglPersonResume> util = new ExcelUtil<QyglPersonResume>(QyglPersonResume.class);
        return util.exportExcel(list, "人员简历数据");
    }

    /**
     * 获取人员简历详细信息
     */
    @PreAuthorize("@ss.hasPermi('zazl:resume:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qyglPersonResumeService.selectQyglPersonResumeById(id));
    }

    /**
     * 新增人员简历
     */
    @PreAuthorize("@ss.hasPermi('zazl:resume:add')")
    @Log(title = "人员简历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QyglPersonResume qyglPersonResume)
    {
        return toAjax(qyglPersonResumeService.insertQyglPersonResume(qyglPersonResume));
    }

    /**
     * 修改人员简历
     */
    @PreAuthorize("@ss.hasPermi('zazl:resume:edit')")
    @Log(title = "人员简历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QyglPersonResume qyglPersonResume)
    {
        return toAjax(qyglPersonResumeService.updateQyglPersonResume(qyglPersonResume));
    }

    /**
     * 删除人员简历
     */
    @PreAuthorize("@ss.hasPermi('system:resume:remove')")
    @Log(title = "人员简历", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(qyglPersonResumeService.deleteQyglPersonResumeByIds(ids));
    }
}
