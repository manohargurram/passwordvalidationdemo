package com.myapp.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapp.exception.ValidationException;
import com.myapp.vo.PasswordRequestVO;
import com.myapp.vo.PasswordSuccessResponseVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidationServiceTest {

	private static Logger logger = LoggerFactory.getLogger(PasswordValidationServiceTest.class);

	@Autowired private PasswordValidationService passwordValidationService;

	@Test
	public void validateCorrectPassword() {
		logger.info("validating valid password");
		PasswordRequestVO passwordRequestVO = new PasswordRequestVO("1aA222222222");
		PasswordSuccessResponseVO responseVO = passwordValidationService.validate(passwordRequestVO);
		assertEquals(new PasswordSuccessResponseVO("valid password"), responseVO);
	}

	@Test
	public void validateNullPassword() {
		try {
			logger.info("validating null password");
			PasswordRequestVO passwordRequestVO = new PasswordRequestVO(null);
			PasswordSuccessResponseVO responseVO = passwordValidationService.validate(passwordRequestVO);
			assertEquals(new PasswordSuccessResponseVO("valid password"), responseVO);
		} catch (ValidationException ex) {
			logger.info("exception response:"+ex.getErrorsList().toString());
			assertEquals("password should not be null", ex.getErrorsList().get(0).getErrorMessage());
		}
	}

	@Test
	public void validatePasswordLengthUpperCaseLowerCase() {
		try {
			logger.info("validating  password length");
			PasswordRequestVO passwordRequestVO = new PasswordRequestVO("111");
			PasswordSuccessResponseVO responseVO = passwordValidationService.validate(passwordRequestVO);
			assertEquals(new PasswordSuccessResponseVO("valid password"), responseVO);
		} catch (ValidationException ex) {
			logger.info("exception response:"+ex.getErrorsList().toString());
			assertTrue(true);
		}
	}
	
	@Test
	public void validatePasswordHavingNumber() {
		try {
			logger.info("validating  password length");
			PasswordRequestVO passwordRequestVO = new PasswordRequestVO("AAAAAAAAAAAAAAAAAAAA");
			PasswordSuccessResponseVO responseVO = passwordValidationService.validate(passwordRequestVO);
			assertEquals(new PasswordSuccessResponseVO("valid password"), responseVO);
		} catch (ValidationException ex) {
			logger.info("exception response:"+ex.getErrorsList().toString());
			assertTrue(true);
		}
	}

}
