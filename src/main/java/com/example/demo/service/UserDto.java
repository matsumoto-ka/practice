package com.example.demo.service;

import java.util.List;

import com.lab.app.ketman.mybatis.domain.UserMstWithBLOBs;

import lombok.Data;

@Data
public class UserDto {
	private int id;

	private String user_name;

	private String user_name_kana;
	
	private String tel;
	
	private String postal_code;
	
	private String addr1;
	
	private String addr2;
	
	private String addr3;
	
	private String addr4;
	
	private String addr5;
	
	private String birth_date;

	private String sex;

	private String age;
	
	private String age_from;
	
	private String age_to;
	
	private int limit;
	
	private int offset;
	
	private int total;
	
	private String sortCondition;
	
	private List<UserMstWithBLOBs> userList;
}