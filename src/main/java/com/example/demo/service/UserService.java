package com.example.demo.service;

public interface UserService {
	// 条件検索
	UserDto findByConditions(UserDto inDto);

	// 条件検索
	UserDto findById(UserDto inDto);

	// 編集したレコードを登録
	int update(UserDto inDto);

	// 選択したレコードを削除
	int delete(UserDto inDto);

	// レコードを新規登録
	int register(UserDto inDto);

}
