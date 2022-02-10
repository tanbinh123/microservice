package com.javaweb.util.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.javaweb.util.help.rate.Award;

public class RateUtil {
	
	/**
	1、中奖概率：如0.1%表示每1000个单位中只有1个；比如说硬币正反面，假设掷中正面是中奖，那么一共两个面（正面和反面），正面的概率就是1/2=50%
	可以设置两个盒子，标记为1和2，盒子1放入正面，盒子2放入反面，设置盒子1的正面为中奖，用户每次抽奖都给其1-2间一个随机数，如果随机数的值是1，那么即表示中奖，关于随机数相关，暂不在此讨论
	奖品等级           奖品名称                  奖品数量          中奖概率
	特等奖	     宝马X5	      1	        0.3%
	一等奖	     海南岛五日游	  3	        0.8%
	二等奖	  iPhone13	  5	        1.2%
	三等奖	  Switch	  10	    3.6%
	鼓励奖	  100元人民币	  100	    7.8%
	说明：需要公示中奖概率，手游中抽卡类似，只不过各奖品等级的奖品数量可以变为正无穷
	分析：总中奖的概率可知为：0.3%+0.8%+1.2%+3.6%+7.8%=13.7%，也就是说，可以简单的理解为有1000个物品，其中137个是奖品。然后再来计算各个奖品所占的比例：
	0.3%/13.7%*137	0.8%/13.7%*137	1.2%/13.7%*137	3.6%/13.7%*137	7.8%/13.7%*137
	3	            8	            12	            36	            78
	也就是说137个奖品中3个是特等奖，8个是一等奖，12个是二等奖，36个是三等奖，78个是鼓励奖
	其实，只要数量不为0，并不影响中奖概率或者说抽奖算法归根结底还是取决于中奖概率
	一般来说抽奖不应该有数量限制，因为一但加入数量限制（尤其是数量为0时，有些人还认为每次数量的减少都会影响概率）
	一方面加大了算法复杂度，另一方面在用户展示界面也会显得不太好展示（表现）
	当然，肯定有这种业务，我们一般采用奖池+时间线的概念来处理，奖池即将所有中奖品和非中奖品初始化，时间线是保证不会由于大家一拥而上，瞬间所有奖品就没了
	抛开奖品数量，我们最简单的就可以设置如下区间分布：
	常规版	      3	     8	     12	       36	     78	     1000
	打乱版（初）	  36	 78	     1000	   8	     3	     12
	打乱版（换算）           36   	 114	 977（*）        985       988     1000
	注：977=1000-137+114，而137=3+8+12+36+78
	以常规版为例，当用户抽奖时，会获得一个1-1000随机数，如302，由于302在78和1000中间，所以该用户（抽到的302）没有中奖；又如78，由于78在36和78中间，所以该用户（抽到的78）中了特等奖
	*/
	public static void main(String[] args) {
		//奖品类初始化
		List<Award> list = Stream.of(
				new Award(1,"特等奖","宝马X5",1,new BigDecimal("0.003")/*0.3%*/),
				new Award(2,"一等奖","海南岛五日游",3,new BigDecimal("0.008")/*0.8%*/),
				new Award(3,"二等奖","iPhone13",5,new BigDecimal("0.012")/*1.2%*/),
				new Award(4,"三等奖","Switch",10,new BigDecimal("0.036")/*3.6%*/),
				new Award(5,"鼓励奖","100元人民币",100,new BigDecimal("0.078")/*7.8%*/)
		).collect(Collectors.toList());
		//计算总中奖概率
		BigDecimal sum = list.stream().map(Award::getAwardRate).reduce(BigDecimal.ZERO,BigDecimal::add);
		int scale = sum.scale();
		long totalBox = new BigDecimal(Math.pow(10,scale)).longValue();//盒子内总数
		long totalAward = sum.multiply(new BigDecimal(Math.pow(10,scale))).longValue();//盒子内总奖品数
		//System.out.println(totalBox);
		//System.out.println(totalAward);
		//从totalBox（1-1000）个数字里取出totalAward（137）个不重复数字
		Map<Integer,Integer> map = new HashMap<>();
		/** 方式1（totalBox的数量远大于totalAward推荐此方法） */
		while(map.size()!=totalAward){
			int random = (int)(Math.random()*totalBox)+1;
			map.put(random,random);
		}
		System.out.println(map);
		/** 方式2（totalBox的数量不太多且接近于totalAward推荐此方法） 
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> intList = IntStream.range(1,(int)totalBox).boxed().collect(Collectors.toList());
		for(int i=1;i<=totalAward;i++) {
			int random = (int)(Math.random()*intList.size())+1;
			random = intList.remove(random);
			map.put(random,random);
		}
		System.out.println(map);
		*/
		List<Integer> integerList = list.stream().map(e->e.getAwardRate().multiply(new BigDecimal(Math.pow(10,scale))).intValue()).collect(Collectors.toList());
		integerList.add((int)totalBox);
		System.out.println(integerList);//[3,8,12,36,78,1000]
		int oneRandom = (int)(Math.random()*totalBox)+1;
		System.out.println(oneRandom);
	}

}
