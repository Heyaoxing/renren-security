package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ProjectVersionInfoDao;
import io.renren.modules.sys.entity.ProjectVersionInfoEntity;
import io.renren.modules.sys.service.ProjectVersionInfoService;


@Service("projectVersionInfoService")
public class ProjectVersionInfoServiceImpl extends ServiceImpl<ProjectVersionInfoDao, ProjectVersionInfoEntity> implements ProjectVersionInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProjectVersionInfoEntity> page = this.selectPage(
                new Query<ProjectVersionInfoEntity>(params).getPage(),
                new EntityWrapper<ProjectVersionInfoEntity>()
        );

        return new PageUtils(page);
    }

}
