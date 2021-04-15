package javacode01;

import java.util.Arrays;

/**
 * 递归实现数组的反转
 * 
 * @author mofeibai
 *
 */
public class ArrayReverse {
	/**
	 * 交换数组中两元素的位置
	 * 
	 * @param A {@code int[]} 类型 待交换的数组
	 * @param a {@code int} 类型 交换的元素的索引
	 * @param b {@code int} 类型的另一个交换元素的索引
	 */
	public static void swap(int[] A, int a, int b) {
		int temp;
		temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	public static void reverse(int[] array, int startindex, int endindex) {
		if (startindex >= endindex) {
			return;
		} else {
			swap(array, startindex, endindex);
		}
		reverse(array, ++startindex, --endindex);
	}

	public static void main(String[] args) {
		int[] nums = { 12, 4, 51, 51, 6, 325, 12 };
		reverse(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
