package com.javaweb.util.help.sort;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		final Integer[] i = {4,5,6,7,3,2,1,9,8};
		Integer bubbleSortArray[] = i;
		Integer insertSortArray[] = i;
		Integer shellSortArray[] = i;
		BaseSort<Integer> st1 = new BubbleSort();st1.sort(bubbleSortArray);
		BaseSort<Integer> st2 = new InsertSort();st2.sort(insertSortArray);
		BaseSort<Integer> st3 = new ShellSort();st3.sort(shellSortArray);
		System.out.println(Arrays.toString(bubbleSortArray));
		System.out.println(Arrays.toString(insertSortArray));
		System.out.println(Arrays.toString(shellSortArray));
	}

}
