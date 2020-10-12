package com.william.model;

import java.security.Timestamp;

public class AbstractModel {
	private Long id;
	private Timestamp createDate;
	private Timestamp modifieDate;
	private String createBy;
	private String modifieBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifieDate() {
		return modifieDate;
	}

	public void setModifieDate(Timestamp modifieDate) {
		this.modifieDate = modifieDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifieBy() {
		return modifieBy;
	}

	public void setModifieBy(String modifieBy) {
		this.modifieBy = modifieBy;
	}
	
}
