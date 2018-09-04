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

import io.renren.modules.sys.entity.ProjectInfoEntity;
import io.renren.modules.sys.service.ProjectInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目信息表
 *
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
@RestController
@RequestMapping("sys/projectinfo")
public class ProjectInfoController {
    @Autowired
    private ProjectInfoService projectInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:projectinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    @RequiresPermissions("sys:projectinfo:info")
    public R info(@PathVariable("projectId") Long projectId){
        ProjectInfoEntity projectInfo = projectInfoService.selectById(projectId);

        return R.ok().put("projectInfo", projectInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:projectinfo:save")
    public R save(@RequestBody ProjectInfoEntity projectInfo){
        projectInfoService.insert(projectInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:projectinfo:update")
    public R update(@RequestBody ProjectInfoEntity projectInfo){
        ValidatorUtils.validateEntity(projectInfo);
        projectInfoService.updateAllColumnById(projectInfo);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:projectinfo:delete")
    public R delete(@RequestBody Long[] projectIds){
        projectInfoService.deleteBatchIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
