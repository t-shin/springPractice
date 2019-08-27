package com.example.demo.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(groups = IValidGroup1.class)
	@Email(groups = IValidGroup2.class)
	private String userId;
	
	@NotBlank(groups = IValidGroup1.class)
	@Length(min=4, max = 100, groups = IValidGroup2.class)
	@Pattern(regexp = "^[a-z-A-Z0-9]+$", groups = IValidGroup3.class)
	private String password;
	
	@NotBlank(groups = IValidGroup1.class)
	private String userName;
	
	@NotNull(groups = IValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	
	@Min(value=20, groups = IValidGroup2.class)
	@Max(value=100, groups = IValidGroup2.class)
	private int age;
	
	@AssertFalse(groups = IValidGroup2.class)
	private boolean marriage;
}
