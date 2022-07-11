import java.util.*;

class Solution {
    public int reverse(int x) {
        int reverseNum = 0;
        int minNum = Integer.MIN_VALUE;
        int maxNum = Integer.MAX_VALUE;
        boolean isMinus = false;
        String myReverseNum = "";
        
        if(x < 0){
            isMinus = true;
            //x *= -1;
            myReverseNum += "-";
        }
        else if(x == 0){
            myReverseNum = "0";
        }
            
        while(x != 0){
            if(isMinus){
                myReverseNum += (x % 10) * -1;
            }
            else{
                myReverseNum += x % 10;
            }
            x /= 10;
        }
        
        if(isMinus){
            String minNumString = Integer.toString(minNum);
            if(minNumString.length() == myReverseNum.length()){
                if(myReverseNum.compareTo(minNumString) > 0){
                    myReverseNum = "0";
                }
            }
        }
        else{
            String maxNumString = Integer.toString(maxNum);
            if(maxNumString.length() == myReverseNum.length()){
                if(myReverseNum.compareTo(maxNumString) > 0){
                    myReverseNum = "0";
                }
            }
        }
        
        reverseNum = Integer.parseInt(myReverseNum);
        
        return reverseNum;
    }
}
