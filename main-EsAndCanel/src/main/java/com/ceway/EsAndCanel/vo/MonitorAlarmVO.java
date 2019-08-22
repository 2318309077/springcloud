package com.ceway.EsAndCanel.vo;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "monitoralarm", type = "monitorAlarms")//加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词
public class MonitorAlarmVO implements Serializable{
      
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String name;
	private String uname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
}
