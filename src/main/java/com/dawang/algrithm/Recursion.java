package com.dawang.algrithm;
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
     * @return
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
     * 递归表达式(规律):
     * 将数组第一个数->2与数组后面的数->{3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2}进行切割
     * 将数组后面的数看成是一个整体X={3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2}
     * 就可以看成是第一个数和一个整体进行比较if(2>X) return 2 else(2<X) return X
     * 找出这个整体的最大值与2进行比较。找出整体的最大值又是和我们的初始目的(找出最大值)是一样的
     * 也就可以写成if( 2>findMax() )return 2 else return findMax()
     *
     * 递归出口: 如果数组只有1个元素时，那么这个数组最大值就是它了。
     *
     * 通常为数组设定左边界和右边界，这样比较好地进行切割
     * L表示左边界，往往表示的是数组第一个元素，也就会赋值为0(角标为0是数组的第一个元素)
     * R表示右边界，往往表示的是数组的长度，也就会赋值为arrays.length-1（长度-1在角标中才是代表最后一个元素)
     * 递归，找出数组最大的值

     * @param sample 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return
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


    public static int[] sort(int[] array){
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
        return array;
    }
    /**
     * 冒泡排序
     * 当第一趟排序后，我们可以将数组最后一位(R)和数组前面的数(L,R-1)进行切割
     * 数组前面的数(L,R-1)看成是一个整体
     * 递归出口：当只有一个元素时，即不用比较了：L==R
     * @param array 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return
     */


    public static int[] recureSort(int[] array,int L, int R){

        if (L == R){
            return array;

        }else{


        }


    }
    public static void main(String[] args) {

        System.out.println("非递归求和： " + sum(4));
        System.out.println("递归求和： " + recurSum(4));
        System.out.println("****************************");

        int[] sample = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2};
        System.out.println("非递归求数组最大值： " + max(sample));
        System.out.println("递归求数组最大值: " + recurMax(sample,0,sample.length-1));

        System.out.println("****************************");
        int[] arr = {2,1,9,8,7,4,5,3,6};
        int[] result = sort(arr);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }

    }


}



