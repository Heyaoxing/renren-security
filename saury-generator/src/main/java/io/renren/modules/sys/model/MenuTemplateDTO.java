package io.renren.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 990016
 * @Date 2018/9/5 15:27
 */
@Getter
@Setter
public class MenuTemplateDTO implements Serializable {
    private Long menuTempId;
    /**
     * 名称
     */
    private String name;
}
