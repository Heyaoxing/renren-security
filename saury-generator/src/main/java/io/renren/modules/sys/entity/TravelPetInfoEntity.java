package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-11 16:44:14
 */
@TableName("travel_pet_info")
public class TravelPetInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 父代id
	 */
	private Long parentPetId;
	/**
	 * 第几代
	 */
	private Integer generation;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 类型
            1：猫
            2：老鼠
	 */
	private Integer petType;
	/**
	 * 得到下雨数
	 */
	private Integer receiveRainNum;
	/**
	 * 累计抓捕老鼠数
	 */
	private Integer mousetrapTotal;
	/**
	 * 抓捕老鼠数
	 */
	private Integer mousetrapNum;
	/**
	 * 状态
            100：路途中
            200：到达地点
            300：异常
	 */
	private Integer status;
	/**
	 * 状态描述
	 */
	private String statusDesc;
	/**
	 * 是否被捕
            0:否
            1:是
	 */
	private Integer isArrested;
	/**
	 * 创建时间
	 */
	private Date createdTm;
	/**
	 * 更新时间
	 */
	private Date updatedTm;
	/**
	 * 当前所在地uid
	 */
	private String addressUid;

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
	 * 设置：父代id
	 */
	public void setParentPetId(Long parentPetId) {
		this.parentPetId = parentPetId;
	}
	/**
	 * 获取：父代id
	 */
	public Long getParentPetId() {
		return parentPetId;
	}
	/**
	 * 设置：第几代
	 */
	public void setGeneration(Integer generation) {
		this.generation = generation;
	}
	/**
	 * 获取：第几代
	 */
	public Integer getGeneration() {
		return generation;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：类型
            1：猫
            2：老鼠
	 */
	public void setPetType(Integer petType) {
		this.petType = petType;
	}
	/**
	 * 获取：类型
            1：猫
            2：老鼠
	 */
	public Integer getPetType() {
		return petType;
	}
	/**
	 * 设置：得到下雨数
	 */
	public void setReceiveRainNum(Integer receiveRainNum) {
		this.receiveRainNum = receiveRainNum;
	}
	/**
	 * 获取：得到下雨数
	 */
	public Integer getReceiveRainNum() {
		return receiveRainNum;
	}
	/**
	 * 设置：累计抓捕老鼠数
	 */
	public void setMousetrapTotal(Integer mousetrapTotal) {
		this.mousetrapTotal = mousetrapTotal;
	}
	/**
	 * 获取：累计抓捕老鼠数
	 */
	public Integer getMousetrapTotal() {
		return mousetrapTotal;
	}
	/**
	 * 设置：抓捕老鼠数
	 */
	public void setMousetrapNum(Integer mousetrapNum) {
		this.mousetrapNum = mousetrapNum;
	}
	/**
	 * 获取：抓捕老鼠数
	 */
	public Integer getMousetrapNum() {
		return mousetrapNum;
	}
	/**
	 * 设置：状态
            100：路途中
            200：到达地点
            300：异常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
            100：路途中
            200：到达地点
            300：异常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：状态描述
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	/**
	 * 获取：状态描述
	 */
	public String getStatusDesc() {
		return statusDesc;
	}
	/**
	 * 设置：是否被捕
            0:否
            1:是
	 */
	public void setIsArrested(Integer isArrested) {
		this.isArrested = isArrested;
	}
	/**
	 * 获取：是否被捕
            0:否
            1:是
	 */
	public Integer getIsArrested() {
		return isArrested;
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
	/**
	 * 设置：当前所在地uid
	 */
	public void setAddressUid(String addressUid) {
		this.addressUid = addressUid;
	}
	/**
	 * 获取：当前所在地uid
	 */
	public String getAddressUid() {
		return addressUid;
	}
}
