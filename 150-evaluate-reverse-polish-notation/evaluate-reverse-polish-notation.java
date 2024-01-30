class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> op = new Stack<String>();
        HashSet<String> operators = new HashSet<String>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for (String token : tokens) {
            if (operators.contains(token)) {
                int operand2 = Integer.valueOf(op.pop());
                int operand1 = Integer.valueOf(op.pop());
                int result = 0;

                if (token.equals("+")) {
                    result = operand1 + operand2;
                } else if (token.equals("-")) {
                    result = operand1 - operand2;
                } else if (token.equals("*")) {
                    result = operand1 * operand2;
                } else if (token.equals("/")) {
                    result = operand1 / operand2;
                }

                op.push(String.valueOf(result));
            } else {
                op.push(token);
            }
        }

        return Integer.valueOf(op.pop());
    }
}