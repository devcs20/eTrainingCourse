package com.hcl.eTraining.service;



import org.springframework.stereotype.Service;

import com.hcl.eTraining.dto.LoginRequestdto;
import com.hcl.eTraining.dto.LoginResponsedto;


/**
 * @author Dev
 *
 */
@Service
public interface LoginService {
	public LoginResponsedto login(LoginRequestdto loginRequestdto) throws Exception;

}
