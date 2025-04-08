## Problem2: Atoi (https://leetcode.com/problems/string-to-integer-atoi/)

//Time Comp[lexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int myAtoi(String s) {
        //this will trim the leading and trailing spaces
        s=s.trim();
        //base condition
        if(s==null || s.length() == 0){
            return 0;
        }
        //we will need to maintain a sign
        char sign = '+';
        if(s.charAt(0) == '-'){
            sign = '-';
        }
        //We are checking x
        if(s.charAt(0)!='+' &&  s.charAt(0)!='-' && !Character.isDigit(s.charAt(0))){
            return 0;
        }
        int num = 0;
        //here as we are told in the question that the output should not go beyond the integer value so we are keeping a limit and making it as /10 and then based on the 
        // coming element we will decide if the number is positive then and coming element is >= '7' or also num > limit we will return the Integer.MAX_VALUE and also same for the 
        // negative value just the coming number should be >= '8'

        int limit = Integer.MAX_VALUE/10;
        for( int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(sign=='+'){
                    if((num > limit) || (num==limit && c >= '7')){
                        return Integer.MAX_VALUE;
                    }
                }
                else{
                    if((num > limit) || (num==limit && c >= '8')){
                        return Integer.MIN_VALUE;
                    }
                }
                num = num*10 + (c-'0');
            }
            else if(i!=0){
                break;
            }
            
        }
        if(sign == '-'){
            return -num;
        }
        return num;
    }
}
