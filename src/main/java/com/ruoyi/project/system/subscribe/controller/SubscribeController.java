package com.ruoyi.project.system.subscribe.controller;

import com.ruoyi.common.utils.StringUtils;
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
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @GetMapping("/tomorrowTime/{tableId}")
    @ResponseBody
    public List<Subscribe> tomorrowTime(@PathVariable Long tableId) throws ParseException {
        List<Subscribe> list = service.findByTableId(tableId);
        List<Subscribe> subscribeList = new ArrayList<>();
        for (Subscribe subscribe : list) {
            //2019-05-05 18:00:01 - 2019-05-05 21:01:00
            String tomorrowTime = subscribe.getTomorrowTime();
            if (!StringUtils.isEmpty(tomorrowTime)) {
                String time = tomorrowTime.substring(0, 10);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if (dateFormat.format(new Date()).equals(time)) {
                    subscribeList.add(subscribe);
                }
            }


        }
        return subscribeList;
    }


  /*  for (Subscribe subscribe : list) {
        //2019-05-05 18:00:01 - 2019-05-05 21:01:00
        String tomorrowTime = subscribe.getTomorrowTime();
        if (!StringUtils.isEmpty(tomorrowTime)){
            String[] split = tomorrowTime.split(" - ");
            System.out.println(split);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = simpleDateFormat.parse(split[0]);
            Date stopTime = simpleDateFormat.parse(split[0]);
        }



    }*/

    @GetMapping("/dayTime/{tableId}")
    @ResponseBody
    public List<Subscribe> dayTime(@PathVariable Long tableId) {
        List<Subscribe> list = service.findByTableId(tableId);
        List<Subscribe> subscribeList = new ArrayList<>();
        for (Subscribe subscribe : list) {
            //2019-05-05 18:00:01 - 2019-05-05 21:01:00
            String dayTime = subscribe.getDayTime();
            if (!StringUtils.isEmpty(dayTime)) {
                String time = dayTime.substring(0, 10);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if (dateFormat.format(new Date()).equals(time)) {
                    subscribeList.add(subscribe);
                }
            }


        }
        return subscribeList;
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datTime = spf.format(new Date());
        String tomTime = spf.format(sDate);
        //校验时间是否在区间内
        List<Subscribe> list = service.findByTableId(subscribe.getTableId());
        for (Subscribe subscribe1 : list) {
            //15:00:00 - 10:00:00
            String dayTime = subscribe.getDayTime();
            String tomorrowTime = subscribe.getTomorrowTime();

            if (!dayTime.equals("")) {
                String[] dayTimeArr = dayTime.split(" - ");
                String dayStartTimeStr = datTime + " " + dayTimeArr[0];
                String dayStopTimeStr = datTime + " " + dayTimeArr[1];
                Date dayStartDate = simpleDateFormat.parse(dayStartTimeStr);
                Date dayStopDate = simpleDateFormat.parse(dayStopTimeStr);
                long dayStartLong = dayStartDate.getTime();
                long dayStopLong = dayStopDate.getTime();
                if (!StringUtils.isEmpty(subscribe1.getDayTime())) {
                    String[] split = subscribe1.getDayTime().split(" - ");
                    System.out.println(split);

                    Date startTime = simpleDateFormat.parse(split[0]);
                    Date stopTime = simpleDateFormat.parse(split[1]);
                    long longStart = startTime.getTime();
                    long longStop = stopTime.getTime();
                    //开始时间在区间内
                    if (dayStartLong >= longStart && dayStartLong <= longStop) {
                        //存在今天时间内
                        return error("预约今天开始时间有冲突时间，请重新选择时间！");
                    }
                    //结束时间在区间内
                    if (dayStopLong >= longStart && dayStopLong <= longStop) {
                        //存在今天时间内
                        return error("预约今天结束时间有冲突时间，请重新选择时间！");
                    }
                    //开始时间和结束时间都在区间内
                    if (dayStopLong >= longStart && dayStopLong <= longStop) {
                        //存在今天时间内
                        return error("预约今天开始时间和结束时间有冲突时间，请重新选择时间！");
                    }
                }
            } else if (!tomorrowTime.equals("")) {
                //15:00:00 - 10:00:00
                String[] dayTimeArr = tomorrowTime.split(" - ");
                String dayStartTimeStr = tomTime + " " + dayTimeArr[0];
                String dayStopTimeStr = tomTime + " " + dayTimeArr[1];
                Date dayStartDate = simpleDateFormat.parse(dayStartTimeStr);
                Date dayStopDate = simpleDateFormat.parse(dayStopTimeStr);
                long dayStartLong = dayStartDate.getTime();
                long dayStopLong = dayStopDate.getTime();
                //2018-02-23 12:00:00 - 2018-02-23 18:42:20
                if (!StringUtils.isEmpty(subscribe1.getTomorrowTime())) {
                    String[] split = dayTime.split(" - ");
                    Date startTime = simpleDateFormat.parse(split[0]);
                    Date stopTime = simpleDateFormat.parse(split[1]);
                    long longStart = startTime.getTime();
                    long longStop = stopTime.getTime();
                    //开始时间在区间内
                    if (dayStartLong >= longStart && dayStartLong <= longStop) {
                        //存在今天时间内
                        return error("预约明天开始时间有冲突时间，请重新选择时间！");
                    }
                    //结束时间在区间内
                    if (dayStopLong >= longStart && dayStopLong <= longStop) {
                        //存在今天时间内
                        return error("预约明天结束时间有冲突时间，请重新选择时间！");
                    }
                    //开始时间和结束时间都在区间内
                    if (dayStopLong >= longStart && dayStopLong <= longStop) {
                        //存在今天时间内
                        return error("预约明天开始时间和结束时间有冲突时间，请重新选择时间！");
                    }
                }
            }
        }

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
            String time = tomorrowTime + " " + subscribe.getTomorrowTime();
            StringBuilder builder = new StringBuilder(time);
            builder.insert(22, tomorrowTime + " ");
            subscribe.setTomorrowTime(builder.toString()); //2018-02-23 12:00:00 - 18:42:20
        }
        service.insert(subscribe);
        return success();
    }

}
