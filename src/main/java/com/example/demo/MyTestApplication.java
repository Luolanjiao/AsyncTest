package com.example.demo;

import com.example.demo.service.MyComparator;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MyTestApplication {
    public static void main(String[] args) {
//        ArrayList<Integer> numbers=new ArrayList<Integer>();
//        numbers.add(1237);
//        recursion(numbers);
        //   int[] array = {3, 1, 2, 6, 4,1, 8, 7, 0, 9};
        //  int[] array = {3, 2, 6, 7, 8, 9};
        Integer[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        //array = selectionSort(array);
      //  quickSort(array, 0, array.length - 1);
        swap(array);
        for (int num : array
        ) {
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> recursion(ArrayList<Integer> numbers) {
        int lastNum = numbers.get(numbers.size() - 1);
        int addNum = lastNum * 2;
        numbers.add(addNum);
        if (addNum > 5000) {
            for (int num : numbers
            ) {
                System.out.println(num);
            }

            return numbers;
        }
        return recursion(numbers);
    }

    /***
     * 选择性排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (array[i] > min) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
        return array;
    }

    /***
     * 快速排序算法
     * @param array
     * @param sectionStart：排序区间开始标识（因为每次循环都是在同一个数组上操作，需要标识出区间）
     * @param sectionEnd：排序区间结束标识
     */
    public static void quickSort(int[] array, int sectionStart, int sectionEnd) {
        //参照值
        int comparisedValue = array[sectionStart];
        //左指针
        int leftIndex = sectionStart;
        //右指针
        int rightIndex = sectionEnd;

        while (leftIndex < rightIndex) {
            int middleInt = 0;
            //右指针先比较（注意;必须是右边先找，因为参考值是左边第一个值，左边比较的话它自己永远不会被排序）
            //是大值则指针往前移动（大值都在指针右边，小值则要进行交换）
            while (leftIndex < rightIndex && array[rightIndex] >= comparisedValue) {
                rightIndex--;
            }
            //是小值则交换左右指针指向的值
            if (array[rightIndex] < comparisedValue) {
                middleInt = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = middleInt;
            }
            //左指针比较
            //是小值则指针往前移动
            while (leftIndex < rightIndex && array[leftIndex] <= comparisedValue) {
                leftIndex++;
            }
            //是大值则交换左右指针指向的值
            if (array[leftIndex] > comparisedValue) {
                middleInt = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = middleInt;
            }
        }
        //（此时左右指针是相等的，即leftIndex==rightIndex）
        //以此时指针的位置划分为两个区间【sectionStart，leftIndex-1】和【rightIndex-1，sectionEnd】
        //如果右边区间还可再分,则继续轮询
        // =(leftIndex-1)-sectionStart>0
        if (leftIndex - 1 > sectionStart) {
            quickSort(array, sectionStart, leftIndex - 1);
        }
        if (rightIndex + 1 < sectionEnd) {
            quickSort(array, rightIndex + 1, sectionEnd);
        }
    }

    public static void swap(Integer[] array){
        Comparator cmp = new MyComparator();
        Arrays.sort(array);
        for (int num:array
             ) {
            System.out.println(num);
        }
    }
}
