package com.javaweb.util.help.sort;

//插入排序（相比冒泡排序，可以理解为【从后往前】）
public class InsertSort implements BaseSort<Integer> {
	
	/**
	<<算法导论>>的伪代码如下:
	for j=2 to A.length
  		key = A[j]
  		i = j-1
  		while i>0 and A[i]>key
  			A[i+1] = A[i]
  			i = i-1
  		A[i+1] = key
	*/
	//核心点：1、待插入的值是不变的；2：插入比较的下标是变的
	public Integer[] sort(Integer[] array) {
		for (int i=1;i<array.length;i++) {
			final int key = array[i];//待插入的数的值（印证核心逻辑第1点）
			int compareStartIndex = i-1;//待比较的数的初始下标，初始比较永远比待插入的数的下标小1（印证核心逻辑第2点）
			while(compareStartIndex>=0&&(key<array[compareStartIndex])){//插入比较下标往前推不能小于0，key<array[compareStartIndex]或key>array[compareStartIndex]只决定到底是从小到大排列还是从大到小排列
			/** 很有技巧的三行代码 start */	
			/** 以5、6、4，待插入数是4为例，程序执行结果依次为：	
			5、6、4
			5、6、6    
			5、5、6
			4、5、6
			//完成数组最后一位数字4的前移
			Integer[] array = {5,6,4};
			final int num_4_value =  4;
			int compareStartIndex = 1;//从下标第1位开始比较
			while(compareStartIndex>=0&&num_4_value<array[compareStartIndex]){
				array[compareStartIndex+1] = array[compareStartIndex];
				compareStartIndex--;
			}
			array[compareStartIndex+1] = num_4_value;
			System.out.println(Arrays.toString(array)); 
			*/	
				array[compareStartIndex+1] = array[compareStartIndex];//需要比较的数向右移动一位
				compareStartIndex--;//继续往前推一位比较
			}
			array[compareStartIndex+1] = key;//因为之前已经先--往前多推一位了，所以这里要补回来一位
			/** 很有技巧的三行代码 end */	
		}
		return array;
	}
	
}
