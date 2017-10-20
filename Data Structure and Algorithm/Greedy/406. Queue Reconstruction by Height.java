/**
 * 406. Queue Reconstruction by Height
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
   
      
       Arrays.sort(people, new Comparator<int[]>() 
       {
         public int compare(int[] a, int[] b)
          {
              return (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0];
          }
       });
    
        List<int[]> res = new ArrayList<>();
        
        for (int[] p : people)
        {
            res.add(p[1], p);  
        }
        
        
        return res.toArray(new int[people.length][]);
        
    }
}