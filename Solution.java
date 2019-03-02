package LintCode;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		int[] nums1 = {};
		int[] nums2 = {2,3};
		System.out.print("result = " + findMedianSortedArrays(nums1, nums2));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0;
        int i2 = 0;
        int count = 0;
        int length = nums1.length + nums2.length;
        int[] arr_all = new int[length];

        while(i1 < nums1.length || i2 < nums2.length) {
        	System.out.println("i1 = " + i1 + ", i2 = " + i2 );
            if(i1 >= nums1.length){
               for(int i = i2; i < nums2.length; i++) {
                  arr_all[count] = nums2[i];
                   count++;
               }
                i2 = nums2.length;
                System.out.println("copy nums2: arr_all = " + Arrays.toString(arr_all));
                continue;
            }
            if(i2 >= nums2.length){
               for(int i = i1; i < nums1.length; i++) {
                   arr_all[count] = nums1[i];
                   count++;
               }
                i1 = nums1.length;
                System.out.println("copy nums1: arr_all = " + Arrays.toString(arr_all));
                continue;
            }
            if(nums1[i1] <= nums2[i2]) {
               arr_all[count] = nums1[i1];
               System.out.println("copy "+nums1[i1]+": arr_all = " + Arrays.toString(arr_all));
                i1++;
                count++;
                
            } else {
               arr_all[count] = nums2[i2];
               System.out.println("copy "+nums2[i2]+": arr_all = " + Arrays.toString(arr_all));
                i2++;
                count++;
                
            }
        }
        if(length % 2 == 0){
            return (arr_all[(length-1)/2] + arr_all[(length-1)/2+1])/2.0;
        } else {
        	return (arr_all[(length-1)/2]);
        }
    }
    
}
