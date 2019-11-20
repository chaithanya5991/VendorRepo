package com.evaluation.dao;

import java.util.List;

import com.evaluation.model.BeanClass;

public interface IVendorContactDao {

	// Authenticating user with username and password
	public abstract BeanClass loginAuthentication(String uname, String pass);

	// View Vendor list
	public abstract List<BeanClass> viewVendorList();

	// Inserting into vendor Table
	public abstract int insertVendorDetails(BeanClass objBeanClass);

	// Inserting into Contact Table
	public abstract int insertContactDetails(BeanClass objBeanClass);

	// Updating vendor details
	public abstract int updateVendorDetails(BeanClass objBeanClass);

	// Getting vendor by id
	public abstract List<BeanClass> getVendorById(int vendorId);

	// Getting details while searching(using name,location,service)
	public abstract List getDetailsSearch(String searchString);

	// Disable a vendor using id
	public abstract int disableVendor(BeanClass objBeanClass);

}