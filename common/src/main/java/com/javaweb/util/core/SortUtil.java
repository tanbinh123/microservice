package com.javaweb.util.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.javaweb.util.help.sort.BaseSort;
import com.javaweb.util.help.sort.BubbleSort;
import com.javaweb.util.help.sort.BucketSort;
import com.javaweb.util.help.sort.CountSort;
import com.javaweb.util.help.sort.HeapSort;
import com.javaweb.util.help.sort.InsertSort;
import com.javaweb.util.help.sort.MergeSort;
import com.javaweb.util.help.sort.QuickSort;
import com.javaweb.util.help.sort.ShellSort;

/**
 * 排序包含:
 * 1.冒泡排序
 * 2.插入排序
 * 3.希尔排序
 * 4.归并排序
 * 5.堆排序
 * 6.快速排序
 * 7.计数排序
 * 8.桶排序
 */
public class SortUtil {
	
	private static final String BUBBLE_SORT = BubbleSort.class.getSimpleName();//冒泡排序
	
	private static final String INSERT_SORT = InsertSort.class.getSimpleName();//插入排序
	
	private static final String SHELL_SORT = ShellSort.class.getSimpleName();//希尔排序
	
	private static final String MERGE_SORT = InsertSort.class.getSimpleName();//归并排序
	
	private static final String HEAP_SORT = HeapSort.class.getSimpleName();//堆排序
	
	private static final String QUICK_SORT = QuickSort.class.getSimpleName();//快速排序
	
	private static final String COUNT_SORT = CountSort.class.getSimpleName();//计数排序
	
	private static final String BUCKET_SORT = BucketSort.class.getSimpleName();//桶排序
	
	private static final Map<String,Supplier<BaseSort<Integer>>> SORT_MAP = new HashMap<>();
	
	static {
		SORT_MAP.put(BUBBLE_SORT,BubbleSort::new);
		SORT_MAP.put(INSERT_SORT,InsertSort::new);
		SORT_MAP.put(SHELL_SORT,ShellSort::new);
		SORT_MAP.put(MERGE_SORT,MergeSort::new);
		SORT_MAP.put(BUCKET_SORT,BucketSort::new);
		SORT_MAP.put(HEAP_SORT,HeapSort::new);
		SORT_MAP.put(QUICK_SORT,QuickSort::new);
		SORT_MAP.put(COUNT_SORT,CountSort::new);
	}
	
	public enum SortType{
		
		BUBBLE_SORT(SortUtil.BUBBLE_SORT),
		INSERT_SORT(SortUtil.INSERT_SORT),
		SHELL_SORT(SortUtil.SHELL_SORT),
		MERGE_SORT(SortUtil.MERGE_SORT),
		BUCKET_SORT(SortUtil.BUCKET_SORT),
		HEAP_SORT(SortUtil.HEAP_SORT),
		QUICK_SORT(SortUtil.QUICK_SORT),
		COUNT_SORT(SortUtil.COUNT_SORT);
		
		private SortType(String sortType){
			this.sortType = sortType;
		}
		
		private String sortType;

		public String getSortType() {
			return sortType;
		}

		public void setSortType(String sortType) {
			this.sortType = sortType;
		}
		
	}
	
	//使用方式(不适用计数排序[需设置数值的最大和最小范围]和桶排序[需设置数值的最大和最小范围]):getSort(new Integer[]{1,2,3}, SortType.INSERT_SORT)
	public static Integer[] getSort(Integer array[],SortType sortType){
		Supplier<BaseSort<Integer>> supplier = SORT_MAP.get(sortType.getSortType());	
		return supplier.get().sort(array);
	}
	
	//使用方式(不适用计数排序[需设置数值的最大和最小范围]和桶排序[需设置数值的最大和最小范围]):getSort(new Integer[]{1,2,3,4,5},InsertSort::new)
	public static Integer[] getSort(Integer array[],Supplier<BaseSort<Integer>> supplier){
		return supplier.get().sort(array);
	}
	
	//使用方式:getSort(new Integer[]{1,2,3,4,5},(array)->{return array;})
	public static Integer[] getSort(Integer array[],BaseSort<Integer> baseSort){
		return baseSort.sort(array);
	}

}
