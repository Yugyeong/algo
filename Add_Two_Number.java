import java.util.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> l1List = new ArrayList<>();
        List<Integer> l2List = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        
        ListNode listNode1 = l1;
        while(listNode1 != null){
            l1List.add(listNode1.val);
            listNode1 = listNode1.next;
        }
        
        ListNode listNode2 = l2;
        while(listNode2 != null){
            l2List.add(listNode2.val);
            listNode2 = listNode2.next;
        }
        

        int l1Idx = 0;
        int l2Idx = 0;
        int numOne = 0;
        int numTen = 0;
        while(l1Idx < l1List.size() || l2Idx < l2List.size()){
            numOne = numTen;
            if(l1Idx < l1List.size()){
                numOne += l1List.get(l1Idx);
            }
            if(l2Idx < l2List.size()){
                numOne += l2List.get(l2Idx);
            }
            
            if(numOne >= 10){
                numOne -= 10;
                numTen = 1;
            }
            else{
                numTen = 0;    
            }
            l1Idx++;
            l2Idx++;
            
            System.out.println("numOne: " + numOne);
            System.out.println("numTen: " + numTen);
            
            resultList.add(numOne);
        }
        if(numTen > 0){
            resultList.add(numTen);
        }
        
        
        ListNode preNode = new ListNode(resultList.get(resultList.size()-1));
        ListNode curNode = preNode;
        ListNode result = null;
        int resultIdx = resultList.size() - 2;
        while(resultIdx >= 0){
            curNode = new ListNode(resultList.get(resultIdx), preNode);
            preNode = curNode;
            resultIdx--;
        }
        
        result = curNode;
        
        return result;
    }
}
