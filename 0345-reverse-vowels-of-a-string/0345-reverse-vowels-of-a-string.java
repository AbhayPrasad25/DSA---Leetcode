class Solution {
    public String reverseVowels(String s) {
        char [] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            if(!isVowel(array[left])){
                left++;
            }
            else if(!isVowel(array[right])){
                right--;
            }
            else{
                char c = array[left];
                array[left] = array[right];
                array[right] = c;
                left++;
                right--;
            }
        }
        String st = String.valueOf(array);
        return st;
    }
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c== 'o' ||c == 'u'|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}