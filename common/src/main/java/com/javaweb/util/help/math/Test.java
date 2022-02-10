package com.javaweb.util.help.math;

public class Test {
	
	//递归
	public static long cal_1(long x){
		if(x<=1){
			return x;
		}else{
			return cal_1(x-1)+x;
		}
	}
	
	//尾递归
	public static long cal_2(long x,long y){
		if(x==1){
			return y;
		}else{
			return cal_2(x-1,x+y);
		}
	}
	
	//非递归
	public static long cal_3(long x){
		long ret = 0;
		for(long i=x;i>0;i--){
			ret+=i;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		System.out.println(cal_1(100000));
		System.out.println(System.currentTimeMillis()-start1);
		long start2 = System.currentTimeMillis();
		System.out.println(cal_2(100000,1));
		System.out.println(System.currentTimeMillis()-start2);
		long start3 = System.currentTimeMillis();
		System.out.println(cal_3(100000));
		System.out.println(System.currentTimeMillis()-start3);
	}
	
}
