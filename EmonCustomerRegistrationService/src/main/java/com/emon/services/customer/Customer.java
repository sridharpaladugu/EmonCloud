package com.emon.services.customer;


import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerId", nullable=false)
	Integer customerId;
	
	@Column(name="firstName", nullable=false)
	String firstName;
	
	@Column(name="lastName", nullable=false)
	String lastName;
	
	@Column(name="primaryPhoneNumber", nullable=false)
	String primaryPhoneNumber;
	
	@Column(name="secondaryPhoneNumber", nullable=true)
	String secondaryPhoneNumber;
	
	@Column(name="email", nullable=true)
	String email;
	
	@Column(name="addressLine1", nullable=false)
	String addressLine1 ;
	
	@Column(name="city", nullable=false)
	String city ; 
	
	@Column(name="state", nullable=false)
	String state ;
	
	@Column(name="zip", nullable=false)
	String zip ;
	
	@Column(name="emgergencyContactFirstname", nullable=false)
	String emgergencyContactFirstname;
	
	@Column(name="emgergencyContactLastname", nullable=false)
	String emgergencyContactLastname;
	
	@Column(name="emgergencyContactPhoneNumber", nullable=false)
	String emgergencyContactPhoneNumber;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="registrationDate", insertable=true, updatable=false, nullable=false)
	Date registrationDt;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="lastModified", insertable=true, updatable=true, nullable=false)
	Date lastModified;
	
	@Version
	@Column(name="version", nullable=false)
	int version;
	
	@PrePersist
	void onCreate(){
		Date dt = new java.util.Date();
		this.setRegistrationDt(dt);
		this.setLastModified(dt);
	}
	@PreUpdate
	void  onPersist() {
		this.setLastModified(new Timestamp((new java.util.Date()).getTime()));
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}
	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}
	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}
	public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
		this.secondaryPhoneNumber = secondaryPhoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmgergencyContactFirstname() {
		return emgergencyContactFirstname;
	}
	public void setEmgergencyContactFirstname(String emgergencyContactFirstname) {
		this.emgergencyContactFirstname = emgergencyContactFirstname;
	}
	public String getEmgergencyContactLastname() {
		return emgergencyContactLastname;
	}
	public void setEmgergencyContactLastname(String emgergencyContactLastname) {
		this.emgergencyContactLastname = emgergencyContactLastname;
	}
	public String getEmgergencyContactPhoneNumber() {
		return emgergencyContactPhoneNumber;
	}
	public void setEmgergencyContactPhoneNumber(String emgergencyContactPhoneNumber) {
		this.emgergencyContactPhoneNumber = emgergencyContactPhoneNumber;
	}
	public Date getRegistrationDt() {
		return registrationDt;
	}
	public void setRegistrationDt(Date registrationDt) {
		this.registrationDt = registrationDt;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	
	
	
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", primaryPhoneNumber="
				+ primaryPhoneNumber + ", secondaryPhoneNumber=" + secondaryPhoneNumber + ", email=" + email
				+ ", addressLine1=" + addressLine1 + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", emgergencyContactFirstname=" + emgergencyContactFirstname + ", emgergencyContactLastname="
				+ emgergencyContactLastname + ", emgergencyContactPhoneNumber=" + emgergencyContactPhoneNumber
				+ ", registrationDt=" + registrationDt + ", lastModified=" + lastModified + ", version=" + version
				+ "]";
	}
	
}
