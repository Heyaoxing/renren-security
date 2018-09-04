package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.ProjectVersionInfoEntity;
import io.renren.modules.sys.service.ProjectVersionInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目版本信息
 *
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
@RestController
@RequestMapping("sys/projectversioninfo")
public class ProjectVersionInfoController {
    @Autowired
    private ProjectVersionInfoService projectVersionInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:projectversioninfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectVersionInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{versionId}")
    @RequiresPermissions("sys:projectversioninfo:info")
    public R info(@PathVariable("versionId") Long versionId){
        ProjectVersionInfoEntity projectVersionInfo = projectVersionInfoService.selectById(versionId);

        return R.ok().put("projectVersionInfo", projectVersionInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:projectversioninfo:save")
    public R save(@RequestBody ProjectVersionInfoEntity projectVersionInfo){
        projectVersionInfoService.insert(projectVersionInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:projectversioninfo:update")
    public R update(@RequestBody ProjectVersionInfoEntity projectVersionInfo){
        ValidatorUtils.validateEntity(projectVersionInfo);
        projectVersionInfoService.updateAllColumnById(projectVersionInfo);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:projectversioninfo:delete")
    public R delete(@RequestBody Long[] versionIds){
        projectVersionInfoService.deleteBatchIds(Arrays.asList(versionIds));

        return R.ok();
    }

}
