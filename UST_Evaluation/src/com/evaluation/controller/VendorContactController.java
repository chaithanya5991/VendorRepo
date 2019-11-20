package com.evaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.dao.IVendorContactDao;
import com.evaluation.model.BeanClass;



@RestController
public class VendorContactController {

	
	@Autowired
	IVendorContactDao vcDao;
	
	   // Login verification
		@RequestMapping(value = "/login/{uname}/{pass}", method = RequestMethod.GET)
		public BeanClass loginVerification(@PathVariable("uname") String uname,@PathVariable("pass") String pass) {
		
			return vcDao.loginAuthentication(uname, pass);
		}
		
		// View vendor list    
		@RequestMapping(value="/getallvendors",headers="Accept=Application/json",method = RequestMethod.GET)
		public List getAllVendors(@ModelAttribute("objBeanClass") BeanClass objBeanClass) {
			
			List vendorList=vcDao.viewVendorList();
			return vendorList;
		}
		
		// Inserting and Updating vendor details
		@RequestMapping(value = "/saveDetails", method = { RequestMethod.POST,
				RequestMethod.PUT })
		public void saveDetails(@RequestBody BeanClass objBeanClass) {
			if (objBeanClass.getVendorId() != 0) {
				vcDao.updateVendorDetails(objBeanClass);
			} else {
				vcDao.insertVendorDetails(objBeanClass);
				
			}
		}

		//Getting vendor By id
		@RequestMapping(value = "/getVendorById/{vendorId}", method = RequestMethod.GET, produces = "application/json")
		public BeanClass getVendorById(@ModelAttribute("objBeanClass") BeanClass objBeanClass,@PathVariable("vendorId") int vendorId) {
			List list1 = vcDao.getVendorById(vendorId);
			objBeanClass = (BeanClass) list1.get(0);
			return objBeanClass;
		}
		
		//search by optional parameters
		@RequestMapping(value="/vendorsearch/{searchString}",headers="Accept=Application/json",method = RequestMethod.GET)
		public List vendorDetails(@PathVariable("searchString")String searchString) {
			
			
			List vendorList=vcDao.getDetailsSearch(searchString);
			return vendorList;
		}
	
		// Disabling a vendor
		@RequestMapping(value = "/disable", method = RequestMethod.PUT)
		public void disable(@RequestBody BeanClass objBeanClass) {
			vcDao.disableVendor(objBeanClass);
		}
}
