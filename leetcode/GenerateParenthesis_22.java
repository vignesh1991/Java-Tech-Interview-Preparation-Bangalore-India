// 22. Generate Parentheses

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
//        closing should not be before opening.
        //we will use back tracking  to understand it better.
        List<String> outputArr = new ArrayList();
        backtrack(outputArr,"",0,0, n);
        return outputArr;
    }
    
    private final void backtrack(List<String> outputArr, String currentString, int open, int close, int max){
         // some base case, where we add some kind of data, in this case its string. 
        if(currentString.length() == max * 2) {
            outputArr.add(currentString);
            return;
        }
        
        if(open < max) backtrack(outputArr, currentString + "(", open + 1, close, max);
        if(close < open) backtrack(outputArr, currentString + ")", open , close+1, max);
            
    }
}