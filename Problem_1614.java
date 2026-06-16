
// 1614. Maximum Nesting Depth of the Parentheses

public class Problem_1614 {
    public static int maxDepth(String s) {

        int count=0;
        int maxCount=0;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                count++;
                maxCount= Math.max(maxCount, count);
            }
            else if(ch==')'){
                count--;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String str="(((2+3)*(5(6(4-2)))))";
        System.out.println(maxDepth(str));
    }
}
