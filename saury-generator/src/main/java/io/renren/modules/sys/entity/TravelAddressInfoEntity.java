package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 地点记录表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-11 16:44:14
 */
@TableName("travel_address_info")
public class TravelAddressInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 地图地区uid
	 */
	@TableId
	private String addressUid;
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
	 * 创建时间
	 */
	private Date createdTm;
	/**
	 * 更新时间
	 */
	private Date updatedTm;
	/**
	 * 景点图片链接
	 */
	private String url;

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
	 * 设置：景点图片链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：景点图片链接
	 */
	public String getUrl() {
		return url;
	}
}
