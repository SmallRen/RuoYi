package com.ruoyi.project.system.table.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.constant.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.build.domain.Build;
import com.ruoyi.project.system.build.service.IBuildService;
import com.ruoyi.project.system.table.domain.SysTable;
import com.ruoyi.project.system.table.service.ISysTableService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/laboratory/table")
public class SysTableController extends BaseController {

    private String prefix = "laboratory/table";
    @Autowired
    IBuildService iBuildService;
    @Autowired
    ISysTableService service;

    @RequiresPermissions("laboratory:table:view")
    @GetMapping()
    public String management(Model model) {
        List<Build> buildList = iBuildService.findAll();
        model.addAttribute("buildList", buildList);
        return prefix + "/table";
    }

    @Log(title = "实验台管理查询", action = BusinessType.SELECT)
    @RequiresPermissions("laboratory:table:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTable sysTable) {
        startPage();
        List<SysTable> list = service.selectList(sysTable);
        return getDataTable(list);
    }

    @Log(title = "实验台管理导出", action = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysTable sysTable) throws Exception {
        try {
            List<SysTable> list = service.selectList(sysTable);
            ExcelUtil<SysTable> util = new ExcelUtil<SysTable>(SysTable.class);
            return util.exportExcel(list, "post");
        } catch (Exception e) {
            return error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("laboratory:table:remove")
    @Log(title = "实验台管理删除", action = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long ids) {
        try {
            service.deleteByIds(ids);
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }


    /**
     * 新增实验台
     */
    @GetMapping("/add")
    public String add(Model model) {
        List<Build> buildList = iBuildService.findAll();
        model.addAttribute("buildList", buildList);
        return prefix + "/add";
    }

    /**
     * 修改实验台
     */
    @GetMapping("/edit/{tableId}")
    public String edit(@PathVariable("tableId") Long tableId, Model model) {
        List<Build> buildList = iBuildService.findAll();
        model.addAttribute("buildList", buildList);
        SysTable sysTable = service.find(tableId);
        model.addAttribute("sysTable", sysTable);

        return prefix + "/edit";
    }


    /**
     * 保存实验台
     */
    @Log(title = "实验台管理保存", action = BusinessType.SAVE)
    @RequiresPermissions("laboratory:table:save")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(SysTable sysTable) {
        if (service.save(sysTable) > 0) {
            return success();
        }
        return error();
    }

    /**
     * 保存实验台
     */
    @Log(title = "实验台管理更新", action = BusinessType.SAVE)
    @RequiresPermissions("laboratory:table:update")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(SysTable sysTable) {
        if (service.update(sysTable) > 0) {
            return success();
        }
        return error();
    }
}
