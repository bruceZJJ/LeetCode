/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * */

package No1.两数之和;

import java.util.HashMap;
import java.util.Map;
/*
 * @author zhanjj
 * @date 2018/12/1 22:23
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 使用HashMap来存储，key：数值，value：数组索引
        Map <Integer,Integer> num = new HashMap();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果map中存在target减去当前遍历的值，则返回两个数的下标；否则将<数，索引>插入map中
            if (num.containsKey(target - nums[i])) {
                return new int[] {num.get(target - nums[i]),i};
            } else {
                num.put(nums[i],i);
            }
        }
        return new int[] {0,0};
    }
}
