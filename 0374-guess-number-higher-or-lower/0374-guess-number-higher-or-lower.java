/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long left = 1;
        long right = n;
        long num = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (guess((int) mid) >= 0) {
                left = mid + 1;
                num = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int)num;
    }
}