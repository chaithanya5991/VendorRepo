package com.evaluation.model;

public class BeanClass {

	// Instance variables of loginTable
	private int userId;
	private String userName;
	private String password;
	
	// Instance variables of vendorTable
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private String isActive;
	
	// Instance variables of contactTable
	private int contactId;
	private String name;
	private String department;
	private String email;
	private String phone;
	
	// Default Constructor
	public BeanClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getter Methods
	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public int getVendorId() {
		return vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getAddress() {
		return address;
	}

	public String getLocation() {
		return location;
	}

	public String getService() {
		return service;
	}

	public int getPincode() {
		return pincode;
	}

	public String getIsActive() {
		return isActive;
	}

	public int getContactId() {
		return contactId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	// Setter Methods
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// Parametrized constructor using all fields
	public BeanClass(int userId, String userName, String password,
			int vendorId, String vendorName, String address, String location,
			String service, int pincode, String isActive, int contactId,
			String name, String department, String email, String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
		this.contactId = contactId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}
	
	
	
	
}
