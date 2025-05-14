class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] successArray = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++){
            successArray[i] = leastsuc(spells[i] , potions , success);
        }
        return successArray;
    }
    private int leastsuc(int spell, int[] potions, long success){
        int count = 0;
        int left = 0;
        int right = potions.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            long power =  1L * spell * potions[mid];
            if(power >= success){
                count += (right - mid + 1);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return count;
    }
}