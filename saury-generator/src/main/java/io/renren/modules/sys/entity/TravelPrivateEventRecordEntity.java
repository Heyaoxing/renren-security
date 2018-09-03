package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 私人事件记录
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-11 16:44:14
 */
@TableName("travel_private_event_record")
public class TravelPrivateEventRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long petId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 事件类型
	 */
	private Integer eventType;
	/**
	 * 事件描述
	 */
	private String eventDesc;
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
	 * 设置：
	 */
	public void setPetId(Long petId) {
		this.petId = petId;
	}
	/**
	 * 获取：
	 */
	public Long getPetId() {
		return petId;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：事件类型
	 */
	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}
	/**
	 * 获取：事件类型
	 */
	public Integer getEventType() {
		return eventType;
	}
	/**
	 * 设置：事件描述
	 */
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	/**
	 * 获取：事件描述
	 */
	public String getEventDesc() {
		return eventDesc;
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
