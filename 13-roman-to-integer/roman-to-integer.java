class Solution {
    public int romanToInt(String s) {
        

    HashMap<String, Integer> map = new HashMap<>();

    map.put("I", 1);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("X", 10);
    map.put("IX", 9);
    map.put("L", 50);
    map.put("XL", 40);
    map.put("C", 100);
    map.put("XC", 90);
    map.put("D", 500);
    map.put("CD", 400);
    map.put("M", 1000);
    map.put("CM", 900);


    int n = 0;

    int i = s.length() - 1;
    
    while (i > 0){


        if(map.containsKey(s.substring(i-1,i+1))){

            n += map.get(s.substring(i-1,i+1));
            i -= 2;
        }
        else{
            n += map.get(s.substring(i,i+1));
            i--;
        }
    }
    if (i == 0){
    n += map.get(s.substring(0,1));


    }


    return n;


    }
}