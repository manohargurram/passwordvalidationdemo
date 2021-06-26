package com.myapp.service;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myapp.exception.ValidationException;
import com.myapp.vo.PasswordRequestVO;
import com.myapp.vo.PasswordSuccessResponseVO;


@Service
public class PasswordValidationService {
	
	private static Logger logger = LoggerFactory.getLogger(PasswordValidationService.class);

	public PasswordSuccessResponseVO validate(PasswordRequestVO passwordRequestVO) {
		String password = passwordRequestVO.getPassword();
		logger.info("password received for validation:{}",password);
		
		if(password==null) {
			ValidationException validationException = new ValidationException();
			validationException.add("password should not be null", "password", null);
			throw validationException;
		}
		//testing for internal server error. enable to test this scenario
//		if(password.equalsIgnoreCase("testinternalexception")) {
//			throw new RuntimeException();
//		}
		ValidationException exception = new ValidationException();
		if(password.length()<=8) {
			exception.add("password should be larger than 8 chars", "password", password);
		}
		if(!Pattern.compile("[A-Z]").matcher(password).find()) {
			exception.add("password should have one uppercase letter at least", "password", password);
		}
		boolean isLowerCaseValidationFailed=false;
		if(!Pattern.compile("[a-z]").matcher(password).find()) {
			exception.add("password should have one lowercase letter at least", "password", password);
			isLowerCaseValidationFailed=true;
		}
		if(!Pattern.compile("[0-9]").matcher(password).find()) {
			exception.add("password should have one number at least", "password", password);
		}

		if(isLowerCaseValidationFailed || exception.getErrorsList().size()>1) {
			throw exception;
		}

		PasswordSuccessResponseVO passwordSuccessResponseVO = new PasswordSuccessResponseVO("valid password");
		return passwordSuccessResponseVO;
	}
}
