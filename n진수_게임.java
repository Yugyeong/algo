import java.util.*;

class Solution {
    String[] numString = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
    
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int totalTime = t * m;
        
        
        ArrayList<String> resultNumList = new ArrayList<>();
        resultNumList.add("0");
        
        int num = 1;
        while(resultNumList.size() < totalTime){
            String nString = numToNString(n, num);
            for(int i = 0; i < nString.length(); i++){
                char cTemp = nString.charAt(i);
                String temp = Character.toString(cTemp);
                resultNumList.add(temp);
            }
            num++;
        }


        for(int i = 0; i < t; i++){
            answer += resultNumList.get(m*i + p - 1);
        }
        
        return answer;
    }
    
    public String numToNString(int n, int num){
        String resultString = "";
        while(num > 0){
            resultString = numString[num % n] + resultString;
            num /= n;
        }
        return resultString;
    }
}
