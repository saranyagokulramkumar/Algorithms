public class LC53_MaximumSubarray {
    public int[] maxSubArrayKadane(int[] nums){
        int subArraySum = nums[0];
        int maxSum = nums[0];
        int maxStart = 0, maxEnd = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > (subArraySum + nums[i])){
                maxStart = i;
                subArraySum = nums[i];
            }else{
                subArraySum += nums[i];
            }

            if(subArraySum > maxSum){
                maxEnd = i;
                maxSum = subArraySum;
            }
        }

        return new int[]{maxSum, maxStart, maxEnd};
    }

    public int maxSubArrayDivideAndConquer(int[] nums, int left, int right){
        // base case
        if(left == right)return nums[left];

        int mid = (left + right) / 2;

        int leftMax = maxSubArrayDivideAndConquer(nums, left, mid);
        int rightMax = maxSubArrayDivideAndConquer(nums, mid + 1, right);
        int crossMax = crossSubArrayMax(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int crossSubArrayMax(int[] nums, int left, int mid, int right){
        // find the max sum on the left side
        int leftSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for(int i = mid; i >= left; i--){
            tempSum += nums[i];
            leftSum = Math.max(leftSum, tempSum);
        }

        // find the right sum
        int rightSum = Integer.MIN_VALUE;
        tempSum = 0;
        for(int i = mid + 1; i <= right; i++){
            tempSum += nums[i];
            rightSum = Math.max(rightSum, tempSum);
        }

        // combine the results
        return leftSum + rightSum;
    }

}
