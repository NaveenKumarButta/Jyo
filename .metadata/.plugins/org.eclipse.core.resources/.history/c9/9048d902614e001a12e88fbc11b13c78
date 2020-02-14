package com.capgemini.storesmanagementsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminTest {

	@ParameterizedTest
	@MethodSource("getbmiTest")
	void getbmiTest(double value,String result) {
	BMI bmi = new BMI();
	String actual = bmi.getbmi(value);
	assertEquals(result, actual);}
	}
