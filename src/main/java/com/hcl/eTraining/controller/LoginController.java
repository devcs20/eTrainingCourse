package com.hcl.eTraining.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.eTraining.dto.LoginRequestdto;
import com.hcl.eTraining.dto.LoginResponsedto;
import com.hcl.eTraining.service.LoginService;



/**
 * @author Dev
 *
 */
@RestController
@RequestMapping("/eCourse")
public class LoginController {

private static final Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/login")
	public LoginResponsedto login(@RequestBody LoginRequestdto  loginRequestdto) throws Exception{
		logger.info("Inside Login method of Login Controller");	
		return  loginService.login(loginRequestdto);		
	}
}
