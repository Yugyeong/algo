class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String nNum = changeNumToStringNnum(n, k);
        String[] nNumSplit = nNum.split("0");
        
        for(int i = 0; i < nNumSplit.length; i++){
            if(!nNumSplit[i].equals("")){
                long tempNum = Long.parseLong(nNumSplit[i]);

                if(checkOddNum(tempNum)){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    public String changeNumToStringNnum(int n, int k){
        String result = "";
        
        while(n > 0){          
            result = (n % k) + result; 
            n /= k;
        }
        
        return result;
    }
    
    public boolean checkOddNum(long n){
        if(n == 0 || n == 1){
            return false;
        }
        for(long i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
