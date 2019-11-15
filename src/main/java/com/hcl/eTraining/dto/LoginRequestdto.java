package com.hcl.eTraining.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Dev
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginRequestdto {
	
	private String userMail;
	private String password;
}