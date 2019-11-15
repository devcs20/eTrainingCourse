package com.hcl.eTraining.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.eTraining.dto.LoginRequestdto;
import com.hcl.eTraining.dto.LoginResponsedto;
import com.hcl.eTraining.entity.User;
import com.hcl.eTraining.exception.UserException;
import com.hcl.eTraining.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Dev
 *
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public LoginResponsedto login(LoginRequestdto loginRequestdto) throws Exception {
		log.info("Entered into login of LogiServiceImpl");
		Optional<User> loginResponse= userRepository.findByUserMailAndPassword(loginRequestdto.getUserMail(), loginRequestdto.getPassword());

		if(!loginResponse.isPresent()) {
			throw new UserException("Invalid Login");
		}
		
		LoginResponsedto response= new LoginResponsedto();
		response.setUserName(loginResponse.get().getUserName());
		response.setMessage("Login success");
		response.setStatusCode(HttpStatus.OK.value());
		
		return response;
	}

}


