class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int plant = 0;
        int size = flowerbed.length;
        while (plant < size) {
            boolean emptyleft = (plant == 0 ? true : flowerbed[plant - 1] == 0);
            boolean emptyright = (plant == size - 1 ? true : flowerbed[plant + 1] == 0);
            if (flowerbed[plant] == 0) {
                if (emptyleft && emptyright) {
                    flowerbed[plant] = 1;
                    n--;
                    if(n == 0){
                        return true;
                    }
                }
                plant += (plant + 2 == size || emptyright == false) ? 1 : 2;

            } else {
                plant += 2;
            }
        }
        return n <= 0;
    }
}