package com.example.demo;

import java.util.List;

public interface UserRepository{
	// 条件検索
	public List<UserEntity> findByConditions(UserEntity inUserENtity);
	
	// レコードを更新
	public int updateRecord(UserEntity inUserEntity);
	
	// レコードを削除
	public int deleteRecord(UserEntity inUserEntity);
	
	// レコードを追加
	public int registerRecord(UserEntity inUserEntity);

}
