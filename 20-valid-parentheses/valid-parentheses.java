class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stck = new Stack<>();
        HashMap<Character, Character> paran = new HashMap<>();

        paran.put(')','(');
        paran.put('}','{');
        paran.put(']','[');

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stck.push(c);
            }
            else{
                
                if (stck.empty() || paran.get(c) != stck.peek()){
                    return false;
                }

                else{
                    stck.pop();
                }
        }
        }

        return stck.empty();


    }
}