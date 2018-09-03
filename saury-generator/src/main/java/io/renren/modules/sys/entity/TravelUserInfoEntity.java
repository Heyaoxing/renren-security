package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-11 16:44:14
 */
@TableName("travel_user_info")
public class TravelUserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Integer role;
	/**
	 * 创建时间
	 */
	private Date createdTm;
	/**
	 * 更新时间
	 */
	private Date updatedTm;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * 获取：
	 */
	public Integer getRole() {
		return role;
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
	 * 设置：更新时间
	 */
	public void setUpdatedTm(Date updatedTm) {
		this.updatedTm = updatedTm;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatedTm() {
		return updatedTm;
	}
}
