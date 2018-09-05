package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ProjectInfoDao;
import io.renren.modules.sys.entity.ProjectInfoEntity;
import io.renren.modules.sys.service.ProjectInfoService;


@Service("projectInfoService")
public class ProjectInfoServiceImpl extends ServiceImpl<ProjectInfoDao, ProjectInfoEntity> implements ProjectInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProjectInfoEntity> page = this.selectPage(
                new Query<ProjectInfoEntity>(params).getPage(),
                new EntityWrapper<ProjectInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 获取项目详情
     * @param projectId
     * @return
     */
    @Override
    public ProjectInfoEntity getDetail(Long projectId){
        return this.selectById(projectId);
    }
}
