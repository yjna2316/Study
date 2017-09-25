/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * Next: (E)Intersection of Two Arrays
 */

/* Solution 1: HashMap */ 
import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        // If the one of the size of the arrays is zero, return an empty array.
        if (nums1.length * nums2.length == 0)
        {
            return new int[]{};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums1)
        {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        
        int len = (nums1.length > nums2.length) ? nums1.length : nums2.length;
        ArrayList<Integer> a = new ArrayList<>();
       
        for (int val : nums2)
        {
            if (map.containsKey(val))
            {
                if(map.get(val) > 0)
                {
                    map.put(val, map.get(val) - 1);
                    a.add(val);
                }
            }
        }
        // ArrayList to array
        int[] r = new int[a.size()];
        
        for (int i = 0; i < a.size(); i ++)
        {
            r[i] = a.get(i);
        }
        return r;
    }
        
}

/* Solution2: two pointers */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if (nums1.length * nums2.length == 0)
        {
            return new int[]{};
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        ArrayList<Integer> a = new ArrayList<>();
       
        int i = 0, j = 0;
        while (i < nums1.length  && j < nums2.length){
            if (nums1[i] < nums2[j]) {
               i ++;
            } 
            else if (nums1[i] > nums2[j]) {
                j ++;
            } 
            else {
                a.add(nums1[i]);
                i ++;
                j ++;
            }
        }
        
        int[] result = new int[a.size()];
        
        for (int k = 0; k < a.size(); k ++)
        {
            result[k] = a.get(k);
        }
        
        return result;    
    }
}