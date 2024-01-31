class Solution {
    public boolean halvesAreAlike(String s) {

        HashSet<Character> vowels = new HashSet<>();

        vowels.add('A');
        vowels.add('O');
        vowels.add('E');
        vowels.add('I');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');


        int size = s.length();

        int mid = size / 2;

        int left_count = 0;
        int right_count = 0;

        for (int i = 0,j = mid; i < mid && j < size; i++, j++){

            if (vowels.contains(s.charAt(i))){
                left_count++;
            }

              if (vowels.contains(s.charAt(j))){
                right_count++;
            } 
        }

        return left_count == right_count;
        
    
    }
}