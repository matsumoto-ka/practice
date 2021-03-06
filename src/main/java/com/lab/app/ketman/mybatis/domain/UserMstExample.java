package com.lab.app.ketman.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class UserMstExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	protected boolean distinct;
	
	protected int offset;
	
	protected int limit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */public UserMstExample(){oredCriteria=new ArrayList<>();}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */public List<Criteria> getOredCriteria(){return oredCriteria;}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
		limit = 0;
		offset = 0;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andIdIsNull(){addCriterion("id is null");return (Criteria)this;}public Criteria andIdIsNotNull(){addCriterion("id is not null");return (Criteria)this;}public Criteria andIdEqualTo(Integer value){addCriterion("id =",value,"id");return (Criteria)this;}public Criteria andIdNotEqualTo(Integer value){addCriterion("id <>",value,"id");return (Criteria)this;}public Criteria andIdGreaterThan(Integer value){addCriterion("id >",value,"id");return (Criteria)this;}public Criteria andIdGreaterThanOrEqualTo(Integer value){addCriterion("id >=",value,"id");return (Criteria)this;}public Criteria andIdLessThan(Integer value){addCriterion("id <",value,"id");return (Criteria)this;}public Criteria andIdLessThanOrEqualTo(Integer value){addCriterion("id <=",value,"id");return (Criteria)this;}public Criteria andIdIn(List<Integer> values){addCriterion("id in",values,"id");return (Criteria)this;}public Criteria andIdNotIn(List<Integer> values){addCriterion("id not in",values,"id");return (Criteria)this;}public Criteria andIdBetween(Integer value1,Integer value2){addCriterion("id between",value1,value2,"id");return (Criteria)this;}public Criteria andIdNotBetween(Integer value1,Integer value2){addCriterion("id not between",value1,value2,"id");return (Criteria)this;}public Criteria andSexIsNull(){addCriterion("sex is null");return (Criteria)this;}public Criteria andSexIsNotNull(){addCriterion("sex is not null");return (Criteria)this;}public Criteria andSexEqualTo(Integer value){addCriterion("sex =",value,"sex");return (Criteria)this;}public Criteria andSexNotEqualTo(Integer value){addCriterion("sex <>",value,"sex");return (Criteria)this;}public Criteria andSexGreaterThan(Integer value){addCriterion("sex >",value,"sex");return (Criteria)this;}public Criteria andSexGreaterThanOrEqualTo(Integer value){addCriterion("sex >=",value,"sex");return (Criteria)this;}public Criteria andSexLessThan(Integer value){addCriterion("sex <",value,"sex");return (Criteria)this;}public Criteria andSexLessThanOrEqualTo(Integer value){addCriterion("sex <=",value,"sex");return (Criteria)this;}public Criteria andSexIn(List<Integer> values){addCriterion("sex in",values,"sex");return (Criteria)this;}public Criteria andSexNotIn(List<Integer> values){addCriterion("sex not in",values,"sex");return (Criteria)this;}public Criteria andSexBetween(Integer value1,Integer value2){addCriterion("sex between",value1,value2,"sex");return (Criteria)this;}public Criteria andSexNotBetween(Integer value1,Integer value2){addCriterion("sex not between",value1,value2,"sex");return (Criteria)this;}public Criteria andTelIsNull(){addCriterion("tel is null");return (Criteria)this;}public Criteria andTelIsNotNull(){addCriterion("tel is not null");return (Criteria)this;}public Criteria andTelEqualTo(Long value){addCriterion("tel =",value,"tel");return (Criteria)this;}public Criteria andTelNotEqualTo(Long value){addCriterion("tel <>",value,"tel");return (Criteria)this;}public Criteria andTelGreaterThan(Long value){addCriterion("tel >",value,"tel");return (Criteria)this;}public Criteria andTelGreaterThanOrEqualTo(Long value){addCriterion("tel >=",value,"tel");return (Criteria)this;}public Criteria andTelLessThan(Long value){addCriterion("tel <",value,"tel");return (Criteria)this;}public Criteria andTelLessThanOrEqualTo(Long value){addCriterion("tel <=",value,"tel");return (Criteria)this;}public Criteria andTelIn(List<Long> values){addCriterion("tel in",values,"tel");return (Criteria)this;}public Criteria andTelNotIn(List<Long> values){addCriterion("tel not in",values,"tel");return (Criteria)this;}public Criteria andTelBetween(Long value1,Long value2){addCriterion("tel between",value1,value2,"tel");return (Criteria)this;}public Criteria andTelNotBetween(Long value1,Long value2){addCriterion("tel not between",value1,value2,"tel");return (Criteria)this;}public Criteria andPostal_codeIsNull(){addCriterion("postal_code is null");return (Criteria)this;}public Criteria andPostal_codeIsNotNull(){addCriterion("postal_code is not null");return (Criteria)this;}public Criteria andPostal_codeEqualTo(Integer value){addCriterion("postal_code =",value,"postal_code");return (Criteria)this;}public Criteria andPostal_codeNotEqualTo(Integer value){addCriterion("postal_code <>",value,"postal_code");return (Criteria)this;}public Criteria andPostal_codeGreaterThan(Integer value){addCriterion("postal_code >",value,"postal_code");return (Criteria)this;}public Criteria andPostal_codeGreaterThanOrEqualTo(Integer value){addCriterion("postal_code >=",value,"postal_code");return (Criteria)this;}public Criteria andPostal_codeLessThan(Integer value){addCriterion("postal_code <",value,"postal_code");return (Criteria)this;}public Criteria andPostal_codeLessThanOrEqualTo(Integer value){addCriterion("postal_code <=",value,"postal_code");return (Criteria)this;}public Criteria andPostal_codeIn(List<Integer> values){addCriterion("postal_code in",values,"postal_code");return (Criteria)this;}public Criteria andPostal_codeNotIn(List<Integer> values){addCriterion("postal_code not in",values,"postal_code");return (Criteria)this;}public Criteria andPostal_codeBetween(Integer value1,Integer value2){addCriterion("postal_code between",value1,value2,"postal_code");return (Criteria)this;}public Criteria andPostal_codeNotBetween(Integer value1,Integer value2){addCriterion("postal_code not between",value1,value2,"postal_code");return (Criteria)this;}public Criteria andAgeIsNull(){addCriterion("age is null");return (Criteria)this;}public Criteria andAgeIsNotNull(){addCriterion("age is not null");return (Criteria)this;}public Criteria andAgeEqualTo(Integer value){addCriterion("age =",value,"age");return (Criteria)this;}public Criteria andAgeNotEqualTo(Integer value){addCriterion("age <>",value,"age");return (Criteria)this;}public Criteria andAgeGreaterThan(Integer value){addCriterion("age >",value,"age");return (Criteria)this;}public Criteria andAgeGreaterThanOrEqualTo(Integer value){addCriterion("age >=",value,"age");return (Criteria)this;}public Criteria andAgeLessThan(Integer value){addCriterion("age <",value,"age");return (Criteria)this;}public Criteria andAgeLessThanOrEqualTo(Integer value){addCriterion("age <=",value,"age");return (Criteria)this;}public Criteria andAgeIn(List<Integer> values){addCriterion("age in",values,"age");return (Criteria)this;}public Criteria andAgeNotIn(List<Integer> values){addCriterion("age not in",values,"age");return (Criteria)this;}public Criteria andAgeBetween(Integer value1,Integer value2){addCriterion("age between",value1,value2,"age");return (Criteria)this;}public Criteria andAgeNotBetween(Integer value1,Integer value2){addCriterion("age not between",value1,value2,"age");return (Criteria)this;}}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user_mst
	 * @mbg.generated  Sun Dec 27 16:36:32 JST 2020
	 */public static class Criterion {private String condition;private Object value;private Object secondValue;private boolean noValue;private boolean singleValue;private boolean betweenValue;private boolean listValue;private String typeHandler;public String getCondition(){return condition;}public Object getValue(){return value;}public Object getSecondValue(){return secondValue;}public boolean isNoValue(){return noValue;}public boolean isSingleValue(){return singleValue;}public boolean isBetweenValue(){return betweenValue;}public boolean isListValue(){return listValue;}public String getTypeHandler(){return typeHandler;}protected Criterion(String condition){super();this.condition=condition;this.typeHandler=null;this.noValue=true;}protected Criterion(String condition,Object value,String typeHandler){super();this.condition=condition;this.value=value;this.typeHandler=typeHandler;if (value instanceof List<?>){this.listValue=true;} else {this.singleValue=true;}}protected Criterion(String condition,Object value){this(condition,value,null);}protected Criterion(String condition,Object value,Object secondValue,String typeHandler){super();this.condition=condition;this.value=value;this.secondValue=secondValue;this.typeHandler=typeHandler;this.betweenValue=true;}protected Criterion(String condition,Object value,Object secondValue){this(condition,value,secondValue,null);}}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_mst
     *
     * @mbg.generated do_not_delete_during_merge Thu Dec 10 21:40:34 JST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}