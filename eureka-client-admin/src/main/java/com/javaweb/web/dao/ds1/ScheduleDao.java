package com.javaweb.web.dao.ds1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.web.po.Schedule;

@Mapper
public interface ScheduleDao extends DaoWapper<Schedule> {
	
	List<Schedule> getScheduleByDate(Map<String,String> map);
	
	void deleteByScheduleDate(Map<String,String> map);
	
	void scheduleSave(List<Schedule> list);
	
}