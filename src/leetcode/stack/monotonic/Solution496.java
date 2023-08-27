package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution496 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
