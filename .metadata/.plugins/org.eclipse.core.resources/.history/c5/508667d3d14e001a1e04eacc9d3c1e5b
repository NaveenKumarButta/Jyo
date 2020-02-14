package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dao.AdminDaoImpl;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.validation.PasswordValidate;

public class AdminServiceImpl implements AdminService{
	 AdminDaoImpl dao =new AdminDaoImpl();

		@Override
		public boolean addManufacturer(UserDetailsInfo user) {
			return dao.addManufacturer(user);
		}

		@Override
		public boolean updateManufacturer(String userId, UserDetailsInfo user) {
			return dao.updateManufacturer(userId, user);
		}

		@Override
		public boolean deleteManufacturer(String userId) {
			return dao.deleteManufacturer(userId);
					
		}

		@Override
		public List<String> viewAllManufacturer() {
			return dao.viewAllManufacturer();
		}

		public boolean loginAdmin(String name,String password,String id) {
			 boolean result=dao.loginAdmin(name, password, id);
			 return result;
		 }

		@Override
		public boolean passwordValidate(String password) {
			boolean flag=PasswordValidate.validPassword(password);
			return flag;
		
		}


		

		}
		
