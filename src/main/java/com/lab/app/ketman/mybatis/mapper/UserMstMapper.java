package com.lab.app.ketman.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lab.app.ketman.mybatis.domain.UserMst;
import com.lab.app.ketman.mybatis.domain.UserMstExample;
import com.lab.app.ketman.mybatis.domain.UserMstWithBLOBs;

@Mapper
public interface UserMstMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	long countByExample(UserMstExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	int deleteByExample(UserMstExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	int insert(UserMstWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	int insertSelective(UserMstWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */List<UserMstWithBLOBs> selectByExampleWithBLOBs(UserMstExample example);
	 
	 List<UserMstWithBLOBs> selectByExampleWithBLOBsPaging(UserMstExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */List<UserMst> selectByExample(UserMstExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	UserMstWithBLOBs selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */int updateByExampleSelective(@Param("record") UserMstWithBLOBs record,@Param("example") UserMstExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */int updateByExampleWithBLOBs(@Param("record") UserMstWithBLOBs record,@Param("example") UserMstExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */int updateByExample(@Param("record") UserMst record,@Param("example") UserMstExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	int updateByPrimaryKeySelective(UserMstWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	int updateByPrimaryKeyWithBLOBs(UserMstWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	int updateByPrimaryKey(UserMst record);
}