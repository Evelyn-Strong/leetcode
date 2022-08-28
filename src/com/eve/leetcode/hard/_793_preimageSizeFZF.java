package com.eve.leetcode.hard;

/**
 * Created by Eve on 2022/8/28.
 */

/**
 *  f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。

 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。
 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。

  

 示例 1：

 输入：k = 0
 输出：5
 解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
 示例 2：

 输入：k = 5
 输出：0
 解释：没有匹配到这样的 x!，符合 k = 5 的条件。
 示例 3:

 输入: k = 3
 输出: 5
  

 提示:

 0 <= k <= 109

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _793_preimageSizeFZF {

    //解题思路：
    //f(x+1) = f(x) * (x+1)
    //求解（x+1）中因子5的个数
    //但k的范围大，x会超过int，or long的区间，但是结果只会返回0：5

    public static int _preimageSizeFZF(int k) {
        int x=0;
        while(find0count(x)<k){
            x++;
        }
        return find0count(x)== k ? 5:0;
    }

    private static int find0count(int x){
        if(x<=0) return 0;
        return find0count(x-1)+find5(x);
    }

    private static int find5(int x){
        if(x<=0) return 0;
        int count = 0;
        while(x%5==0){
            x=x/5;
            count++;
        }
        return count;
    }

    /**
     * 参考答案，用了二分法优化
     */

    public int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    public long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (zeta(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public long zeta(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(_preimageSizeFZF(5));
    }
}
