/**
 * 539. Minimum Time Difference
 * https://leetcode.com/problems/minimum-time-difference/description/
 */

 /**
  * Solution 1
  * O(nlog(n)) time, O(1) space
  */
class Solution1 {    
    public int getMinutes(String time) {
         String[] splittedTime = time.split(":");
         return Integer.parseInt(splittedTime[0]) * 60 + Integer.parseInt(splittedTime[1]);
        
    }
    public int findMinDifference(List<String> timePoints) { 
        int size = timePoints.size();
        Collections.sort(timePoints);
        // Collections.sort(timesInMinutes, (Integer a, Integer b) -> a - b);
        int minDiff = 24 * 60;
        for (int i = 1; i < timePoints.size(); ++ i)
        {   
            minDiff = Math.min(minDiff, getMinutes(timePoints.get(i)) - getMinutes(timePoints.get(i - 1)));
        }   
        int corner = 24 * 60 - getMinutes(timePoints.get(timePoints.size() - 1)) + getMinutes(timePoints.get(0));
        return Math.min(minDiff, corner);
    }
}  

/*
 * Solution 2
 * O(1) time, O(1) space
 * using boolean array, each element stands for if we see that time point or not.
 */
  class Solution2 {    
    public int findMinDifference(List<String> timePoints) { 
       boolean[] tp = new boolean[1440];
       
       /*
        * by pigeon hole short-circuit, avoid duplicated calculations
        * 1 - timePoints length is more than 24 * 60, return 0
        * 2 - timePoints length is more than (24 * 60 / 2), return 1
        */
        
       if (timePoints.size() > 1440)
           return 0;
        
       for (String s : timePoints)
       {
         int minutes = Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
         if (tp[minutes]) // duplicated
            return 0;
         tp[minutes] = true;
       }
       
       if (timePoints.size() > 1440/2)
           return 1;

       int minDiff = 1440, prev = -1, first = -1;

       for (int i = 0; i < 1440; i ++)
       {
         if (tp[i] && first == -1)
         {
           prev = i;
           first = i;
           continue;
         }
         if (tp[i])
         {
            minDiff = Math.min(i - prev, minDiff); 
            prev = i; 
         }
           
       }
       return Math.min(1440 - prev + first, minDiff);
    }
 }

/*
 * Solution 3
 * O(1) time, O(1) space
 * do Math.min(1440 - prev + first, minDiff) not the end 
 */
class Solution3 {
 public int findMinDifference(List<String> timePoints) {

        boolean[] tp = new boolean[1440];

        for (String s : timePoints) {
            int mins = Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
            if (tp[mins])
                return 0;
            tp[mins] = true;
        }

        int minDiff = Integer.MAX_VALUE,prev = 0;

        for (int i = 1439; i >= 0; i--){
            if(tp[i]){
                prev = i;
                break;
            }
        }

        for (int i = 0; i < 1440; i++) {
            if(tp[i]){
                int diff = i - prev;
                if(diff <0) diff += 1440;
                minDiff = Math.min(minDiff, diff);
                prev = i;
            }
        }

        return minDiff;
    }
}