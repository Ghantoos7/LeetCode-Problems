class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String operation : operations){

            if ( operation.equals("+") ){

                int num1 = st.pop();
                int num2 = st.pop();
                
                st.push(num2);
                st.push(num1);
                st.push(num1+num2);
            }

            else if ( operation.equals("D") ){
                
                int num = st.pop();
                st.push(num);
                st.push(num * 2);


            }

            else if ( operation.equals("C") ){

                st.pop();
            }

            else{

                st.push(Integer.parseInt(operation));
            }
        }

        int sum = 0;

        while ( !st.isEmpty()){

            sum += st.pop();
        }

        return sum;
    }
}