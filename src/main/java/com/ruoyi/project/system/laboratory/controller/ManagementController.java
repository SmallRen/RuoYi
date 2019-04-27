package com.ruoyi.project.system.laboratory.controller;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.service.IDeptService;
import org.springframework.ui.Model;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.constant.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.laboratory.domain.Laboratory;
import com.ruoyi.project.system.laboratory.service.ILaboratoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/laboratory/management")
public class ManagementController extends BaseController {

    private String prefix = "laboratory/management";


    @Autowired
    private ILaboratoryService service;

    @RequiresPermissions("laboratory:management:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }
 


    @RequiresPermissions("laboratory:management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Laboratory> list = service.selectList();
        return getDataTable(list);
    }

    @Log(title = "实验室管理", action = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Laboratory laboratory) throws Exception
    {
        try
        {
            List<Laboratory> list = service.selectList();
            ExcelUtil<Laboratory> util = new ExcelUtil<Laboratory>(Laboratory.class);
            return util.exportExcel(list, "post");
        }
        catch (Exception e)
        {
            return error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("laboratory:management:remove")
    @Log(title = "实验室管理", action = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            service.deleteByIds(ids);
            return success();
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
    @Autowired
    private IDeptService deptService;

    /**
     * 新增实验室
     */
    @Log(title = "实验室管理", action = BusinessType.INSERT)
    @RequiresPermissions("laboratory:management:add")
    @GetMapping("/add")
    public String add( Model model)
    {
        Dept dept = deptService.selectDeptById(100L);
        model.addAttribute("dept", dept);
        return prefix + "/add";
    }
    /**
     * 修改实验室
     */
    @Log(title = "实验室管理", action = BusinessType.UPDATE)
    @RequiresPermissions("laboratory:management:edit")
    @GetMapping("/edit/{laboratoryId}")
    public String edit(@PathVariable("laboratoryId") Long laboratoryId, Model model)
    {
        Laboratory laboratory = service.selectById(laboratoryId);
        model.addAttribute("post", laboratory);
        return prefix + "/edit";
    }


    /**
     * 保存实验室
     */
    @Log(title = "实验室管理", action = BusinessType.SAVE)
    @RequiresPermissions("laboratory:management:save")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(Laboratory laboratory)
    {
        if (service.save(laboratory) > 0)
        {
            return success();
        }
        return error();
    }

}
