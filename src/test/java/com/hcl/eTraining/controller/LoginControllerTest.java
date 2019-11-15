package com.hcl.eTraining.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.hcl.eTraining.dto.LoginRequestdto;
import com.hcl.eTraining.dto.LoginResponsedto;
import com.hcl.eTraining.entity.User;
import com.hcl.eTraining.service.LoginServiceImpl;




/**
 * @author Dev
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Mock
	LoginServiceImpl loginServiceImpl;
	
	LoginRequestdto loginRequestdto=null;
	User user=null;
	LoginResponsedto loginResponsedto=null;
	
	@Before
	public void setUp() {
	
		loginRequestdto=new LoginRequestdto();
		loginRequestdto.setUserMail("abc@gmail.com");
		loginRequestdto.setPassword("abc");
		
		user=new User();
		user.setUserId(1);
		user.setUserMail("a@gmail.com");
		user.setUserName("ab");
		user.setPhone(222L);
		
		loginResponsedto=new LoginResponsedto();
		loginResponsedto.setUserName(user.getUserName());
		
	}
	
	@Test
	public void testUserLogin() throws Exception {
		
		Mockito.when(loginServiceImpl.login(loginRequestdto)).thenReturn(loginResponsedto);
		LoginResponsedto loginResponsedto1=loginController.login(loginRequestdto);
		assertEquals(user.getUserName(), loginResponsedto1.getUserName());
	}
	
}
