class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //Brute force not valid in this case it is only able to find the first valid boats
        Arrays.sort(people);
        int count = 0;
        int left = 0, right = people.length - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            count+=1;
            right--;
        }
        return count;
    }
}