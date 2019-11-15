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
public class LoginResponsedto {
	
	private String userName;
	private String message;
	private Integer statusCode;
}
