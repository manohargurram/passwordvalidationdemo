package com.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.AppLauncher;
import com.myapp.service.PasswordValidationService;
import com.myapp.vo.PasswordRequestVO;
import com.myapp.vo.PasswordSuccessResponseVO;

@RestController
@RequestMapping("/password")
public class PasswordValidationController {
	
	private static Logger logger = LoggerFactory.getLogger(PasswordValidationController.class);

	@Autowired private PasswordValidationService passwordValidationService;

	@PostMapping(path = "/validate",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PasswordSuccessResponseVO> validate(@RequestBody PasswordRequestVO passwordRequestVO) {
		PasswordSuccessResponseVO passwordSuccessResponseVO = passwordValidationService.validate(passwordRequestVO);
		return new ResponseEntity<PasswordSuccessResponseVO>(passwordSuccessResponseVO, HttpStatus.OK);
	}
}
