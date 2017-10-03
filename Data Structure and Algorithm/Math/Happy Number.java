/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/description/
 * (E)Add Digits(E)Ugly Number
 */

class Solution {    
    public boolean isHappy(int n) {  
        HashSet set = new HashSet();
        while(set.add(n)) {
            int sum = 0;
            while (n != 0)
            {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) 
                return true;
            n = sum;  
        }
        return false;
    }
}