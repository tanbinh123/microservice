package com.javaweb.util.help.sort;

import com.javaweb.enums.SortCompareEnum;;

@FunctionalInterface
public interface BaseSort<T> {
	
	public T[] sort(T[] array);
	
	public default SortCompareEnum sortCompare(SortCompareEnum sortCompareEnum){
		return SortCompareEnum.LESS_TO_MORE;
	}
	
	/**
	两数交换：
	写法一：array[x] = array[x]^array[y];array[y] = array[x]^array[y];array[x] = array[x]^array[y];
	写法二：x = x+y;y = x-y;x = x-y;
	*/
	public default void exchange(T[] array,int one,int another){
		if(one!=another){
			T c = array[one];
			array[one] = array[another];
			array[another] = c;
		}
	}
	
}
