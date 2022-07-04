import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        //int[] answer = {};
        Map<String, String> parkInMap = new HashMap<String, String>();

        Map<String, String> parkOutMap = new HashMap<String, String>();
        Set<String> carNumSet = new TreeSet<String>();
        Map<String, Integer> parkFee = new HashMap<String, Integer>();
        
        for(int i = 0; i < records.length; i++){
            String recordString = records[i];
            String[] recordSplit = recordString.split(" ");

            if(recordSplit[2].equals("IN")){
                parkInMap.put(recordSplit[1], recordSplit[0]);
                carNumSet.add(recordSplit[1]);
            }
            else{
                String inTime = parkInMap.get(recordSplit[1]);
                String outTime = recordSplit[0];
                String[] inTimeSplit = inTime.split(":");
                String[] outTimeSplit = outTime.split(":");
                int inMinute = getMinute(inTimeSplit[0], inTimeSplit[1]);
                int outMinute = getMinute(outTimeSplit[0], outTimeSplit[1]);
                int totalMinute = outMinute - inMinute;
                // int fee = getFee(fees, outMinute - inMinute);
                if(parkFee.containsKey(recordSplit[1])){
                    parkFee.put(recordSplit[1], totalMinute + parkFee.get(recordSplit[1]));
                }
                else{
                    parkFee.put(recordSplit[1], totalMinute);
                }
                parkInMap.remove(recordSplit[1]);
                
            }
        }
        
        if(parkInMap.keySet() != null){
            for(String num: parkInMap.keySet()){
                String inTime = parkInMap.get(num);
                String outTime = "23:59";
                String[] inTimeSplit = inTime.split(":");
                String[] outTimeSplit = outTime.split(":");
                int inMinute = getMinute(inTimeSplit[0], inTimeSplit[1]);
                int outMinute = getMinute(outTimeSplit[0], outTimeSplit[1]);
                int totalMinute = outMinute - inMinute;
                //int fee = getFee(fees, outMinute - inMinute);
                if(parkFee.containsKey(num)){
                    parkFee.put(num, totalMinute + parkFee.get(num));
                }
                else{
                    parkFee.put(num, totalMinute);
                }
                
            }
        }
                
        int[] answer = new int[parkFee.size()];
        int idx = 0;
        for(String carNum: carNumSet){
            answer[idx++] = getFee(fees, parkFee.get(carNum.toString()));
        }
        
        return answer;
    }
    
    public int getMinute(String h, String m){
        return Integer.parseInt(h) * 60 + Integer.parseInt(m);
    }
    
    public int getFee(int[] fee, int target){
        int defaultMinute = fee[0];
        int defaultFee = fee[1];
        int unitMinute = fee[2];
        int unitFee = fee[3];
        
        int resultFee = 0;
        if(target <= defaultMinute){
            resultFee = defaultFee;
        }
        else{
            resultFee += defaultFee;
            target -= defaultMinute;
            while(target > 0){
                resultFee += unitFee;
                target -= unitMinute;
            }
        }
        
        return resultFee;
    }
}
