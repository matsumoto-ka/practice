package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserEntity> findByConditions(UserEntity inUserEntity) {
		try {
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT");
			sql.append(" *");
			sql.append(" FROM");
			sql.append(" user_mst");
			sql.append(" WHERE");
			sql.append(" 1 = 1");
			if (!(inUserEntity.getId() == 0)) {
				sql.append(" AND");
				sql.append(" id = ");
				sql.append(inUserEntity.getId());
			}
			if (!(inUserEntity.getSex() == null) && !(inUserEntity.getSex().isEmpty())) {
				sql.append(" AND");
				sql.append(" sex = ");
				sql.append("'" + inUserEntity.getSex() + "'");
			}
			if (!(inUserEntity.getAge_from() == null) && !(inUserEntity.getAge_from().isEmpty())) {
				sql.append(" AND");
				sql.append(" age >= ");
				sql.append(inUserEntity.getAge_from());
			}
			if (!(inUserEntity.getAge_to() == null) && !(inUserEntity.getAge_to().isEmpty())) {
				sql.append(" AND");
				sql.append(" age <= ");
				sql.append(inUserEntity.getAge_to());
			}
			sql.append(" ORDER BY");
			sql.append(" id");
			sql.append(";");

			List<UserEntity> outUserList = jdbcTemplate.query(sql.toString(),
					new BeanPropertyRowMapper(UserEntity.class));

			return outUserList;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int updateRecord(UserEntity inUserEntity) {
		try {

			int resultCode = jdbcTemplate.update("update user_mst set user_name = ?, age = ?, sex = ? where id = ?",
					inUserEntity.getUser_name(), inUserEntity.getAge(), inUserEntity.getSex(), inUserEntity.getId());

			return resultCode;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int deleteRecord(UserEntity inUserEntity) {
		try {
			int resultCode = jdbcTemplate.update("delete from user_mst where id = ?", inUserEntity.getId());

			return resultCode;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int registerRecord(UserEntity inUserEntity) {
		try {
			int resultCode = jdbcTemplate.update("insert into user_mst(user_name,age,sex) values(?, ?, ?)",
					inUserEntity.getUser_name(), inUserEntity.getAge(), inUserEntity.getSex());

			return resultCode;
		} catch (Exception e) {
			return 0;
		}
	}
}
