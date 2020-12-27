package com.example.demo.service;

import java.util.List;

import com.lab.app.ketman.mybatis.domain.UserMstWithBLOBs;

public interface UserService {
	// 条件検索
	List<UserMstWithBLOBs> findByConditions(UserDto inDto);

	// 編集したレコードを登録
	int update(UserDto inDto);

	// 選択したレコードを削除
	int delete(UserDto inDto);
	
	// レコードを新規登録
	int register(UserDto inDto);

}
