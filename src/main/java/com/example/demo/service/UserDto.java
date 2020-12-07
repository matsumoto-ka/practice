package com.example.demo.service;

import lombok.Data;

@Data
public class UserDto {
	private int id;

	private String user_name;

	private String user_name_kana;

	private String sex;

	private String age;
	
	private String age_from;
	
	private String age_to;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_name_kana() {
		return user_name_kana;
	}

	public void setUser_name_kana(String user_name_kana) {
		this.user_name_kana = user_name_kana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAge_from() {
		return age_from;
	}

	public void setAge_from(String age_from) {
		this.age_from = age_from;
	}

	public String getAge_to() {
		return age_to;
	}

	public void setAge_to(String age_to) {
		this.age_to = age_to;
	}
}