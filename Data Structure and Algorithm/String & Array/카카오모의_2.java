class Solution {
    public boolean solution(int[] arr) {
        
      // nums[i] := arr[i]를 인덱스로 하는 배열. 1부터 n까지의 숫자 갯수를 값으로 한다.
      int[] nums = new int[arr.length + 1]; 
        
      // 배열 조회하면서 
      // 1부터 n까지 숫자 갯수 카운트
      for (int i = 0; i < arr.length; i ++)
      {
          // 배열 길이 n보다 큰 배열값이 나오거나
          // 동일한 숫자가 두번 이상 나타나면 (중복)
          // false 반환
          if (arr[i] <= arr.length && nums[arr[i]] == 0)
              nums[arr[i]] ++;
          else
              return false;
      }
        
      // 배열 조회하면서 
      // 안 나온 숫자가 있다면 (갯수가 0)
      // false 반환
      for (int i = 0; i < arr.length; i ++)
      {
          if (nums[arr[i]] == 0)
              return false;
      }
        
      return true;
    }
}