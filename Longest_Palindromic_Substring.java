import java.util.*;

class Solution {
    
    public String longestPalindrome(String s) {
        Queue<Object> myq = new LinkedList<>();
        // List<Integer> longest = null;
        // int longestSize = 0;
        String pelin = "";
        
        //초기값 셋팅
        //1개짜리
        for(int i = 0; i < s.length(); i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(i);
            myq.add(temp);        }
        
        //2개짜리
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(i+1);
                myq.add(temp);
            }
        }
        
        //큐 빌때까지
        List<Integer> result = null;
        while(myq.size() > 0){
            result = (List)myq.poll();

            // if(result.get(1) - result.get(0) > longestSize){
            //     longestSize = result.get(1) - result.get(0);
            //     longest = result;
            // }
            if(result.get(0) - 1 >= 0 && result.get(1) + 1 < s.length()){
                if(s.charAt(result.get(1) + 1) == s.charAt(result.get(0) - 1)) {
                    List<Integer> temp = new ArrayList<>();
                        temp.add(result.get(0) - 1);
                        temp.add(result.get(1) + 1);
                        myq.add(temp);       
                }
            }    
        }

        for(int i = result.get(0); i <= result.get(1); i++){
            pelin += s.charAt(i);
        }
        
        return pelin;
    }
}
