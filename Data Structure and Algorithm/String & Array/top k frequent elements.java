/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * (M)Word Frequency (M)Kth Largest Element in an Array (M)Sort Characters By Frequency (M)Split Array into Consecutive Subsequences 
 */

// use treeMap. Use frequency as the key to get all frequencies in order
class Solution  {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> m = new HashMap<>(); // (number, frequency)
       
        for (int num : nums)
        {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>(); 
       
        // sort map by values 
        for (int key : m.keySet())
        {
            int freq = m.get(key);
            if (!tm.containsKey(freq))
                tm.put(freq, new ArrayList<>());
            tm.get(freq).add(key); // 왜 다시 map 에 put 안하지 
        }
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < k)
        {
            Map.Entry<Integer,List<Integer>> entry = tm.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}

// use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
       
         //count the frequency for each element
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                             public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                                 return b.getValue().compareTo(a.getValue());
                             }
                         });
            
            
            
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        
        // add number to the list in the highest frequency order
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
