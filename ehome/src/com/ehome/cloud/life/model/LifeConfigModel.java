package com.ehome.cloud.life.model;

import java.io.Serializable;
import java.util.Date;

import com.ehome.core.annotation.CodeField;
import com.ehome.core.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LifeConfigModel extends BaseEntity implements Serializable {

	/**
	 * 服务管理实体类
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String icon;// 图标
	private String lifeName;// 服务名称
	private String url;// 网址
	@CodeField(code = "CODE_ISINDEX", renderField = "isIndexName")
	private Integer isIndex;// 是否首页
	private String lifeDept;// 服务提供部门
	private Integer sort;// 排序
	@CodeField(code = "CODE_STATUS", renderField = "statusName")
	private Integer status;// 状态
	private String remark;// 备注，描述
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	private Integer parentId; // 父id
	private Integer pv;// 'PV(该服务项某时间段内访问量)'
	private Integer appPv; // 'APP总PV (APP某时间段内总的访问量)'
	private String pvPercent; // 'PV占的百分比(PV／APP总PV)'
	private Integer uv; // 'UV(该服务项某时间段内独立访客)'
	private Integer appUv; // 'APP总UV(APP某时间段内总的独立访客)'

	public String getLifeName() {
		return lifeName;
	}

	public void setLifeName(String lifeName) {
		this.lifeName = lifeName;
	}

	private String uvPercent; // 'UV占的百分比(UV／APP总UV)'
	private Integer lifeConfigId; // '对应e_life_config表id'

	private String statusName;
	private String isIndexName;

	private Integer pid; // 父id
	private String areaName;// 地市名称

	private Integer provinceId;
	private Integer cityId;
	private String provinceName;
	private String cityName;
	private Integer unloadId;

	public Integer getUnloadId() {
		return unloadId;
	}

	public void setUnloadId(Integer unloadId) {
		this.unloadId = unloadId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getIsIndexName() {
		return isIndexName;
	}

	public void setIsIndexName(String isIndexName) {
		this.isIndexName = isIndexName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public Integer getAppPv() {
		return appPv;
	}

	public void setAppPv(Integer appPv) {
		this.appPv = appPv;
	}

	public String getPvPercent() {
		return pvPercent;
	}

	public void setPvPercent(String pvPercent) {
		this.pvPercent = pvPercent;
	}

	public Integer getUv() {
		return uv;
	}

	public void setUv(Integer uv) {
		this.uv = uv;
	}

	public Integer getAppUv() {
		return appUv;
	}

	public void setAppUv(Integer appUv) {
		this.appUv = appUv;
	}

	public String getUvPercent() {
		return uvPercent;
	}

	public void setUvPercent(String uvPercent) {
		this.uvPercent = uvPercent;
	}

	public Integer getLifeConfigId() {
		return lifeConfigId;
	}

	public void setLifeConfigId(Integer lifeConfigId) {
		this.lifeConfigId = lifeConfigId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(Integer isIndex) {
		this.isIndex = isIndex;
	}

	public String getLifeDept() {
		return lifeDept;
	}

	public void setLifeDept(String lifeDept) {
		this.lifeDept = lifeDept;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
