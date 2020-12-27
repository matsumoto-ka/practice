package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lab.app.ketman.mybatis.domain.UserMstExample;
import com.lab.app.ketman.mybatis.domain.UserMstWithBLOBs;
import com.lab.app.ketman.mybatis.mapper.UserMstMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	UserMstMapper mapper;

	@Override
	public List<UserMstWithBLOBs> findByConditions(UserMstExample example) {
		// 検索実行
		List<UserMstWithBLOBs> userMstList = mapper.selectByExampleWithBLOBs(example);

		return userMstList;
	}

	@Override
	public int updateRecord(UserMstWithBLOBs record, UserMstExample example) {
		// 更新実行
		int resultCode = mapper.updateByExampleWithBLOBs(record, example);

		return resultCode;
	}

	@Override
	public int deleteRecord(int id) {
		// 削除実行
		int resultCode = mapper.deleteByPrimaryKey(id);

		return resultCode;
	}

	@Override
	public int registerRecord(UserMstWithBLOBs record) {
		// 登録実行
		int resultCode = mapper.insertSelective(record);

		return resultCode;
	}
}
