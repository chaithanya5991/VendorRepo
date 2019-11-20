package com.evaluation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.evaluation.model.BeanClass;

public class VendorContactDao implements IVendorContactDao {

	// JDBC template
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	/* (non-Javadoc)
	 * @see com.evaluation.dao.IVendorContactDao#loginAuthentication(java.lang.String, java.lang.String)
	 */
	// Authenticating user with username and password
	@Override
	public BeanClass loginAuthentication(String uname, String pass) {
		
		BeanClass objBeanClass= new BeanClass();
		String sql = "select userId,userName,password from loginTable where userName = ? and password=? ";
		objBeanClass = template.queryForObject(sql,new Object[] {uname,pass}, 
				new BeanPropertyRowMapper<BeanClass>(BeanClass.class));
		return objBeanClass;

	}

	
		/* (non-Javadoc)
		 * @see com.evaluation.dao.IVendorContactDao#viewVendorList()
		 */
	// View Vendor list
		@Override
		public List<BeanClass> viewVendorList() {
			return template.query("select vendorTable.vendorId,vendorName,address,location,service,pincode,name,department,email,phone from vendorTable join contactTable on vendorTable.vendorId=contactTable.vendorId where isActive='yes' order by vendorTable.vendorId",
					new RowMapper<BeanClass>() 
			{
				public BeanClass mapRow(ResultSet rs, int row) throws SQLException {
					BeanClass objBeanClass = new BeanClass();

					objBeanClass.setVendorId(rs.getInt(1));
					objBeanClass.setVendorName(rs.getString(2));
					objBeanClass.setAddress(rs.getString(3));
					objBeanClass.setLocation(rs.getString(4));
					objBeanClass.setService(rs.getString(5));
					objBeanClass.setPincode(rs.getInt(6));
					//objBeanClass.setContactId(rs.getInt(6));
					objBeanClass.setName(rs.getString(7));
					objBeanClass.setDepartment(rs.getString(8));
					objBeanClass.setEmail(rs.getString(9));
					objBeanClass.setPhone(rs.getString(10));
		
				return objBeanClass;
			}
		});
		}
		
		
		/* (non-Javadoc)
		 * @see com.evaluation.dao.IVendorContactDao#insertVendorDetails(com.evaluation.model.BeanClass)
		 */
		// Inserting into vendor Table
		@Override
		public int insertVendorDetails(BeanClass objBeanClass) {

			String sql = "insert into vendorTable(vendorName,address,location,service,pincode,isActive) values('"+objBeanClass.getVendorName()+"','"+ objBeanClass.getAddress()+ "','"+ objBeanClass.getLocation()+ "','"+ objBeanClass.getService()+ "',"+objBeanClass.getPincode()+",'yes')";

			if (template.update(sql) != 0) {

					return insertContactDetails(objBeanClass);

			} else {
				return 0;
			}

		}
		
		
		/* (non-Javadoc)
		 * @see com.evaluation.dao.IVendorContactDao#insertContactDetails(com.evaluation.model.BeanClass)
		 */
		// Inserting into Contact Table
		@Override
		public int insertContactDetails(BeanClass objBeanClass) {

			String sql = "select max(vendorId) from vendorTable";
			int vendorId = template.queryForObject(sql, Integer.class);

			String sql2 = "insert into contactTable(vendorId,name,department,email,phone) values(?,?,?,?,?)";
			return template.update(sql2, new Object[] { vendorId, objBeanClass.getName(),
					objBeanClass.getDepartment(), objBeanClass.getEmail(), objBeanClass.getPhone()});
		}

		
		/* (non-Javadoc)
		 * @see com.evaluation.dao.IVendorContactDao#updateVendorDetails(com.evaluation.model.BeanClass)
		 */
		// Updating vendor details
		@Override
		public int updateVendorDetails(BeanClass objBeanClass) {

			String sql = "update vendorTable set vendorName='"+objBeanClass.getVendorName()+"',address='"+objBeanClass.getAddress()+"',location='"+ objBeanClass.getLocation()+"',service='"+objBeanClass.getService()+"',pincode="+objBeanClass.getPincode()+" where vendorId= "+objBeanClass.getVendorId()+"";
			template.update(sql, new Object[] {});

			String sql1 = "update contactTable set name='"+objBeanClass.getName()+ "',department='"+objBeanClass.getDepartment()+"',email='"+objBeanClass.getEmail()+"',phone="+objBeanClass.getPhone()+" where vendorId="+objBeanClass.getVendorId()+"";
			template.update(sql1, new Object[] {});

			return template.update(sql1, new Object[] {});

		}

		
		/* (non-Javadoc)
		 * @see com.evaluation.dao.IVendorContactDao#getVendorById(int)
		 */
		// Getting vendor by id
		@Override
		public List<BeanClass> getVendorById(int vendorId) {
			return template.query("select vendorTable.vendorId,vendorName,address,location,service,pincode,name,department,email,phone from vendorTable join contactTable on vendorTable.vendorId=contactTable.vendorId where vendorTable.vendorId = "+vendorId+" and isActive='yes'", 
							new RowMapper<BeanClass>() 
					{
						public BeanClass mapRow(ResultSet rs, int row) throws SQLException {
							
							BeanClass objBeanClass = new BeanClass();
							
							objBeanClass.setVendorId(rs.getInt(1));
							objBeanClass.setVendorName(rs.getString(2));
							objBeanClass.setAddress(rs.getString(3));
							objBeanClass.setLocation(rs.getString(4));
							objBeanClass.setService(rs.getString(5));
							objBeanClass.setPincode(rs.getInt(6));
							//objBeanClass.setContactId(rs.getInt(6));
							objBeanClass.setName(rs.getString(7));
							objBeanClass.setDepartment(rs.getString(8));
							objBeanClass.setEmail(rs.getString(9));
							objBeanClass.setPhone(rs.getString(10));

							return objBeanClass;
						}
					});

		}
		
		
		/* (non-Javadoc)
		 * @see com.evaluation.dao.IVendorContactDao#getDetailsSearch(java.lang.String)
		 */
		// Getting details while searching(using name,location,service)
		@Override
		public List getDetailsSearch(String searchString)
		{
			
			return template.query("select vendorTable.vendorId,vendorName,address,location,service,pincode,name,department,email,phone from vendorTable join contactTable on vendorTable.vendorId=contactTable.vendorId where name like '"+ searchString +"%' or location like'" + searchString + "%' or service like '"+searchString+"%'",
					new RowMapper<BeanClass>() 
			
			{
				public BeanClass mapRow(ResultSet rs, int row) throws SQLException {
					BeanClass objBeanClass = new BeanClass();

					objBeanClass.setVendorId(rs.getInt(1));
					objBeanClass.setVendorName(rs.getString(2));
					objBeanClass.setAddress(rs.getString(3));
					objBeanClass.setLocation(rs.getString(4));
					objBeanClass.setService(rs.getString(5));
					objBeanClass.setPincode(rs.getInt(6));
					//objBeanClass.setContactId(rs.getInt(6));
					objBeanClass.setName(rs.getString(7));
					objBeanClass.setDepartment(rs.getString(8));
					objBeanClass.setEmail(rs.getString(9));
					objBeanClass.setPhone(rs.getString(10));
					
					return objBeanClass;
			}
		});
		}
		

		
		/* (non-Javadoc)
		 * @see com.evaluation.dao.IVendorContactDao#disableVendor(com.evaluation.model.BeanClass)
		 */
		// Disable a vendor using id
		@Override
		public int disableVendor(BeanClass objBeanClass) {
		String sql = "update vendorTable set isActive='no' where vendorId=?";
		return template.update(sql, new Object[] { objBeanClass.getVendorId() });

		}
		
}
