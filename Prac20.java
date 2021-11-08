//Shortest Unsorted Continuous Subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                start = i-1;
                break;
            }
        }
        int end = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] > nums[i + 1]) {
                end = i + 1;
                break;
            }
        }
        // System.out.println("1st start" +start);
        // System.out.println("1st end" +end);
        if(start - end == 1) {
            return 2;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
//         if(min < nums[0]) {
//             start = 0;
//         }
//         if(max > nums[nums.length - 1]) {
//             end = nums.length - 1;
//         }
        
        for(int i = start; i >= 0; i--) {
            if(min >= nums[i]) {
                continue;
            } else {
                start = i;
            }
            
        }
        
        for(int i = end; i < nums.length - 1; i++) {
            if(max <= nums[i + 1]) {
                continue;
            } else {
                end = i + 1;
            }
            
        }
        if(start == end) {
            return 0;
        }
        return end - start + 1;
    }
}

//Merge inbetween linked list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode head2 = list2;
        
        while(list2.next != null) {
            list2 = list2.next;
        }
        ListNode prev = null;
        ListNode current = list1;
        while(count <= b) {
            if(count == a) {
                prev.next = head2;
            }
            if(count == b) {
                list2.next = current.next;
                current.next = null;
            }
            prev = current;
            current = current.next;
            count++;
        }
        return list1;
    }
}

