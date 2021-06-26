package com.myapp.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapp.vo.PasswordRequestVO;
import com.myapp.vo.PasswordSuccessResponseVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidationServiceTest {
	
	@Autowired private PasswordValidationService passwordValidationService;

	@Test
	public void validateCorrectPassword() {
		PasswordRequestVO passwordRequestVO = new PasswordRequestVO("1aA222222222");
		PasswordSuccessResponseVO responseVO = passwordValidationService.validate(passwordRequestVO);
		assertEquals(new PasswordSuccessResponseVO("valid password"), responseVO);
	}

}
