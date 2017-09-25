/**
 * 350. Intersection of Two Arrays 2
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/
 * Next: (E)Intersection of Two Arrays
 */
 
import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 * len2 == 0)
        {
            return new int[]{};
        }   

        int len = (len1 > len2) ? len1 : len2;
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] checked = new boolean[len];

        for (int i = 0; i < len1; i ++)
        {
            for (int j = 0; j < len2; j ++)
            {
                if (!checked[j] && nums1[i] == nums2[j])
                {
                    System.out.println(nums1[i] + " " + nums2[j]);
                    checked[j] = true;
                    result.add(nums1[i]);
                    break;
                }
            }
        }
        
        // arraylist to array
        int[] r = new int[result.size()];
        
        for (int i = 0; i < result.size(); i ++)
        {
            r[i] = result.get(i);
        }
        return r;
    }
}