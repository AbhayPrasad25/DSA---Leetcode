class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        for(int a : nums2){
            set1.add(a);
        }
        List<Integer> ans1 = new ArrayList<>();
        for(int a : nums1){
            if(!set1.contains(a) && !ans1.contains(a)){
                ans1.add(a);
            }
        }
        ans.add(ans1);
        HashSet<Integer> set2 = new HashSet<>();
        for(int a : nums1){
            set2.add(a);
        }
        List<Integer> ans2 = new ArrayList<>();
        for(int a : nums2){
            if(!set2.contains(a) && !ans2.contains(a)){
                ans2.add(a);
            }
        }
        ans.add(ans2);
        return ans;
    }
}