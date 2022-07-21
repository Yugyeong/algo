import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        Map<String, List<Integer>> resultMap = new HashMap<>();
        
        
        for(int i = 0; i < nums.length-2; i++){
            if(nums[i] > 0){
                break;
            }
            for(int j = i+1; j < nums.length-1; j++){
                if(nums[i] + nums[j] + nums[nums.length-1] < 0){
                    continue;
                }
                
                int front = j + 1;
                int rear = nums.length - 1;
                while(front <= rear){
                    int k = (front + rear) / 2;
                    if(nums[i] + nums[j] + nums[k] == 0){
                        String myKey = "" + nums[i] + nums[j] + nums[k];
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        resultMap.put(myKey, temp);
                        break;
                    }
                    else if(nums[i] + nums[j] + nums[k] > 0){
                        rear = k-1;
                    }
                    else{
                        front = k+1;
                    }
                }
            }
        }
        for(String mapKey: resultMap.keySet()){
            result.add(resultMap.get(mapKey));
        }
        
        return result;
    }
}
