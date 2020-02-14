package com.capgemini.storesmanagementsystem.dao;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public interface AdminDao {
	
	public boolean loginAdmin(UserDetailsInfo info);
	
	public boolean addManufacturer(UserDetailsInfo info);

	public boolean updateManufacturer(UserDetailsInfo info);
	
	public boolean deleteManufacturer(UserDetailsInfo info);
	
	public boolean showManufacturer(UserDetailsInfo info);

	

	

	

    
}
