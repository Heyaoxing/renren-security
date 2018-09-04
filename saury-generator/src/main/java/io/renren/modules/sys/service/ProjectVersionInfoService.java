package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ProjectVersionInfoEntity;

import java.util.Map;

/**
 * 项目版本信息
 *
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
public interface ProjectVersionInfoService extends IService<ProjectVersionInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

