package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单模版表
 * 
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
@TableName("menu_template")
public class MenuTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long menuTempId;
	/**
	 * 
	 */
	private Long projectId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 所在菜单id
	 */
	private Long menuId;
	/**
	 * 父级菜单id
	 */
	private Long parentId;
	/**
	 * 类型   0：目录   1：菜单   2：按钮
            
	 */
	private Integer type;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 排序
	 */
	private Integer orderNum;
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
	public void setMenuTempId(Long menuTempId) {
		this.menuTempId = menuTempId;
	}
	/**
	 * 获取：
	 */
	public Long getMenuTempId() {
		return menuTempId;
	}
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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：所在菜单id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：所在菜单id
	 */
	public Long getMenuId() {
		return menuId;
	}
	/**
	 * 设置：父级菜单id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级菜单id
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：类型   0：目录   1：菜单   2：按钮
            
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型   0：目录   1：菜单   2：按钮
            
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：菜单图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：菜单图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
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
