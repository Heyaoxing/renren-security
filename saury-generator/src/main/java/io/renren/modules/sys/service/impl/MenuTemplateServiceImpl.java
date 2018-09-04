package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.MenuTemplateDao;
import io.renren.modules.sys.entity.MenuTemplateEntity;
import io.renren.modules.sys.service.MenuTemplateService;


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

}
