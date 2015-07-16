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
 * 创建时间：2015年7月16日--上午11:15:06
 * 作者：阿信sxq 使用Windows平台下的Eclipse(STS)创建<br>
 */
package cn.songxinqiang.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 * 
 * @author 阿信sxq-2015年7月16日
 *
 */
public class RadixSort {

	/**
	 * 原理：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
	 * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
	 *
	 * @author 阿信sxq-2015年7月16日
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17,
				18, 23, 34, 15, 35, 25, 53, 51 };

		//首先确定排序的趟数;    
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		int time = 0;
		//判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}

		//建立10个队列(0-9共10个);    
		List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}

		//进行time次分配和收集;    
		for (int i = 0; i < time; i++) {
			//分配数组元素;    
			for (int j = 0; j < a.length; j++) {
				//得到数字的倒数第i+1位数;
				//125%100/10=2
				int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				queue.get(x).add(a[j]);
			}
			int count = 0;//元素计数器;    
			//收集队列元素;    
			for (ArrayList<Integer> li : queue) {
				for (int t : li) {
					a[count++] = t;
				}
				li.clear();
			}
		}
		System.out.println(Arrays.toString(a));

	}

}
