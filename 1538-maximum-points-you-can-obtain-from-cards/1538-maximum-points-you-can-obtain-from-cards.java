class Solution {
    public int maxScore(int[] cardScore, int k) {
        int totsum = 0;
        for(int score : cardScore){
            totsum += score;
        }
        int minSize = cardScore.length - k;
        int scoreSum = 0;
        for(int i = 0; i < minSize; i++){
            scoreSum += cardScore[i];
        }
        int index = minSize;
        int curSum = scoreSum;
        int left = 0;
        while(index < cardScore.length){
            curSum += cardScore[index];
            curSum -= cardScore[left];
            scoreSum = Math.min(scoreSum , curSum);
            index++;
            left++; 
        }
        return totsum - scoreSum;
    }
}