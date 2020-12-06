package com.example.demo;

import java.util.List;

public interface UserService {
	// 条件検索
	List<UserDto> findByConditions(UserDto inDto);

	// 編集したレコードを登録
	int update(UserDto inDto);

	// 選択したレコードを削除
	int delete(UserDto inDto);
	
	// レコードを新規登録
	int register(UserDto inDto);

}
