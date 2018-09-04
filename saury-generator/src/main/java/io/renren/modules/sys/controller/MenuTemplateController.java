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

import io.renren.modules.sys.entity.MenuTemplateEntity;
import io.renren.modules.sys.service.MenuTemplateService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 菜单模版表
 *
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
@RestController
@RequestMapping("sys/menutemplate")
public class MenuTemplateController {
    @Autowired
    private MenuTemplateService menuTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menutemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = menuTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuTempId}")
    @RequiresPermissions("sys:menutemplate:info")
    public R info(@PathVariable("menuTempId") Long menuTempId){
        MenuTemplateEntity menuTemplate = menuTemplateService.selectById(menuTempId);

        return R.ok().put("menuTemplate", menuTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:menutemplate:save")
    public R save(@RequestBody MenuTemplateEntity menuTemplate){
        menuTemplateService.insert(menuTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:menutemplate:update")
    public R update(@RequestBody MenuTemplateEntity menuTemplate){
        ValidatorUtils.validateEntity(menuTemplate);
        menuTemplateService.updateAllColumnById(menuTemplate);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menutemplate:delete")
    public R delete(@RequestBody Long[] menuTempIds){
        menuTemplateService.deleteBatchIds(Arrays.asList(menuTempIds));

        return R.ok();
    }

}
