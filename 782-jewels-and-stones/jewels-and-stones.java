class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewls = new HashSet<>();

        
        int size = jewels.length();

        for (int i =0; i < size; i++){
            jewls.add(jewels.charAt(i));
        }

        int count = 0;

        size = stones.length();


        for (int i =0; i < size; i++){
            if (jewls.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}