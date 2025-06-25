class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] el = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stck = new Stack<>();
        for(int i = nums2.length -1; i >= 0; i--){
            while(!stck.isEmpty() && nums2[i] >= stck.peek()){
                stck.pop();
            }
            if(stck.isEmpty()){
                map.put(nums2[i] , -1);
            }
            else{
                map.put(nums2[i] , stck.peek());
            }
            stck.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            el[i] = map.get(nums1[i]);
        }
        return el;
    }
}