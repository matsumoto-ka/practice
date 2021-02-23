package com.example.demo.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.UserRepository;
import com.lab.app.ketman.mybatis.domain.UserMstExample;
import com.lab.app.ketman.mybatis.domain.UserMstWithBLOBs;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	// UserRepositoryのDI
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto findByConditions(UserDto inDto) {
		// UserMstテーブルの条件検索用クラスを生成
		UserMstExample ex = new UserMstExample();

		ex.createCriteria();
		// 検索条件を設定
		// ID
		if (!(inDto.getId() == 0)) {
			ex.or().andIdEqualTo(inDto.getId());
		}
		// 性別
		if (!(StringUtils.isEmpty(inDto.getSex()))) {
			ex.or().andSexEqualTo(Integer.parseInt(inDto.getSex()));
		}
		// 年齢
		if (!StringUtils.isEmpty(inDto.getAge_from()) && !StringUtils.isEmpty(inDto.getAge_to())) {
			ex.or().andAgeBetween(Integer.parseInt(inDto.getAge_from()), Integer.parseInt(inDto.getAge_to()));
		} else if (!(StringUtils.isEmpty(inDto.getAge_from()))) {
			ex.or().andAgeGreaterThan(Integer.parseInt(inDto.getAge_from()));
		} else if (!(StringUtils.isEmpty(inDto.getAge_to()))) {
			ex.or().andAgeLessThan(Integer.parseInt(inDto.getAge_to()));
		}

		if (StringUtils.isNotEmpty(inDto.getSortCondition())) {
			ex.setOrderByClause(inDto.getSortCondition());
		} else {
			ex.setOrderByClause("id");
		}
		ex.setLimit(inDto.getLimit());
		ex.setOffset(inDto.getOffset());

		// 戻り値用DTO
		UserDto outUserDto = new UserDto();

		// 検索実行
		long total = userRepository.countByExample(ex);
		List<UserMstWithBLOBs> userMstList = userRepository.findByConditions(ex);

		outUserDto.setTotal((int) total);
		outUserDto.setUserList(userMstList);

		return outUserDto;
	}

	@Override
	public UserDto findById(UserDto inDto) {
		// 戻り値用DTO
		UserDto outUserDto = new UserDto();

		// 検索実行
		UserMstWithBLOBs userMst = userRepository.findById(inDto.getId());

		outUserDto.setUserList((List<UserMstWithBLOBs>) userMst);

		return outUserDto;
	}

	@Override
	public int update(UserDto inDto) {
		// UserMstテーブルの条件検索用クラスを生成
		UserMstExample ex = new UserMstExample();

		// 条件にIDを設定
		ex.createCriteria().andIdEqualTo(inDto.getId());

		// UserMstWithBLOBsを生成
		UserMstWithBLOBs record = new UserMstWithBLOBs();

		// DTOからUserMstWithBLOBsに転記
		BeanUtils.copyProperties(inDto, record);
		record.setAge(Integer.parseInt(inDto.getAge()));
		record.setSex(Integer.parseInt(inDto.getSex()));
		record.setTel(Long.parseLong(inDto.getTel()));
		record.setPostal_code(Integer.parseInt(inDto.getPostal_code()));

		// 更新実行
		int resultCode = userRepository.updateRecord(record, ex);

		return resultCode;
	}

	@Override
	public int delete(UserDto inDto) {
		// 削除実行
		int resultCode = userRepository.deleteRecord(inDto.getId());

		return resultCode;
	}

	@Override
	public int register(UserDto inDto) {
		// UserMstWithBLOBsを生成
		UserMstWithBLOBs record = new UserMstWithBLOBs();

		// DTOからUserMstWithBLOBsに転記
		BeanUtils.copyProperties(inDto, record);
		record.setAge(Integer.parseInt(inDto.getAge()));
		record.setSex(Integer.parseInt(inDto.getSex()));
		record.setTel(Long.parseLong(inDto.getTel()));
		record.setPostal_code(Integer.parseInt(inDto.getPostal_code()));

		// 登録実行
		int resultCode = userRepository.registerRecord(record);

		return resultCode;
	}
}