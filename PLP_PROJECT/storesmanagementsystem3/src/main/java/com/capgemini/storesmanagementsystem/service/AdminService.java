package com.capgemini.storesmanagementsystem.service;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public interface AdminService {

public boolean loginAdmin(UserDetailsInfo info);
	
	public boolean addManufacturer(UserDetailsInfo info1);

	public boolean updateManufacturer(UserDetailsInfo info2);
	
	public boolean deleteManufacturer(UserDetailsInfo info3);
	
	public boolean showManufacturer(UserDetailsInfo info4);
	
	


}
