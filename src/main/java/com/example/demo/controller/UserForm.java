package com.example.demo.controller;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserForm {

	@Pattern(regexp = "^[0-9]*$", message = "IDは半角数字で入力してください")
	private String id;

	private String user_name;

	private String user_name_kana;

	private String sex;
	
	private String tel;
	
	private String postal_code;
	
	private String addr1;
	
	private String addr2;
	
	private String addr3;
	
	private String addr4;
	
	private String addr5;
	
	private String birth_date;

	@Pattern(regexp = "^[0-9]*$", message = "年齢は半角数字で入力してください")
	private String age;
	
	@Pattern(regexp = "^[0-9]*$", message = "年齢（FROM）は半角数字で入力してください")
	private String age_from;
	
	@Pattern(regexp = "^[0-9]*$", message = "年齢（TO）は半角数字で入力してください")
	private String age_to;
}