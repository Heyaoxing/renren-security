package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息表
 * 
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
@TableName("project_info")
@Getter
@Setter
public class ProjectInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long projectId;
	/**
	 * 项目名称
	 */
	private String name;

	/**
	 * 数据库名称
	 */
	private String databaseName;
	/**
	 * 项目描述
	 */
	private String descript;
	/**
	 * 创建时间
	 */
	private Date createdTm;
	/**
	 * 创建人
	 */
	private String createdEmp;

}
