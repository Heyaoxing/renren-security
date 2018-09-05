package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MenuTemplateEntity;
import io.renren.modules.sys.model.MenuTemplateDTO;

import java.util.List;
import java.util.Map;

/**
 * 菜单模版表
 *
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
public interface MenuTemplateService extends IService<MenuTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取模版菜单下拉列表
     * @param projectId
     * @return
     */
    List<MenuTemplateDTO> getSelectData(Long projectId);
}

