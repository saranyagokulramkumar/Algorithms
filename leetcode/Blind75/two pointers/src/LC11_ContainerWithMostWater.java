/*
**Approaches**
1. Brute force
*  Calculate area between each pair of lines in the input array
*  Maintain a global maximum and return this

*Time complexity* - O(N^2)
*Space complexity* - O(1)

2. Two pointer approach
*  Maintain a global max
*  Idea is that the longer the distance between the two numbers, the possibility of large area is high. So we go from the ends of the array for the two pointers
*  The area for any given two lines is limited by the shorter edge so take the minimum of the two edges and multiply it with the distance between the two
*  Update maxArea if current area is greater
*  Move the pointer pointing to the shorter line towards the other
*  Return maxArea at the end when start is no longer < end

*Time complexity* - O(N)
*Space complexity* - O(1)
 */
public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int length = height.length;
        int start = 0;
        int end = length - 1;

        while(start < end){
            maxArea = Math.max(maxArea, Math.min(height[start],height[end]) * (end - start));

            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }
}
