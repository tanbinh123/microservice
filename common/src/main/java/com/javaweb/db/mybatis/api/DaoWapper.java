package com.javaweb.db.mybatis.api;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.javaweb.constant.CommonConstant;
import com.javaweb.db.query.QueryWapper;

@Mapper
public interface DaoWapper<T> {
	
	@Insert(CommonConstant.EMPTY_VALUE)
	Integer insert(T t);//插入实体类
	
	@Update(CommonConstant.EMPTY_VALUE)
	Integer update(T t);//更新实体类
	
	@Delete(CommonConstant.EMPTY_VALUE)
	Integer delete(Object id);//根据主键删除
	
	@Select(CommonConstant.EMPTY_VALUE)
	List<T> selectAll();//查询所有
	
	@Select(CommonConstant.EMPTY_VALUE)
	Long selectAllCount();//统计所有
	
	@Select(CommonConstant.EMPTY_VALUE)
	T selectByPk(Object id);//根据主键查询
	
	@Select(CommonConstant.EMPTY_VALUE)
	T selectOne(QueryWapper<T> queryWapper);//条件查询

	@Select(CommonConstant.EMPTY_VALUE)
	List<T> selectList(QueryWapper<T> queryWapper);//条件查询（支持分页）
	
	@Select(CommonConstant.EMPTY_VALUE)
	Long selectListCount(QueryWapper<T> queryWapper);//条件查询统计（支持分页）
	
}
