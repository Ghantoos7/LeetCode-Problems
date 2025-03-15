class Solution {
    public String removeOuterParentheses(String s) {
        
        Stack<Character> st = new Stack<>();

        HashSet<Integer> hs = new HashSet<Integer>();


        int n = s.length();
        int i = 0;


        while ( i < n ){

            st.push(s.charAt(i));
            hs.add(i);

            i++;

            while (!st.isEmpty())

                if (s.charAt(i) == ')'){

                    st.pop();

                    if (st.isEmpty()){
                        hs.add(i);
                    }
                    i++;
                }

                else{
                    
                    st.push('(');
                    i++;
                }

            
        }


        String to_return = "";

        for (i = 0; i < n; i++){

            if (hs.contains(i)){

                continue;
            }
            else{

               to_return += s.charAt(i); 
            }
        }

        return to_return;
        
    }
}