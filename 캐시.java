import java.util.*;
class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();
            
            boolean flag = false;
            for(int k = 0; k < cache.size(); k++){
                if(cache.get(k).equals(city)){
                    cache.remove(k);
                    cache.add(city);
                    answer += 1;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer += 5;
                cache.add(city);
                if(cache.size() > cacheSize){
                    cache.remove(0);
                }
            }
        }
        
        
        return answer;
    }
}
