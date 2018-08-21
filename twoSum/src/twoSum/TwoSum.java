package twoSum;

import java.util.HashMap;
import java.util.Map;
/**
 *题目：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *示例:
 *给定 nums = [2, 7, 11, 15], target = 9
 *因为 nums[0] + nums[1] = 2 + 7 = 9
 *所以返回 [0, 1]
 * @author wbs
 * 2018-08-21
 */
public class TwoSum {
	
    //暴力法
	public  int[] twoSum(int[] nums,int target) {
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]==target-nums[i]){
					return new int[]{i,j};
				}
			}
		}
		throw new IllegalArgumentException("No Two sum solution");
	}
	
	
//两遍哈希表
	public int[] twoSum1(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	
	//一遍哈希表
	public int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };//map.get(complement)返回的是complement的下标
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	
	public static void main(String[] args) {
		TwoSum twoSum=new TwoSum();
		int []result=new int[2];
		int []num={2,7,11,15,19,23,27,33,77};
		result=twoSum.twoSum(num,110);
		System.out.println("[ "+result[0]+"  "+result[1]+" ]");
	}	
}
