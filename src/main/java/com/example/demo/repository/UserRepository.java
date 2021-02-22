package com.example.demo.repository;

import java.util.List;

import com.lab.app.ketman.mybatis.domain.UserMstExample;
import com.lab.app.ketman.mybatis.domain.UserMstWithBLOBs;

public interface UserRepository {
	// 検索結果カウント
	public long countByExample(UserMstExample example);
	
	// 条件検索
	public List<UserMstWithBLOBs> findByConditions(UserMstExample example);
	
	// ID検索
	public UserMstWithBLOBs findById(int id);

	// レコードを更新
	public int updateRecord(UserMstWithBLOBs record, UserMstExample example);

	// レコードを削除
	public int deleteRecord(int id);

	// レコードを追加
	public int registerRecord(UserMstWithBLOBs record);

}
