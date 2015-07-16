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
 * 创建时间：2015年7月16日--上午11:06:35
 * 作者：阿信sxq 使用Windows平台下的Eclipse(STS)创建<br>
 */
package cn.songxinqiang.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 * 
 * @author 阿信sxq-2015年7月16日
 *
 */
public class BubbleSort {

	/**
	 * 原理：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：
	 * 每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
	 *
	 * @author 阿信sxq-2015年7月16日
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17,
				18, 23, 34, 15, 35, 25, 53, 51 };
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(a));

	}

}
