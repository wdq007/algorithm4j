package com.dawang.demo;


import java.util.Arrays;

public class Recap {


    public static int sum(int n){
        int num=0;
        for (int i=1;i<=n;i++){
            num= num + i;

        }
        return num;


    }
    public static int recurSum(int n){
        if (n == 1){
            return 1;
        }else{
            return recurSum(n-1)+n;
        }
    }

    public static int max(int[] nums){
        int len = nums.length;
        int max = nums[0];
        for(int i = 1;i<len;i++){
            if (nums[i] >max){
                max = nums[i];
            }
        }
        return max;
    }

    public static int recurMax(int[] nums,int L,int R){
        if ( L == R ){
            return nums[L];
        }else{
            int current = nums[L];
            int next = recurMax(nums,L+1,R);
            if(current > next){
                return current;

            }else{

                return next;
            }
        }
    }

    public static int[] bubbleSort(int[] arr){
        int len = arr.length-1;
        for (int i=0;i<len;i++){
            for(int j=0;j<len-i;j++){
                if(arr[j]> arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }


            }
        }
        return arr;
    }

    /**
     * {3,1,4,2}  L==R return arr;arr[L] > arr[R], temp = arr[L]
     * 4-> 0,1,2,3
     *  i =0, j =0,1,2,3 arr[0] = 3
     * 3 1 =>1 3
     * 3 4 =>3 4
     * 4 2 => 2 4
     * 1 3 2 4   i =1;j=0,1,2 arr[0]=1
     *  1 3 > 1 3
     *  32 > 23
     *  34 = >34
     * 1234 i = 2;j=0,1
     *  1 2  12
     *  2 3 23
     * 1234 i =3;j=0
     * 1 2 12
     * @param arr
     * @return
     */
    public static int[] recurBubbleSort(int[] arr,int L,int R){
        int temp;
        if(L == R){
            return arr;
        }else{
            for(int i=L;i<R;i++){
                if(arr[i]>arr[i+1]){
                    temp = arr[i+1];
                    arr[i+1]= arr[i];
                    arr[i] = temp;
                }
            }
            recurBubbleSort(arr,L,R-1);
        }

        return arr;
    }

    /**
     *  1 1 2 3 5 8 13 21
     */

    public static int fibo(int n){
        // ifbo(n-1) + fibo(n -2)
        if (n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            return fibo(n-1)+fibo(n-2);
        }

    }
    /*
    i = 1>1, i = 2>1; i=3>3-1+3-2 = 3 i=4>4-1 +4-2 = 8-3 =5

    public static int fibonacci(int n){
        int sum=0;
        for(int i =0;i<n;i++){
            if(i == 1){
                sum = 1;
            }else if(i == 2){
                 sum = 1;
            }else{
                sum = (i-1+i-2);
            }
        }
        return sum;
    }

    */

    /**
     * 1 A >C
     * 2 A -> B A -> C B -> C
     * 3
     * a-c a -b c- b a-c b-c
     *
     * @param plate
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int plate,int A,int B,int C){

        if (plate == 1){
            System.out.println(A + "-->" + C);
        }else{
            System.out.println(A+""+C);
            System.out.println(B +""+C);
        }

    }

    public static void main(String[] args){
        int[] nums = {1,388,6,79,66,34,9};
        System.out.println(Integer.valueOf(recurMax(nums,0,nums.length-1)));
        System.out.println(Arrays.toString(recurBubbleSort(nums,0,nums.length-1)));
        System.out.println(fibo(8));
        //System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
    }
}
