package com.app.demo.springboot.dto;

import java.util.List;

public class GenericRespon<T> {	
	private String status;
	private String maessage;
	private List<T> dataList;
	private T data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMaessage() {
		return maessage;
	}
	public void setMaessage(String maessage) {
		this.maessage = maessage;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<SpringBoot> obj) {
		this.dataList = (List<T>) obj;
	}
	public T getData() {
		return data;
	}
	public void setData(SpringBoot user) {
		this.data = (T) user;
	}
	
		
	}

