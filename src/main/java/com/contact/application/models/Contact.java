package com.contact.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact1")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;
	private Long phoneNumber;
	private String contactName;
	private String img;
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Contact(Long cId, Long phoneNumber, String contactName, String img) {
		super();
		this.cId = cId;
		this.phoneNumber = phoneNumber;
		this.contactName = contactName;
		this.img = img;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
	
	