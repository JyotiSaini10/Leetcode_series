// 20. Valid Parentheses

import java.util.Scanner;
import java.util.Stack;

class Problem_20 {
    public static boolean isValid(String s) {
        
        Stack<Character> st= new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c =='(' || c=='[' || c=='{'){
                st.push(c);
            }else{
                if(st.empty()){
                    return false;
                }
                char ch= st.peek();

                if(c==')' && ch=='(')
                    st.pop();
                else if(c==']' && ch=='[')
                    st.pop();
                else if(c=='}' && ch=='{')
                    st.pop();
                else{
                    return false;
                }
                
            }
        }
        return st.empty();
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        if (isValid(s)) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Invalid Parentheses");
        }

        sc.close();
    }

}