package com.ruoyi.project.system.laboratory.controller;
import com.ruoyi.common.utils.FileUploadUtils;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.service.IDeptService;
import com.ruoyi.project.system.teachbuild.domain.TeachBuild;
import com.ruoyi.project.system.teachbuild.service.ITeachBuildService;
import com.ruoyi.project.system.user.domain.User;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/laboratory/management")
public class ManagementController extends BaseController {

    private String prefix = "laboratory/management";

@Autowired
ITeachBuildService iTeachBuildService;
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
        List<TeachBuild> list= iTeachBuildService.findAll();
        model.addAttribute("dept", dept);
        model.addAttribute("teach", list);
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
       List<TeachBuild> list= iTeachBuildService.findAll();
        Laboratory laboratory = service.selectById(laboratoryId);
        model.addAttribute("post", laboratory);
        model.addAttribute("teach", list);
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

    /**
     * 保存实验室
     */
    @Log(title = "实验室管理", action = BusinessType.SAVE)
    @RequiresPermissions("laboratory:management:update")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(Laboratory laboratory)
    {
        if (service.update(laboratory) > 0)
        {
            return success();
        }
        return error();
    }

    /**
     * 保存头像
     */
    @Log(title = "个人信息", action = BusinessType.SAVE)
    @PostMapping("/uploadImg")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestHeader Long laboratoryId, @RequestParam("avatarfile") MultipartFile file)
    {
        try
        {
            if (!file.isEmpty())
            {
                String laboratoryImg = FileUploadUtils.upload(file);
                service.updateImg(laboratoryImg,laboratoryId);
                    return success().put("name",laboratoryImg);

            }
            return error();
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }



}
