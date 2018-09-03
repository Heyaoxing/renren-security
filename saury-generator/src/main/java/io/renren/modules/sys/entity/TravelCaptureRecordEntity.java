package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 捕鼠记录表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-11 16:44:14
 */
@TableName("travel_capture_record")
public class TravelCaptureRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 主动抓的宠物id
	 */
	private Long strongPetId;
	/**
	 * 被抓的宠物id
	 */
	private Long weakPetId;
	/**
	 * 抓捕地区uid
	 */
	private String addressUid;
	/**
	 * 抓捕描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	private Date createdTm;

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
	 * 设置：主动抓的宠物id
	 */
	public void setStrongPetId(Long strongPetId) {
		this.strongPetId = strongPetId;
	}
	/**
	 * 获取：主动抓的宠物id
	 */
	public Long getStrongPetId() {
		return strongPetId;
	}
	/**
	 * 设置：被抓的宠物id
	 */
	public void setWeakPetId(Long weakPetId) {
		this.weakPetId = weakPetId;
	}
	/**
	 * 获取：被抓的宠物id
	 */
	public Long getWeakPetId() {
		return weakPetId;
	}
	/**
	 * 设置：抓捕地区uid
	 */
	public void setAddressUid(String addressUid) {
		this.addressUid = addressUid;
	}
	/**
	 * 获取：抓捕地区uid
	 */
	public String getAddressUid() {
		return addressUid;
	}
	/**
	 * 设置：抓捕描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：抓捕描述
	 */
	public String getDescription() {
		return description;
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
}
