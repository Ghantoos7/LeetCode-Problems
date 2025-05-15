class Solution {
    public int countAsterisks(String s) {
        

        boolean inside_a_pair = false;
        int count = 0;

        for (char c : s.toCharArray()){

            if (c == '|') {

                inside_a_pair = !inside_a_pair;
            }

            if (!inside_a_pair && c == '*' ){

                count++;
            }
        }

        return count;
    }
}