package com.project.management.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="content")
	private String content;
	@Column(name="msg_from")
	private Integer msg_from;
	@Column(name="msg_to")
	private Integer msg_to;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date created_date;
	@Column(name="delete_flag")
	private String delete_flag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getMsg_from() {
		return msg_from;
	}
	public void setMsg_from(Integer msg_from) {
		this.msg_from = msg_from;
	}
	public Integer getMsg_to() {
		return msg_to;
	}
	public void setMsg_to(Integer msg_to) {
		this.msg_to = msg_to;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	
}
