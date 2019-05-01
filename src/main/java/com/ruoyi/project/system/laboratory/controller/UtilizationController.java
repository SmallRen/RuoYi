package com.ruoyi.project.system.laboratory.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.build.domain.Build;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.subscribe.domain.Subscribe;
import com.ruoyi.project.system.subscribe.service.ISubscribeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/laboratory/utilization")
public class UtilizationController extends BaseController {
    private String prefix = "laboratory/management";

    @Autowired
    ISubscribeService subscribeService;

    @RequiresPermissions("laboratory:utilization:view")
    @GetMapping()
    public String management(Model model) throws ParseException {

        List<Subscribe> all = subscribeService.findAll();
        int total = all.size() * 16;
        for (Subscribe subscribe : all) {
            if (!subscribe.getDayTime().equals("")) {
                String dayTime = subscribe.getDayTime();
                //2019-05-01 18:00:01 - 2019-05-01 21:00:00
                SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String substring = dayTime.substring(0, 19);
                Date startTime = spf.parse(substring);
                String substring1 = dayTime.substring(21, 41);
                Date stopTime = spf.parse(substring1);
                int useTime = (int) ((stopTime.getTime() - startTime.getTime()) / 1000);
                model.addAttribute("useTime", useTime);
                model.addAttribute("spareTime", total * 3600 - useTime);
            }

        }
        return prefix + "/utilization";
    }
}

