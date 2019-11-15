package com.hcl.eTraining.service;



import static org.junit.Assert.assertEquals;

import java.util.Optional;

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
import com.hcl.eTraining.repository.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	
	User user=null;
	LoginRequestdto loginRequestDto = null;
	Optional<User> optUser = null;
	LoginResponsedto loginResponsedto = null;
	
	
	@Before
	public void setUp() throws Exception {
		
		loginRequestDto=new LoginRequestdto();
		user = new User();
		user.setUserId(1);
		user.setUserName("aa");
		user.setUserMail("a@gmail.com");
		user.setPassword("aa");
		user.setPhone(1L);
		
		loginRequestDto.setUserMail("abc@gmail.com");
		loginRequestDto.setPassword("9999");
		
		optUser = Optional.of(user);
		
		loginResponsedto = new LoginResponsedto();
		
		loginResponsedto.setMessage("success");
		loginResponsedto.setStatusCode(200);
		loginResponsedto.setUserName("aa");
		
		
		
	}

	@Test
	public void testLogin() throws Exception {
	
		Mockito.when(userRepository.findByUserMailAndPassword(loginRequestDto.getUserMail(), loginRequestDto.getPassword())).thenReturn(optUser);

		LoginResponsedto actual=loginServiceImpl.login(loginRequestDto);
		
		assertEquals(actual.getUserName(),loginResponsedto.getUserName());
	}

}


