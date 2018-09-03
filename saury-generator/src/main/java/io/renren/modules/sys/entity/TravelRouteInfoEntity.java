package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 路线记录表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-11 16:44:14
 */
@TableName("travel_route_info")
public class TravelRouteInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 出发地轨迹id
	 */
	private Long parentRouteId;
	/**
	 * 目的地
	 */
	private String name;
	/**
	 * 纬度
	 */
	private Double latitude;
	/**
	 * 经度
	 */
	private Double longitude;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 区县
	 */
	private String area;
	/**
	 * 全景图id
	 */
	private String streetId;
	/**
	 * 地图地区uid
	 */
	private String addressUid;
	/**
	 * 路段距离
	 */
	private Integer distance;
	/**
	 * 路段耗时
	 */
	private Integer duration;
	/**
	 * 创建时间
	 */
	private Date createdTm;
	/**
	 * 更新时间
	 */
	private Date updatedTm;
	/**
	 * 
	 */
	private Long petId;

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
	 * 设置：出发地轨迹id
	 */
	public void setParentRouteId(Long parentRouteId) {
		this.parentRouteId = parentRouteId;
	}
	/**
	 * 获取：出发地轨迹id
	 */
	public Long getParentRouteId() {
		return parentRouteId;
	}
	/**
	 * 设置：目的地
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：目的地
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：区县
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：区县
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：全景图id
	 */
	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}
	/**
	 * 获取：全景图id
	 */
	public String getStreetId() {
		return streetId;
	}
	/**
	 * 设置：地图地区uid
	 */
	public void setAddressUid(String addressUid) {
		this.addressUid = addressUid;
	}
	/**
	 * 获取：地图地区uid
	 */
	public String getAddressUid() {
		return addressUid;
	}
	/**
	 * 设置：路段距离
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	/**
	 * 获取：路段距离
	 */
	public Integer getDistance() {
		return distance;
	}
	/**
	 * 设置：路段耗时
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	/**
	 * 获取：路段耗时
	 */
	public Integer getDuration() {
		return duration;
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
}
