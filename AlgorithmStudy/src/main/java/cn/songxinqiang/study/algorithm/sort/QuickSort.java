/**
 * <pre>
 * Copyright 2015 阿信sxq(songxinqiang@vip.qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
/*
 * 创建时间：2015年7月16日--上午11:14:18
 * 作者：阿信sxq 使用Windows平台下的Eclipse(STS)创建<br>
 */
package cn.songxinqiang.study.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 * 
 * @author 阿信sxq-2015年7月16日
 *
 */
public class QuickSort {

	/**
	 * 原理：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 *
	 * @author 阿信sxq-2015年7月16日
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17,
				18, 23, 34, 15, 35, 25, 53, 51 };
		if (a.length > 0) {//查看数组是否为空    
			_quickSort(a, 0, a.length - 1);
		}
		System.out.println(Arrays.toString(a));

	}

	public static void _quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int low = left;
		int high = right;
		int tmp = arr[low];//数组的第一个作为中轴    
		while (low < high) {
			while (low < high && arr[high] >= tmp) {
				high--;
			}
			arr[low] = arr[high];//比中轴小的记录移到低端    

			while (low < high && arr[low] <= tmp) {
				low++;
			}
			arr[high] = arr[low];//比中轴大的记录移到高端    
		}
		arr[low] = tmp;//中轴记录到尾    
		_quickSort(arr, left, low - 1);//对低字表进行递归排序    
		_quickSort(arr, low + 1, right);//对高字表进行递归排序    
	}

}
