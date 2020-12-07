package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.UserEntity;
import com.example.demo.repository.UserRepository;

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
	public List<UserDto> findByConditions(UserDto inDto) {
		List<UserEntity> outUserEntityList = new ArrayList<UserEntity>();

		// DTOからEntityに転記
		UserEntity inUserEntity = new UserEntity();
		BeanUtils.copyProperties(inDto, inUserEntity);

		// 検索を実行
		outUserEntityList = userRepository.findByConditions(inUserEntity);

		List<UserDto> outUserDtoList = new ArrayList<UserDto>();

		// 検索結果がnull出ない場合、DTOに転記する
		if (outUserEntityList != null) {
			for (int i = 0; i < outUserEntityList.size(); i++) {
				UserEntity user = outUserEntityList.get(i);
				UserDto userDto = new UserDto();
				BeanUtils.copyProperties(user, userDto);

				outUserDtoList.add(userDto);
			}
			System.out.println("DTO転記" + outUserDtoList);
		}
		return outUserDtoList;
	}

	@Override
	public int update(UserDto inDto) {
		// DTOからEntityに転記
		UserEntity inUserEntity = new UserEntity();
		BeanUtils.copyProperties(inDto, inUserEntity);

		// 更新を実行
		int resultCode = userRepository.updateRecord(inUserEntity);

		return resultCode;
	}
	
	@Override
	public int delete(UserDto inDto) {
		// DTOからEntityに転記
		UserEntity inUserEntity = new UserEntity();
		BeanUtils.copyProperties(inDto, inUserEntity);

		// 削除を実行
		int resultCode = userRepository.deleteRecord(inUserEntity);

		return resultCode;
	}
	
	@Override
	public int register(UserDto inDto) {
		// DTOからEntityに転記
		UserEntity inUserEntity = new UserEntity();
		BeanUtils.copyProperties(inDto, inUserEntity);

		// 登録を実行
		int resultCode = userRepository.registerRecord(inUserEntity);

		return resultCode;
	}
}