class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        for(int a : nums2){
            set1.add(a);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int a : nums1){
            set2.add(a);
        }
        HashSet<Integer> unq1 = new HashSet<>(set2);
        unq1.removeAll(set1);
        HashSet<Integer> unq2 = new HashSet<>(set1);
        unq2.removeAll(set2);
        ans.add(new ArrayList<>(unq1));
        ans.add(new ArrayList<>(unq2));
        return ans;
    }
}