class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder ans = new StringBuilder(); 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Agar closing bracket hai toh pehle count decrease karo
            if (c == ')') {
                count--;
            }
            
            // Agar count 0 nahi hai, iska matlab yeh outermost bracket nahi hai, isko answer mein daal do
            if (count != 0) {
                ans.append(c);
            }
            
            // Agar opening bracket hai toh count increase karo
            if (c == '(') {
                count++;
            }
        }
        
        return ans.toString();
    }
}
