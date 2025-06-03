class Solution {
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        maped(map);
        int size = calculatesize(num);
        while(size >= 0){
            int n = num / (int)Math.pow(10, size);
            if(n == 0){
                size--;
                continue;
            }
            int val = n * (int)Math.pow(10, size);
            if(map.containsKey(val)){
                str.append(map.get(val));
            }
            else{
                int place = (int)Math.pow(10 , size);
                if(val > 5 * place){
                    str.append(map.get(5 *  place));
                    int newVal = val - (5 * place);
                    while(newVal > 0){
                        str.append(map.get(place));
                        newVal -= place;
                    }
                }
                else{
                    while(val > 0){
                        str.append(map.get(place));
                        val -= place;
                    }
                }
            }
            num %= (int)(Math.pow(10, size));
            size--;
        }
        return str.toString();
    }
    private int calculatesize(int num){
        int size = 0;
        while(num > 0){
            size++;
            num/=10;
        }
        return size;
    }
    private void maped(HashMap<Integer, String> map){
        map.put(1 , "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
}