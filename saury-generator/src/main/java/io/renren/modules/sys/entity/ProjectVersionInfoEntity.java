package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目版本信息
 * 
 * @author 
 * @email 
 * @date 2018-09-04 17:31:37
 */
@TableName("project_version_info")
public class ProjectVersionInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long versionId;
	/**
	 * 
	 */
	private Long projectId;
	/**
	 * 
	 */
	private String versionCode;
	/**
	 * 
	 */
	private String descript;
	/**
	 * 
	 */
	private String path;
	/**
	 * 是否删除  -1：已删除  0：正常
	 */
	private Integer delFlag;
	/**
	 * 
	 */
	private Date expiredTm;
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
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	/**
	 * 获取：
	 */
	public Long getVersionId() {
		return versionId;
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
	 * 设置：
	 */
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	/**
	 * 获取：
	 */
	public String getVersionCode() {
		return versionCode;
	}
	/**
	 * 设置：
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}
	/**
	 * 获取：
	 */
	public String getDescript() {
		return descript;
	}
	/**
	 * 设置：
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：是否删除  -1：已删除  0：正常
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：
	 */
	public void setExpiredTm(Date expiredTm) {
		this.expiredTm = expiredTm;
	}
	/**
	 * 获取：
	 */
	public Date getExpiredTm() {
		return expiredTm;
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
