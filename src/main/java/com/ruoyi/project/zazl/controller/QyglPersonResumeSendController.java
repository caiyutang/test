package com.ruoyi.project.zazl.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.zazl.domain.QyglPersonResumeSend;
import com.ruoyi.project.zazl.service.IQyglPersonResumeSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 推送给企业的简历Controller
 *
 * @author ruoyi
 * @date 2022-03-03
 */
@RestController
@RequestMapping("/zazl/send")
public class QyglPersonResumeSendController extends BaseController
{
    @Autowired
    private IQyglPersonResumeSendService qyglPersonResumeSendService;

    /**
     * 查询推送给企业的简历列表
     */
    @PreAuthorize("@ss.hasPermi('system:send:list')")
    @GetMapping("/list")
    public TableDataInfo list(QyglPersonResumeSend qyglPersonResumeSend)
    {
        startPage();
        List<QyglPersonResumeSend> list = qyglPersonResumeSendService.selectQyglPersonResumeSendList(qyglPersonResumeSend);
        return getDataTable(list);
    }

    /**
     * 导出推送给企业的简历列表
     */
    @PreAuthorize("@ss.hasPermi('system:send:export')")
    @Log(title = "推送给企业的简历", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(QyglPersonResumeSend qyglPersonResumeSend)
    {
        List<QyglPersonResumeSend> list = qyglPersonResumeSendService.selectQyglPersonResumeSendList(qyglPersonResumeSend);
        ExcelUtil<QyglPersonResumeSend> util = new ExcelUtil<QyglPersonResumeSend>(QyglPersonResumeSend.class);
        return util.exportExcel(list, "推送给企业的简历数据");
    }

    /**
     * 获取推送给企业的简历详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:send:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qyglPersonResumeSendService.selectQyglPersonResumeSendById(id));
    }

    /**
     * 新增推送给企业的简历
     */
    @PreAuthorize("@ss.hasPermi('zazl:send:add')")
    @Log(title = "推送给企业的简历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QyglPersonResumeSend qyglPersonResumeSend)
    {
        return toAjax(qyglPersonResumeSendService.insertQyglPersonResumeSend(qyglPersonResumeSend));
    }

    /**
     * 修改推送给企业的简历
     */
    @PreAuthorize("@ss.hasPermi('system:send:edit')")
    @Log(title = "推送给企业的简历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QyglPersonResumeSend qyglPersonResumeSend)
    {
        return toAjax(qyglPersonResumeSendService.updateQyglPersonResumeSend(qyglPersonResumeSend));
    }

    /**
     * 删除推送给企业的简历
     */
    @PreAuthorize("@ss.hasPermi('system:send:remove')")
    @Log(title = "推送给企业的简历", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(qyglPersonResumeSendService.deleteQyglPersonResumeSendByIds(ids));
    }
}
