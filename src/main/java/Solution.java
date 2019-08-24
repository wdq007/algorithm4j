public class Solution {

    public int[] sort(int[] toBeSorted){

        int len = toBeSorted.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if (toBeSorted[j] > toBeSorted[j+1]){
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j+1];
                    //toBeSorted[j],toBeSorted[j+1] = toBeSorted[j+1],toBeSorted[j];
                    toBeSorted[j+1] = temp;
                }
            }
        }
        return toBeSorted;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] num = solution.sort(new int[]{1,9,7,2,3,5,4,8,6});

        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }
    }
}
