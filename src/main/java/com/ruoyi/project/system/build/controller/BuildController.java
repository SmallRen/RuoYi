package com.ruoyi.project.system.build.controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ruoyi.common.utils.FileUploadUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.constant.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.build.domain.Build;
import com.ruoyi.project.system.build.service.IBuildService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLNonTransientException;
import java.util.Date;
import java.util.List;

import static com.ruoyi.framework.web.domain.AjaxResult.foreignKeyError;

/**
 * 教学楼信息
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/laboratory/build")
public class BuildController extends BaseController {
    private String prefix = "laboratory/build";

    @Autowired
    private IBuildService service;

    @RequiresPermissions("laboratory:build:view")
    @GetMapping("/view")
    public String build() {
        return prefix + "/build";
    }

    @RequiresPermissions("laboratory:build:list")
    @GetMapping("/list")
    @ResponseBody
    public List<Build> list() {
        List<Build> buildList = service.findAll();
        return buildList;
    }

    /**
     * 修改
     */
    @Log(title = "教学楼管理更新", action = BusinessType.UPDATE)
    @RequiresPermissions("laboratory:build:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Build build = service.find(id);
        model.addAttribute("build", build);
        return prefix + "/edit";
    }


    /**
     * 修改
     */
    @GetMapping("/find/{id}")
    @ResponseBody
    public Build find(@PathVariable("id") Long id) {
        Build build = service.find(id);
        return build;
    }


    /**
     * 新增
     */
    @Log(title = "教学楼管理", action = BusinessType.INSERT)
    @RequiresPermissions("laboratory:build:add")
    @GetMapping("/add")
    public String add(Model model) {
        return prefix + "/add";
    }

    /**
     * 保存
     */
    @Log(title = "教学楼管理保存", action = BusinessType.SAVE)
    @RequiresPermissions("laboratory:build:save")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(Build build) {
        if (build.getTeachBuildId() != null) {
            service.update(build);
        } else {
            build.setCreateTime(new Date());

            service.save(build);
        }

        return success();
    }

    /**
     * 删除
     */
    @Log(title = "教学楼管理", action = BusinessType.DELETE)
    @RequiresPermissions("laboratory:build:remove")
    @PostMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id) {
        try {
            service.delete(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return  foreignKeyError();
        }

        return success();

    }

    /**
     * 保存头像
     */
    @Log(title = "个人信息", action = BusinessType.SAVE)
    @PostMapping("/uploadImg")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String laboratoryImg = FileUploadUtils.upload(file);
                return success().put("name", laboratoryImg);

            }
            return error();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}
