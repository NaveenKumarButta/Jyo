package com.capgemini.storesmanagementsystem.service;

import com.capgemini.storesmanagementsystem.dao.AdminDao;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.factory.FactoryDetails;

public class AdminServiceImpl implements AdminService{

	AdminDao adao = FactoryDetails.objectAdminDao();
	
  public boolean loginAdmin(UserDetailsInfo info) {
	
			return adao.loginAdmin(info);
  }
	
   @Override
	public boolean addManufacturer(UserDetailsInfo info1) {
		return adao.addManufacturer(info1);
		
	}

	@Override
	public boolean updateManufacturer(UserDetailsInfo info2) {
		return adao.updateManufacturer(info2);

}

	@Override
	public boolean deleteManufacturer(UserDetailsInfo info3) {
		return adao.deleteManufacturer(info3);
		
	}

	@Override
	public boolean showManufacturer(UserDetailsInfo info4) {
		return adao.showManufacturer(info4);
		
	}
}
