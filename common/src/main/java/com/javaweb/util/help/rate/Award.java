package com.javaweb.util.help.rate;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Award implements Serializable {

	private static final long serialVersionUID = 2860786322768264979L;

	private Integer awardLevel;//奖品等级（我们约定数字越小等级越高）
	
	private String awardLevelDesc;//奖品等级描述（如特等奖、一等奖等）
	
	private String awardName;//奖品名称（如iPhone、Switch等）
	
	private Integer awardNum;//奖品数量（null或小于0表示数量无限）
	
	private BigDecimal awardRate;//中奖概率（用字符串表示小数，如字符串0.13表示中奖概率为13%）
	
	public Award(){
		
	}
	
	public Award(Integer awardLevel,String awardLevelDesc,String awardName,Integer awardNum,BigDecimal awardRate){
		this.awardLevel = awardLevel;
		this.awardLevelDesc = awardLevelDesc;
		this.awardName = awardName;
		this.awardNum = awardNum;
		this.awardRate = awardRate;
	}
	
}
