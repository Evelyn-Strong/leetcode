package com.eve.leetcode.medium.search;

/**
 * Created by Eve on 2022/8/15.
 */
public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        //二分再二分
        //先确定行，再确定列
        int r = 0;
        boolean res =  false;
        for(;r<matrix.length;r++){

            if(matrix[r][0] == target || matrix[r][matrix[0].length-1] == target)return true;

            if(matrix[r][0]< target && matrix[r][matrix[0].length-1]> target){
                int c = searchHalf(matrix[r],target,0,matrix[0].length-1);
                if(c != -1 ) return true;

            }

        }
        return res;


    }

    private static int searchHalf(int[] nums, int target, int left, int right){

        if(right == left) return -1;
        if((right - left) == 1){
            return (nums[right] == target || nums[left] == target)? left: -1;
        }

        int mid =  (right - left )/2 + left;

        if(target == nums[mid] ) return mid;
        if(target < nums[mid]){
           return  searchHalf(nums,target,left,mid);
        }
        if(target > nums[mid]){
           return searchHalf(nums,target,mid,right);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{-1,3}};
        int target = 3;

        System.out.println(searchMatrix(nums,target));
    }
}
