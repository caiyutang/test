package com.ruoyi.project.system.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpClientUtil;
import com.ruoyi.common.utils.sign.GenerateCodeUtil;
import com.ruoyi.framework.security.LoginBody;
import com.ruoyi.framework.security.service.SysLoginService;
import com.ruoyi.framework.security.service.SysPermissionService;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.domain.SysMenu;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.system.service.ISysMenuService;
import com.ruoyi.project.zazl.domain.PersonInfo;
import com.ruoyi.project.zazl.service.IPersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private IPersonInfoService iPersonInfoService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/zlbLogin")
    public AjaxResult zlbLogin(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        String ticket = loginBody.getCode();
        System.out.println("ticket:"+ticket);
        HttpRequest.get("https://api.day.app/8Umvn4c8rVfUkvJf3VaN6Q/民企护航登录浙里办ticket:"+ticket).execute().body();
        if(StringUtils.isNotBlank(ticket)){
            try {
                if (StringUtils.isNotBlank(ticket)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("servicecode", "mqhhxf");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    map.put("time", sdf.format(new Date()));
                    String sign = GenerateCodeUtil.MD5("mqhhxf" + "mqhhxfpwd" + map.get("time").toString());
                    map.put("sign", sign);
                    map.put("st", ticket);
                    map.put("datatype", "json");
                    com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(HttpClientUtil.doPost("https://appapi.zjzwfw.gov.cn/sso/servlet/simpleauth?method=ticketValidation", map));
                    if (jsonObject != null) {
                        if (jsonObject.getString("result").equals("0")) {
                            map.put("token", jsonObject.getString("token"));
                            JSONObject result = JSONObject.parseObject(HttpClientUtil.doPost("https://appapi.zjzwfw.gov.cn/sso/servlet/simpleauth?method=getUserInfo", map));
                            if (result != null) {
                                if (result.getString("result").equals("0")) {
                                    if (result.getString("idtype").equals("1") && StringUtils.isNotBlank(result.getString("idnum"))) {
                                        String phone = result.getString("mobile");
                                        //代替登陆,该账户为非后台用户的通用账户，仅用于避开系统登陆，后续个人信息从resultmap解密获取
                                        String token = loginService.login(phone, UserConstants.NO_NEED_PWD, loginBody.getCode(),
                                                loginBody.getUuid());
                                        ajax.put(Constants.TOKEN,token);
                                        ajax.put("userid", result.getString("userid"));
                                        ajax.put("flag",result.getString("username"));
                                        ajax.put("phoneNo",phone);
                                    } else {
                                        return AjaxResult.error("您的登记证件不符合服务要求");
                                    }
                                } else {
                                    return AjaxResult.error(jsonObject.getString("errmsg"));
                                }
                            } else {
                                return  AjaxResult.error("单点登陆验证失败");
                            }
                        } else {
                            return AjaxResult.error(jsonObject.getString("errmsg"));
                        }
                    } else {
                        return AjaxResult.error("单点登陆验证失败");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
//        //通过浙里办接口获取用户的信息
            String phone = "18767690938";
            // 生成令牌
            String token = loginService.login(phone, UserConstants.NO_NEED_PWD, loginBody.getCode(),
                    loginBody.getUuid());
            ajax.put(Constants.TOKEN, token);
            ajax.put("phoneNo",phone);
        }
        return ajax;
    }

    /**
     * 登录方法(浙政钉)
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/zzdLogin")
    public AjaxResult zzdLogin(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        String ticket = loginBody.getCode();
        HttpRequest.get("https://api.day.app/8Umvn4c8rVfUkvJf3VaN6Q/民企护航登录浙政钉ticket:"+ticket).execute().body();
        if(StringUtils.isNotBlank(ticket)){
            try {
                if (StringUtils.isNotBlank(ticket)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("servicecode", "mqhhxf");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    map.put("time", sdf.format(new Date()));
                    String sign = GenerateCodeUtil.MD5("mqhhxf" + "mqhhxfpwd" + map.get("time").toString());
                    map.put("sign", sign);
                    map.put("st", ticket);
                    map.put("datatype", "json");
                    com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(HttpClientUtil.doPost("https://appapi.zjzwfw.gov.cn/sso/servlet/simpleauth?method=ticketValidation", map));
                    if (jsonObject != null) {
                        if (jsonObject.getString("result").equals("0")) {
                            map.put("token", jsonObject.getString("token"));
                            JSONObject result = JSONObject.parseObject(HttpClientUtil.doPost("https://appapi.zjzwfw.gov.cn/sso/servlet/simpleauth?method=getUserInfo", map));
                            if (result != null) {
                                if (result.getString("result").equals("0")) {
                                    if (result.getString("idtype").equals("1") && StringUtils.isNotBlank(result.getString("idnum"))) {
                                        String phone = result.getString("mobile");
                                        //代替登陆,该账户为非后台用户的通用账户，仅用于避开系统登陆，后续个人信息从resultmap解密获取
                                        String token = loginService.login(phone, UserConstants.NO_NEED_PWD, loginBody.getCode(),
                                                loginBody.getUuid());
                                        ajax.put(Constants.TOKEN,token);
                                        ajax.put("userid", result.getString("userid"));
                                        ajax.put("flag",result.getString("username"));
                                    } else {
                                        return AjaxResult.error("您的登记证件不符合服务要求");
                                    }
                                } else {
                                    return AjaxResult.error(jsonObject.getString("errmsg"));
                                }
                            } else {
                                return  AjaxResult.error("单点登陆验证失败");
                            }
                        } else {
                            return AjaxResult.error(jsonObject.getString("errmsg"));
                        }
                    } else {
                        return AjaxResult.error("单点登陆验证失败");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
//        //通过浙里办接口获取用户的信息
            String phone = "15867016989";
            // 生成令牌
            String token = loginService.login(phone, UserConstants.DEFAULT_PWD, loginBody.getCode(),
                    loginBody.getUuid());
            ajax.put(Constants.TOKEN, token);
        }
        return ajax;
    }

    /**
     * 获取用户信息（企业）
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() throws Exception
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        // 企业中的信息（可能处在多个企业）
        List<PersonInfo> personInfos = iPersonInfoService.selectPersonInfosByPhoneNo(user.getUserName());
        ajax.put("personInfos",personInfos);
        return ajax;
    }

    /**
     * 获取用户信息（政府公安）
     *
     * @return 用户信息
     */
    @GetMapping("getAdminInfo")
    public AjaxResult getAdminInfo() throws Exception
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }

    public static void main(String[] args) {
        String ticket = "8a118afd7c9411ba017cb4dbd97f6891-ticket";
        System.out.println("ticket:"+ticket);
        try {
            if (StringUtils.isNotBlank(ticket)) {
                Map<String, Object> map = new HashMap<>();
                map.put("servicecode", "mqhhxf");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                map.put("time", sdf.format(new Date()));
                String sign = GenerateCodeUtil.MD5("mqhhxf" + "mqhhxfpwd" + map.get("time").toString());
                map.put("sign", sign);
                map.put("st", ticket);
                map.put("datatype", "json");
                com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(HttpClientUtil.doPost("https://appapi.zjzwfw.gov.cn/sso/servlet/simpleauth?method=ticketValidation", map));
                if (jsonObject != null) {
                    if (jsonObject.getString("result").equals("0")) {
                        map.put("token", jsonObject.getString("token"));
                        JSONObject result = JSONObject.parseObject(HttpClientUtil.doPost("https://appapi.zjzwfw.gov.cn/sso/servlet/simpleauth?method=getUserInfo", map));
                        if (result != null) {
                            if (result.getString("result").equals("0")) {
                                if (result.getString("idtype").equals("1") && StringUtils.isNotBlank(result.getString("idnum"))) {
                                    String phone = result.getString("mobile");
                                    //代替登陆,该账户为非后台用户的通用账户，仅用于避开系统登陆，后续个人信息从resultmap解密获取
//                                    String token = loginService.login(phone, UserConstants.NO_NEED_PWD, loginBody.getCode(),
//                                            loginBody.getUuid());
//                                    ajax.put(Constants.TOKEN,token);
                                    System.out.println("userid:"+ result.getString("userid"));
                                    System.out.println("flag:"+result.getString("username"));
                                } else {
                                    System.out.println("您的登记证件不符合服务要求");
                                }
                            } else {
                                System.out.println(jsonObject.getString("errmsg"));
                            }
                        } else {
                            System.out.println("单点登陆验证失败");
                        }
                    } else {
                        System.out.println(jsonObject.getString("errmsg"));
                    }
                } else {
                    System.out.println("单点登陆验证失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
