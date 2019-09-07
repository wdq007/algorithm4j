//:algorithm/Recursion.java
package com.dawang.algorithm;

import java.util.Arrays;

/**
 * @author Wang Daquan
 * @author wangdaquan@yeah.net
 *
 *
 *
 */

public class Recursion {
/**
 * https://www.jianshu.com/p/104187c62e15
 * 递归在程序语言中简单的理解是：方法自己调用自己
 * 递归其实和循环是非常像的，循环都可以改写成递归，递归未必能改写成循环，这是一个充分不必要的条件。
 * 那么，有了循环，为什么还要用递归呢？？在某些情况下(费波纳切数列，汉诺塔)，使用递归会比循环简单很多很多
 * 想要用递归必须知道两个条件：
 * 递归出口(终止递归的条件)
 * 递归表达式(规律)
 * 技巧：在递归中常常是将问题切割成两个部分(1和整体的思想)，这能够让我们快速找到递归表达式(规律)
 * @param n 任意整数
 * @return 返回整数
 */



    public static int sum(int n){
        int total = 0;
        for (int i=1;i<n+1;i++){
            total = total +i;
        }
        return total;
    }

    /**
     * 1+2+3+4+....+100(n)求和
     * 递归出口：很多， if(n=1) return 1 或 if(n=4) return 10
     * 递归表达式(规律)：
     * 可以假设X=1+2+3+...+n，可以将1+2+3+...+(n-1)看成是一个整体。
     * 这个整体做的事又和我们的初始目的(求和)相同。
     * 以我们的高中数学知识我们又可以将上面的式子看成X=sum(n-1)+n
     *
     * @param n 要加到的数字，比如题目的100
     * @return 整数
     */
    public static int recurSum(int n){
        if(n == 1){
            return 1;
        }else{
            return n + recurSum(n-1);
        }
    }


    public static int max(int[] sample) {
        int max = sample[0];
        for (int i = 1; i < sample.length; i++) {
            if (sample[i] > max) {
                max = sample[i];
            }

        }
        return max;
    }

    /**
     * int[] arrays = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2};
     * {@code 递归表达式(规律):
     * 将数组第一个数->2与数组后面的数->{3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2}进行切割
     * 将数组后面的数看成是一个整体X={3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2}
     * 就可以看成是第一个数和一个整体进行比较if(2>X) return 2 else(2<X) return X
     * 找出这个整体的最大值与2进行比较。找出整体的最大值又是和我们的初始目的(找出最大值)是一样的
     * 也就可以写成if( 2>findMax() )return 2 else return findMax()
     * }
     * 递归出口: 如果数组只有1个元素时，那么这个数组最大值就是它了。
     *
     * 通常为数组设定左边界和右边界，这样比较好地进行切割
     * L表示左边界，往往表示的是数组第一个元素，也就会赋值为0(角标为0是数组的第一个元素)
     * R表示右边界，往往表示的是数组的长度，也就会赋值为arrays.length-1（长度-1在角标中才是代表最后一个元素)
     * 递归，找出数组最大的值

     * @param sample 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return 整数
     */

    public static int recurMax(int[] sample,int L, int R){
        if(L == R){
            return sample[L];
        }else{
            int a = sample[L];
            int b = recurMax(sample,L+1,R);
            if (a>b){
                return a;
            }else {
                return b;
            }
        }

    }


    public static void sort(int[] array){
        int len = array.length;
        for(int i =0;i<len;i++){
            for(int j =0;j<len-i-1;j++ ){
                if(array[j]> array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        //return array;
    }
    /**
     * 冒泡排序
     * 当第一趟排序后，我们可以将数组最后一位(R)和数组前面的数(L,R-1)进行切割
     * 数组前面的数(L,R-1)看成是一个整体
     * 递归出口：当只有一个元素时，即不用比较了：L==R
     * @param array 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     */


    public static void recurSort(int[] array,int L, int R){
        int temp;
        if (L == R);


        else {
            for (int i = L; i < R; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

            recurSort(array, L, R - 1);
        }



    }


    /**
     * 斐波那契数列（Fibonacci sequence），又称黄金分割数列.
     * 因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”.
     * 指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
     * {@code 在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）}
     *
     * @param  n 整数
     * @return 长整数
     */

    public static long fibonacci(int n){

        if (n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            return (fibonacci(n-1)+fibonacci(n-2));
        }


    }

    public static long[] fibonacciArray(int n){
        long[] array = new long[n];
        for (int i=1;i<n+1;i++){
            array[i-1] = fibonacci(i);
        }
        return array;
    }

    /**
     * 汉诺塔 Tower of Hanoi
     * 印度的古老传说：在世界中心贝拿勒斯（在印度北部）的圣庙里，一块黄铜板上插着三根宝石针。
     * 印度教的主神梵天在创造世界的时候，在其中一根针上从下到上地穿好了由大到小的64片金片，这就是所谓的汉诺塔。
     * 不论白天黑夜，总有一个僧侣在按照下面的法则移动这些金片：一次只移动一片，不管在哪根针上，小片必须在大片上面。
     * 僧侣们预言，当所有的金片都从梵天穿好的那根针上移到另外一根针上时，世界就将在一声霹雳中消灭，而梵塔、庙宇和众生也都将同归于尽。
     * 假设有n片，移动次数是f(n).显然f(1)=1,f(2)=3,f(3)=7，且f(k+1)=2*f(k)+1。此后不难证明f(n)=2^n-1。
     * n=64时，假如每秒钟一次，共需多长时间呢？一个平年365天有31536000 秒，闰年366天有31622400秒，平均每年31556952秒，计算一下：
     * 18446744073709551615秒
     * 这表明移完这些金片需要5845.54亿年以上
     * @param n n个盘子
     * @param start 起始柱子
     * @param transfer 中转柱子
     * @param target 目标柱子
     *
     */
    public static void hanoi(int n,char start,char transfer,char target){
        //只有一个盘子，直接搬到目标柱子
        if (n == 1){
            System.out.println(start+"---#--->"+target);
        }else{
            //起始柱子借助目标柱子将盘子都移动到中转柱子中(除了最大的盘子)
            hanoi(n-1,start,target,transfer);
            System.out.println(start+"---*--->"+target);
            //中转柱子借助起始柱子将盘子都移动到目标柱子中
            hanoi(n-1,transfer,start,target);
        }

    }
    public static void main(String[] args) {

        System.out.println("非递归求和： " + sum(4));
        System.out.println("递归求和： " + recurSum(4));
        System.out.println("****************************");

        int[] sample = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2};
        System.out.println("非递归求数组最大值： " + max(sample));
        System.out.println("递归求数组最大值: " + recurMax(sample,0,sample.length-1));

        /**
         *打印数组Array.ToString()
         * https://www.jianshu.com/p/510dc769ae09
         */

        System.out.println("****************************");
        int[] sortArray = {2,1,9,80,7,4,5,31,66};
        System.out.println("冒泡排序：排序之前："+Arrays.toString(sortArray));
        int[] arr = sortArray;
        sort(arr);
        System.out.println("冒泡排序循环方式："+Arrays.toString(arr));
        System.out.println("****************************");
        int[] newArr = sortArray;
        recurSort(newArr,0,newArr.length-1);
        System.out.println("冒泡排序递归方式： "+Arrays.toString(newArr));
        System.out.println("****************************");

        System.out.println("斐波那契数列的第n个值"+fibonacci(8));
        System.out.println("斐波那契数列"+Arrays.toString(fibonacciArray(8)));
        System.out.println("****************************");
        System.out.println("汉诺塔");
        hanoi(4,'A','B','C');


    }


}
/* Output: (55% match)

*/
///:~




