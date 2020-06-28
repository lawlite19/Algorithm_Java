package leetcode.cn;

public class L001_两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;


        L001_两数之和 sum = new L001_两数之和();
        int result[] = sum.twoSum(nums, target);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = {0, 0};
        int i, j;
        outer:
            for(i=0; i<nums.length; i++) {
                for(j=i+1; j<nums.length; j++) {
                    if (target == nums[i] + nums[j]) {
                        res[0] = i;
                        res[1] = j;
                        break outer;
                    }
                }
            }
        return res;
    }
}
