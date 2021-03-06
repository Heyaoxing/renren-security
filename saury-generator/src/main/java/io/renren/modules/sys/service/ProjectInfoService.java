package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ProjectInfoEntity;

import java.util.Map;

/**
 * 项目信息表
 *
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
public interface ProjectInfoService extends IService<ProjectInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取项目详情
     * @param projectId
     * @return
     */
    ProjectInfoEntity getDetail(Long projectId);
}

