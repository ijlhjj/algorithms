package com.sweetmanor.exams.greedy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例7-2：集合覆盖问题
 *
 * <p>
 * 假设你办了个广播节目，要让全美50个州的听众都能收听到。
 * 为此，你需要决定在哪些广播台播出这个节目。
 * 在每个广播台播出都需要支付费用，所以要在尽可能少的广播台播出。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-25
 */
public class SetCover {

    /**
     * 每次都优先选择可覆盖最多未覆盖州的广播台
     */
    public Set<String> getBestBroadCasts(Set<String> allStates, Map<String, Set<String>> broadCasts) {
        Set<String> bestBroadCasts = new HashSet<>(); //最优结果集合

        //州集合未被全部覆盖时继续处理
        while (!allStates.isEmpty()) {
            Set<String> maxCovered = new HashSet<>(); //最多可覆盖
            String bestBroadCast = null; //最多覆盖电台的key值

            //循环电台集合
            for (var kv : broadCasts.entrySet()) {
                //当前电台可覆盖的未覆盖州
                Set<String> covered = new HashSet<>(kv.getValue());
                covered.retainAll(allStates);

                //可覆盖更多时更新
                if (covered.size() > maxCovered.size()) {
                    maxCovered = covered;
                    bestBroadCast = kv.getKey();
                }
            }

            bestBroadCasts.add(bestBroadCast); //增加本次覆盖最多的电台
            broadCasts.remove(bestBroadCast); //电台映射中去除当前电台
            allStates.removeAll(maxCovered); //剩余未覆盖集合减去本次处理
        }

        return bestBroadCasts;
    }

}
