/**
 * 412. FizzBuzz
 * https://leetcode.com/problems/fizz-buzz/description/
 * Next: (E)Logger Rate Limiter (M)Combination Sum2
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i ++)
        {
            if (i % 3 == 0 && i % 5 == 0) {
                
                list.add("FizzBuzz");
                
            } else if (i % 3 == 0) {
                
                list.add("Fizz");
                
            } else if (i % 5 == 0) {
                
                list.add("Buzz");
            
            } else {
                
                list.add("" + i);
            }      
        }        
        return list;
    }
}