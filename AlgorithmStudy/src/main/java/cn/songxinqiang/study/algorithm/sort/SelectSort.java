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
 * 创建时间：2015年7月16日--上午11:15:49
 * 作者：阿信sxq 使用Windows平台下的Eclipse(STS)创建<br>
 */
package cn.songxinqiang.study.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 * 
 * @author 阿信sxq-2015年7月16日
 *
 */
public class SelectSort {

    /**
     * 原理：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     *
     * @author 阿信sxq-2015年7月16日
     *
     * @param args
     */
    public static void main(String[] args) {
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17,
                18, 23, 34, 15, 35, 25, 53, 51 };
        int position = 0;
        for (int i = 0; i < a.length; i++) {
            //默认的最小的下标
            position = i;
            //找出最小的
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[position]) {
                    position = j;
                }
            }
            //交换
            if (position != i) {
                int temp = a[position];
                a[position] = a[i];
                a[i] = temp;
            }
        }

        System.out.println(Arrays.toString(a));

    }

}
