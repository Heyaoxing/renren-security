package io.renren.modules.sys.service.impl;

import io.renren.modules.sys.model.MenuTemplateDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.MenuTemplateDao;
import io.renren.modules.sys.entity.MenuTemplateEntity;
import io.renren.modules.sys.service.MenuTemplateService;
import org.springframework.util.CollectionUtils;


@Service("menuTemplateService")
public class MenuTemplateServiceImpl extends ServiceImpl<MenuTemplateDao, MenuTemplateEntity> implements MenuTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenuTemplateEntity> page = this.selectPage(
                new Query<MenuTemplateEntity>(params).getPage(),
                new EntityWrapper<MenuTemplateEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 获取模版菜单下拉列表
     * @param projectId
     * @return
     */
    @Override
    public List<MenuTemplateDTO> getSelectData(Long projectId){
        List<MenuTemplateDTO> result=new ArrayList<>();
        Map<String, Object> columnMap=new HashMap<>();
        columnMap.put("project_id",projectId);
        List<MenuTemplateEntity> list=this.selectByMap(columnMap);
        if(!CollectionUtils.isEmpty(list)){
            BeanUtils.copyProperties(list,result);
        }
        return result;
    }
}
