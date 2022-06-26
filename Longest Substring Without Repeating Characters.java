import java.util.*;

class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int sLen = 0;
        int sLongestLen = 0;
        Map<Character, Integer> dup = new HashMap<Character, Integer>();        
        
        int startIdx = 0;
        int endIdx = 0;
        
        while(startIdx <= s.length() && endIdx < s.length()){
            char sKey = s.charAt(endIdx);
        
            if(!dup.containsKey(sKey) || dup.get(sKey) == 0){
                dup.put(sKey, 1);
                sLen++;
                endIdx++;
            }
            else{
                if(sLen > sLongestLen){
                    sLongestLen = sLen;
                }
                while(startIdx <= endIdx){
                    char cKey = s.charAt(startIdx);
                    sLen--;
                    dup.put(cKey, dup.get(cKey) - 1);
                    startIdx++;
                    if(cKey == sKey){
                        break;
                    }
                }
            }
        }
        if(sLen > sLongestLen){
            sLongestLen = sLen;
        }
        
        return sLongestLen;
        
    }
}
