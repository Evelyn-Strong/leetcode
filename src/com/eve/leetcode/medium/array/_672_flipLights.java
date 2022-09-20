package com.eve.leetcode.medium.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eve on 2022/9/15.
 */
public class _672_flipLights {

    //枚举法
    public static int flipLights(int n, int presses) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            s += "1";
        }

        Set<String> ans = new HashSet<>();
        ans.add(s);
        for (int i = 1; i <= presses; i++) {
            Set<String> tmp = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                changeStatus(j, ans, tmp);
            }
            ans = tmp;
        }
        return ans.size();
    }

    private static void changeStatus(int pressType, Set<String> ans, Set<String> tmp) {

        for (String status : ans) {
            String ns = "";
            char[] ch = status.toCharArray();
            int len = status.length();

            switch (pressType) {
                case 0: {
                    for (int i = 0; i < len; i++) {
                        ns = (ch[i] == '1' ? '0' : '1') + ns;
                    }
                    tmp.add(ns);
                    break;
                }
                case 1: {
                    for (int i = 0; i < len; i++) {
                        if (i % 2 == 0) {
                            ns += (ch[i] == '1' ? '0' : '1');
                        } else {
                            ns += ch[i];
                        }

                    }
                    tmp.add(ns);
                    break;
                }
                case 2: {
                    for (int i = 0; i < len; i++) {
                        if (i % 2 == 1) {
                            ns += (ch[i] == '1' ? '0' : '1');
                        } else {
                            ns += ch[i];
                        }

                    }
                    tmp.add(ns);
                    break;
                }
                case 3: {
                    for (int i = 0; i < len; i++) {
                        if (i % 3 == 0) {
                            ns += (ch[i] == '1' ? '0' : '1');
                        } else {
                            ns += ch[i];
                        }

                    }
                    tmp.add(ns);
                    break;
                }
                default:
                    break;
            }
        }


    }
    //4种开关只影响6个灯, 后面都是重复的

    /**
     * 我们设六盏灯的编号为6k+1、6k+2、6k+3、6k+4、6k+5、6k+6，则
     * <p>
     * 6k+1会受到1、3、4开关的影响
     * 6k+2会受到1、2开关的影响
     * 6k+3会受到1、3开关的影响
     * 6k+4会受到1、2、4开关的影响
     * 6k+5会受到1、3开关的影响
     * 6k+6会受到1、2开关的影响
     * 由于6k+2和6k+6都受到1、2开关的影响，因此两盏灯的状态一致
     * 由于6k+3和6k+5都受到1、3开关的影响，因此两盏灯的状态一致
     *
     *
     *
     * 因此我们只需要观察前4盏灯的状态。

     进一步，我们设按下4种开关的次数分别为a、b、c、d，由于偶数次按压相当于没按，所以有
     ①6k+1的状态为(a + c + d) % 2
     ②6k+2的状态为(a + b) % 2
     ③6k+3的状态为(a + c) % 2
     ④6k+4的状态为(a + b + d) % 2

     由于①和③都受到1、3开关的影响，所以若①③状态相同，则d必然为偶数；若①③状态不同，则d必然为奇数

     由于②和④都受到1、2开关的影响，并且④和d有关系，所以若d为偶数，则②④状态相同；若d为奇数，则②④状态不同

     所以我们可以通过①②③的状态来确定④的状态

     因此我们只需要观察前3盏灯的状态。

     设前三盏灯开始的状态为111，我们最开始枚举状态，最多也就8种（每个灯只有亮和不亮）


     以此类推，011可以由111获得，因此当presses >= 3时 可以获得8种

     综上：
     当n == 1时，开关1、3、4对其造成影响，也只有开和关两种状态
     当n == 2时，按照推理111的状态推理11，按一次有3种，按2次及以上有4种。
     当n == 3时，按一次有4种，按2次及以上有7种,3次及以上有8种。

     作者：capital-worker
     链接：https://leetcode.cn/problems/bulb-switcher-ii/solution/dengp-by-capital-worker-51rb/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param presses
     * @return
     */
    public static int _flipLights(int n, int presses) {

        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

    public static void main(String[] args) {
        System.out.println(flipLights(5, 2));

        int MOD = 1000000007;
    }

}
