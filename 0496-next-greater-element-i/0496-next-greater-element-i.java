class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] el = new int[nums1.length];
        for(int i = nums1.length - 1; i >= 0; i--){
            Stack<Integer> stck = new Stack<>();
            for(int j = nums2.length - 1; j >= 0; j--){
                while(!stck.isEmpty() && nums2[j] >= stck.peek()){
                    stck.pop();
                }
                if(nums1[i] == nums2[j]){
                    if(stck.isEmpty()){
                        el[i] = -1;
                    }
                    else{
                        el[i] = stck.peek();
                    }
                    break;
                }
                stck.push(nums2[j]);
            }
        }
        return el;
    }
}