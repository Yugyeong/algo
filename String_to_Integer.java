class Solution {
    public int myAtoi(String s) {
        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        String minIntString = Integer.toString(Integer.MIN_VALUE);
        String maxIntString = Integer.toString(Integer.MAX_VALUE);
        boolean isMinus = false;
        boolean isLeadingWhite = true;
        boolean isLeadingZero = true;
        String myNumString = "";
        
        //s = s.replace(" ", "");
        for(int i = 0; i < s.length(); i++){
            //처음에 부호 나오면 계속
            if(isLeadingWhite && s.charAt(i) == '-'){
                isMinus = true;
                isLeadingWhite = false;
                myNumString += "" + '-';
                continue;
            }
            if(isLeadingWhite && s.charAt(i) == '+'){
                isMinus = false;
                isLeadingWhite = false;
                continue;
            }
            
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                isLeadingWhite = false;
                if(s.charAt(i) == '0' && isLeadingZero){
                }
                else{
                    isLeadingZero = false;
                    myNumString += ("" + s.charAt(i));
                }
                
            }
            else{
                if(s.charAt(i) == ' ' && isLeadingWhite){
                    continue;
                }
                else{
                    break;
                }
            }
            
        }
        
        if(myNumString.equals("") || myNumString.equals("-")){
            return 0;
        }
        else{
            if(isMinus){
                if(myNumString.length() > minIntString.length()){
                    return minInt;
                }
                else if(myNumString.length() == minIntString.length()){
                    if(myNumString.compareTo(minIntString) >= 0){
                        return minInt;
                    }
                    else{
                        return Integer.parseInt(myNumString);
                    }
                }
                else{
                    return Integer.parseInt(myNumString);
                }
            }
            else{
                if(myNumString.length() > maxIntString.length()){
                    return maxInt;
                }
                else if(myNumString.length() == maxIntString.length()){
                    if(myNumString.compareTo(maxIntString) > 0){
                        return maxInt;
                    }
                    else{
                        return Integer.parseInt(myNumString);
                    }
                }
                else{
                    return Integer.parseInt(myNumString);
                }
            }
        }
        //return 0;
    }
}
