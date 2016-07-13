package com.emon.services.device;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Device {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="deviceId", nullable=false)
	Integer deviceId;
	@Column(name="manufacturer", nullable=false)
	String manufacturer ;
	
	@Column(name="IEMI", nullable=false)
	String iemi;
	
	String Description;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="registrationDate", insertable=true, updatable=false, nullable=false)
	Date registrationDt;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="lastModified", insertable=true, updatable=true, nullable=false)
	Date lastModified;
	
}
