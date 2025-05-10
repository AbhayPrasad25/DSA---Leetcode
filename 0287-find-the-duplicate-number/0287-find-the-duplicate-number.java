class Solution {
    public int findDuplicate(int[] nums) {
        //Brute force - iterate the array for each element and check if contains the same element
        //better approach - sort the array and check if the any of 2 consecutive pairs are same 
        //Optimal approach - use xor operation to find the repeated element 
        HashSet<Integer> set = new HashSet<>();
        int repeat = 0;
        for(int a :nums){
            if(!set.contains(a)){
                set.add(a);
            }
            else{
                repeat = a;
                break;
            }
        }
        return repeat;
    }
}