package com.javaweb.web.po;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_interfaces_statistics")
public class InterfacesStatistics implements Serializable {

	private static final long serialVersionUID = -5752151237446626610L;

	@Column(name="id",pk=true,idAutoCreate=true,columnDesc="主键ID")
	private String id;//主键ID
	
	@Column(name="url",columnDesc="URL")
	private String url;//URL
	
	@Column(name="year_month_day",columnDesc="年月日")
	private String yearMonthDay;//年月日
	
	@Column(name="year",columnDesc="年")
	private String year;//年
	
	@Column(name="month",columnDesc="月")
	private String month;//月
	
	@Column(name="day",columnDesc="日")
	private String day;//日
	
	@Column(name="insert_time",columnDesc="插入时间")
	private Date insertTime;//插入时间
	
	@Column(name="times",columnDesc="次数")
	private BigInteger times;//次数
	
	public static final String idColumn = "id";
	public static final String baseUrlColumn = "url";
	public static final String yearMonthDayColumn = "year_month_day";
	public static final String yearColumn = "year";
	public static final String monthColumn = "month";
	public static final String dayColumn = "day";
	public static final String insertTimeColumn = "insert_time";
	public static final String timesColumn = "times";

}
