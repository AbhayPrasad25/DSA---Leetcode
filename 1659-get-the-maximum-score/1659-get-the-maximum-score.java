class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int modulo_amt = 1000000007;
        long result = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ptr1 = 0, ptr2 = 0;
        long subSection1 = 0, subSection2 = 0;
        while(ptr1 < n1 && ptr2 < n2){
            if(nums1[ptr1] == nums2[ptr2]){
                result += Math.max(subSection1 , subSection2) + nums2[ptr2];
                result %= modulo_amt;
                subSection1 = 0;
                subSection2 = 0;
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1] > nums2[ptr2]){
                subSection2 += nums2[ptr2];
                ptr2++;
            }
            else{
                subSection1 += nums1[ptr1];
                ptr1++;
            }
        }
        while(ptr1 < n1){
            subSection1 += nums1[ptr1];
            ptr1++;
        }
        while(ptr2 < n2){
            subSection2 += nums2[ptr2];
            ptr2++;
        }
        result += Math.max(subSection1, subSection2);
        return (int)(result % modulo_amt);
    }
}