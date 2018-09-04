package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

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

	/**
	 * 设置：
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：项目名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：项目名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：项目描述
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}
	/**
	 * 获取：项目描述
	 */
	public String getDescript() {
		return descript;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTm(Date createdTm) {
		this.createdTm = createdTm;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedTm() {
		return createdTm;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreatedEmp(String createdEmp) {
		this.createdEmp = createdEmp;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedEmp() {
		return createdEmp;
	}
}
