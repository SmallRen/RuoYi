package com.ruoyi.project.system.subscribe.controller;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.constant.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.subscribe.domain.Subscribe;
import com.ruoyi.project.system.subscribe.service.ISubscribeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/laboratory/subscribe")
public class SubscribeController extends BaseController {
    private String prefix = "laboratory/subscribe";
    @Autowired
    ISubscribeService service;

    @RequiresPermissions("laboratory:subscribe:view")
    @GetMapping()
    public String management() {
        return prefix + "/subscribe";
    }

    @Log(title = "预约列表", action = BusinessType.SELECT)
    @RequiresPermissions("laboratory:subscribe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<Subscribe> list = service.findAll();
        return getDataTable(list);
    }

    @Log(title = "预约保存", action = BusinessType.SAVE)
    @RequiresPermissions("laboratory:subscribe:save")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(Subscribe subscribe) throws ParseException {
        subscribe.setUserId(ShiroUtils.getUserId());
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date sDate = c.getTime();
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        String datTime = spf.format(new Date());
        String tomorrowTime = spf.format(sDate);
        if (!subscribe.getDayTime().equals("")) {
            //2018-02-23 12:00:00 - 18:42:20
            String time = datTime + " " + subscribe.getDayTime();
            StringBuilder builder = new StringBuilder(time);
            builder.insert(22, datTime + " ");
            subscribe.setDayTime(builder.toString()); //2018-02-23 12:00:00 - 18:42:20
        }
        if (!subscribe.getTomorrowTime().equals("")) {
            //2018-02-23 12:00:00 - 18:42:20
            String time = datTime + " " + subscribe.getTomorrowTime();
            StringBuilder builder = new StringBuilder(time);
            builder.insert(22, datTime + " ");
            subscribe.setTomorrowTime(builder.toString()); //2018-02-23 12:00:00 - 18:42:20
        }
        service.insert(subscribe);
        return success();
    }

}
