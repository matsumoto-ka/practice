package com.example.demo.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class RegisterForm {

	@Pattern(regexp = "^[0-9]*$", message = "IDは半角数字で入力してください")
	private String id;
	
	@NotBlank(message = "ユーザー名を入力してください")
	private String user_name;

	@NotBlank(message = "ユーザー名（かな）を入力してください")
	private String user_name_kana;

	@NotBlank(message = "性別を入力してください")
	private String sex;
	
	@NotBlank(message = "電話番号を入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "電話番号は半角数字で入力してください")
	private String tel;
	
	@NotBlank(message = "郵便番号を入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "郵便番号は半角数字で入力してください")
	private String postal_code;
	
	@NotBlank(message = "都道府県を入力してください")
	private String addr1;
	
	@NotBlank(message = "市区町村を入力してください")
	private String addr2;
	
	@NotBlank(message = "丁目を入力してください")
	private String addr3;
	
	@NotBlank(message = "番地を入力してください")
	private String addr4;
	
	private String addr5;
	
	private String birth_date;
	
	@NotBlank(message = "誕生日ー年を入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "誕生日ー年は半角数字で入力してください")
	private String birth_year;
	
	@NotBlank(message = "誕生日ー月を入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "誕生日ー月は半角数字で入力してください")
	private String birth_month;
	
	@NotBlank(message = "誕生日ー日を入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "誕生日ー日は半角数字で入力してください")
	private String birth_day;

	@NotBlank(message = "年齢を入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "年齢は半角数字で入力してください")
	@Min(0)
	@Max(130)
	private String age;
}