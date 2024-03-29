package com.capgemini.storesmanagementsystem;

import org.junit.jupiter.api.Test;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.service.AdminServiceImpl;

class AdminServiceImplTest {
	AdminServiceImpl a1 = new AdminServiceImpl();

	@Test
	void test() {
		a1.loginAdmin("pra12chi", "Pr", "abc");
	}

	@Test
	void test1() {
		a1.addManufacturer(new UserDetailsInfo("181", "Riti", "Ru@gmail.com", "Ritika@1", "Baihar", "dealer"));
	}

	@Test
	void test2() {
		a1.updateManufacturer("127", new UserDetailsInfo("161", "Sina", "Si@gmail.com", "Sina@134", "Nagpur", "admin"));
	}

	@Test
	void test3() {
		a1.deleteManufacturer("129");
	}

}
