package com.eve.leetcode.medium.array;

import java.util.*;

/**
 * Created by Eve on 2022/8/25.
 */


/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。

 整数 a 比整数 b 更接近 x 需要满足：

 |a - x| < |b - x| 或者
 |a - x| == |b - x| 且 a < b
  

 示例 1：

 输入：arr = [1,2,3,4,5], k = 4, x = 3
 输出：[1,2,3,4]
 示例 2：

 输入：arr = [1,2,3,4,5], k = 4, x = -1
 输出：[1,2,3,4]
  

 提示：

 1 <= k <= arr.length
 1 <= arr.length <= 104
 arr 按 升序 排列
 -104 <= arr[i], x <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/find-k-closest-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _658_findClosestElement {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int index =  0;
        List<Integer> ans = new LinkedList<>();

        for(int i=1;i<arr.length;i++){

           if( x<= arr[0]){
               index=0;
               break;
           }else if(x>arr[arr.length-1]){
               index=arr.length-1;
               break;
           }else if(arr[i] >= x && arr[i-1] <= x){
               if((arr[i]-x)==(x-arr[i-1])){
                   index = i-1;
                   if(k==1){
                       ans.add(arr[index]);
                       return ans;
                   }
               }else{
                   index =  (arr[i]-x)<(x-arr[i-1])? i:i-1;
               }

               break;

           }
        }

        int left = index;
        int right= index+1;

        while(k>0){
            if(left<0){
                ans.add(arr[right]);
                right++;
                k--;
            }else if(right >=arr.length){
                ans.add(arr[left]);
                left--;
                k--;

            }else{
                if((x-arr[left]) == (arr[right] - x)){

                    if(k==1){
                        ans.add(arr[left]);
                        ans.sort(Comparator.comparing(Integer::intValue));
                        return ans;
                    }else{
                        k--;
                        ans.add(arr[left]);
                        left--;
                    }

                }else if((x-arr[left]) < (arr[right] - x)){

                    ans.add(arr[left]);
                    k--;
                    left--;

                } else if((x-arr[left]) > (arr[right] - x)){
                    ans.add(arr[right]);
                    k--;
                    right++;
                }
            }
        }

        ans.sort(Comparator.comparing(Integer::intValue));

        return ans;

    }


    public static void main(String[] args) {
        int[] arr =  new int[]{0,0,0,1,3,5,6,7,8,8};
        System.out.println(findClosestElements(arr,2,2));
    }
}
