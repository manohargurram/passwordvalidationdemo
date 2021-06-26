package com.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myapp.vo.PasswordRequestVO;
import com.myapp.vo.PasswordSuccessResponseVO;


@Service
public class PasswordValidationService {
	
	private static Logger logger = LoggerFactory.getLogger(PasswordValidationService.class);

	public PasswordSuccessResponseVO validate(PasswordRequestVO passwordRequestVO) {
		String password = passwordRequestVO.getPassword();
		logger.info("password received for validation:{}",password);

		PasswordSuccessResponseVO passwordSuccessResponseVO = new PasswordSuccessResponseVO("valid password");
		return passwordSuccessResponseVO;
	}
}
