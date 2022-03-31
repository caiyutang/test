package com.ruoyi.project.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.project.system.service.ISysDictDataService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.QyglHouseholdDomicile;
import com.ruoyi.project.system.service.IQyglHouseholdDomicileService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 无户口人员登记Controller测试
 * 开始测试
 * @author ruoyi
 * @date 2022-03-22
 */
@RestController
@RequestMapping("/system/domicile")
public class QyglHouseholdDomicileController extends BaseController
{
    @Autowired
    private IQyglHouseholdDomicileService qyglHouseholdDomicileService;
    @Autowired
    private ISysDictDataService dictDataService;
    /**
     * 查询无户口人员登记列表
     */
    @PreAuthorize("@ss.hasPermi('system:domicile:list')")
    @GetMapping("/list")
    public TableDataInfo list(QyglHouseholdDomicile qyglHouseholdDomicile)
    {
        startPage();
        List<QyglHouseholdDomicile> list = qyglHouseholdDomicileService.selectQyglHouseholdDomicileList(qyglHouseholdDomicile);
        return getDataTable(list);
    }

    /**
     * 获取无户口登记类型
     * @param dictData
     * @return
     */
    @GetMapping("/registerType")
    public TableDataInfo list(SysDictData dictData)
    {
        dictData.setDictType("domicileType");
        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
        return getDataTable(list);
    }
    /**
     * 小程序查询无户口人员登记列表
     */
    @GetMapping("/queryList")
    public TableDataInfo queryList(QyglHouseholdDomicile qyglHouseholdDomicile,String code)
    {
        startPage();
        AjaxResult openIdInfo=WXspOpenId(code);
        if(openIdInfo.containsKey("openId"))
        {
            qyglHouseholdDomicile.setOpenId(openIdInfo.get("openId").toString());
        }else {
            TableDataInfo rspData = new TableDataInfo();
            rspData.setCode(HttpStatus.ERROR);
            rspData.setMsg("查询失败,openId获取失败");
            return rspData;
        }
        List<QyglHouseholdDomicile> list = qyglHouseholdDomicileService.selectQyglHouseholdDomicileList(qyglHouseholdDomicile);
        List<QyglHouseholdDomicile> domicileList =new ArrayList<>();
        for (QyglHouseholdDomicile householdDomicile:list)
        {
            String dictData =dictDataService.selectDictLabel("domicileType",householdDomicile.getRegisterType());
            householdDomicile.setRegisterType(dictData);
            domicileList.add(householdDomicile);
        }
        return getDataTable(domicileList);
    }
    /**
     * 导出无户口人员登记列表
     */
    @PreAuthorize("@ss.hasPermi('system:domicile:export')")
    @Log(title = "无户口人员登记", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(QyglHouseholdDomicile qyglHouseholdDomicile)
    {
        List<QyglHouseholdDomicile> list = qyglHouseholdDomicileService.selectQyglHouseholdDomicileList(qyglHouseholdDomicile);
        ExcelUtil<QyglHouseholdDomicile> util = new ExcelUtil<QyglHouseholdDomicile>(QyglHouseholdDomicile.class);
        return util.exportExcel(list, "无户口人员登记数据");
    }

    /**
     * 获取无户口人员登记详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:domicile:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(qyglHouseholdDomicileService.selectQyglHouseholdDomicileById(id));
    }

    /**
     * 新增无户口人员登记
     */
    @Log(title = "无户口人员登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(QyglHouseholdDomicile qyglHouseholdDomicile,String code)
    {
        AjaxResult openIdInfo=WXspOpenId(code);
        if(openIdInfo.containsKey("openId"))
        {
            qyglHouseholdDomicile.setOpenId(openIdInfo.get("openId").toString());
        }
        return toAjax(qyglHouseholdDomicileService.insertQyglHouseholdDomicile(qyglHouseholdDomicile));
    }

    /**
     * 修改无户口人员登记
     */
    @PreAuthorize("@ss.hasPermi('system:domicile:edit')")
    @Log(title = "无户口人员登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QyglHouseholdDomicile qyglHouseholdDomicile)
    {
        return toAjax(qyglHouseholdDomicileService.updateQyglHouseholdDomicile(qyglHouseholdDomicile));
    }

    /**
     * 删除无户口人员登记
     */
    @PreAuthorize("@ss.hasPermi('system:domicile:remove')")
    @Log(title = "无户口人员登记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(qyglHouseholdDomicileService.deleteQyglHouseholdDomicileByIds(ids));
    }
    /**
     * 获取登录OpenId
     * @param code
     * @return
     */
    public AjaxResult WXspOpenId(String code){

        AjaxResult ajax = AjaxResult.success();

        String getOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+ Constants.WXSP_APPID+"&secret="+Constants.WXSP_SECRET+"&js_code="+code+"&grant_type=authorization_code";

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpOpenIdGet = new HttpGet(getOpenIdUrl);
        CloseableHttpResponse responseOpenId = null;
        try {
            responseOpenId = httpclient.execute(httpOpenIdGet);
            String contentOpenId = EntityUtils.toString(responseOpenId.getEntity(), "UTF-8");
            JSONObject json_openid = JSONObject.parseObject(contentOpenId);
            if(json_openid.containsKey("errcode")){
                return AjaxResult.error((Integer) json_openid.get("errcode"),json_openid.get("errmsg").toString());
            }

            String openId = json_openid.get("openid").toString();
            ajax.put("openId",openId);
            return ajax;
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    /**
     * 获取登录人手机号
     * @param map
     * @return
     */
    public AjaxResult GetPhoneNumber(@RequestBody Map<String, Object> map){
        AjaxResult ajax = new AjaxResult();
        String getAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Constants.WXSP_APPID + "&secret=" + Constants.WXSP_SECRET;
        Map<String,Object> codeMap = new HashMap<>();
        codeMap.put("code",map.get("code"));
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpAccessTokenGet = new HttpGet(getAccessTokenUrl);
            CloseableHttpResponse responseAccessToken;
            responseAccessToken = httpclient.execute(httpAccessTokenGet);
            String contentAccessToken = EntityUtils.toString(responseAccessToken.getEntity(), "UTF-8");
            JSONObject json_access_token = JSONObject.parseObject(contentAccessToken);
            String access_token = json_access_token.get("access_token").toString();
            String s = JSONObject.toJSONString(codeMap);
            String body = HttpRequest.post("https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + access_token).body(s).execute().body();
            JSONObject phoneObject = JSONObject.parseObject(body);
            String phone_info = phoneObject.get("phone_info").toString();
            JSONObject phone_info1 = JSONObject.parseObject(phone_info);
            String phoneNumber = phone_info1.get("phoneNumber").toString();
            ajax.put("code",200);
            ajax.put("phoneNumber",phoneNumber);
            return ajax;
        }catch (Exception e){
            return error(e.getMessage());
        }
    }
}
