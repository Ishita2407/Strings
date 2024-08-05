public class LongestDistinctSubstring{
    // Brute force approach
    // Time complexity - O(N^2)
    // Space complexity - O(N)
    static int solve(String str){
        if(str.length == 0){
            return 0;
        }

        int maxans = Integer.MIN_VALUE;
        for(int i=0; i<str.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<str.length; j++){
                if(Set.contains(str.charAt(j))){
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                set.add(str.charAt(j));
            }
        }
        return maxans;
    }

    // Optimized approach
    // Time complexity - O(2*N)
    // Space complexity - O(N)
    public static int solve(String str){
        if(str.length() == 0) return 0;
        int maxans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for(int r = 0; r < str.length(); r++){
            if(set.contains(Str.charAt(r))){
                while(l < r && set.contains(str.charAt(r))){
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r-l+1);
        }
        return maxans;
    }

    // Optimal approach 2
    /* map - counts elements and maintains frequency of every element as unity by taking the latest index of every element.

      Time complexity - O(N)  Space complexity - O(N)
     */

     public static int solve2(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while(right < n){  // iterate right pointer
            if(map.containsKey(s.charAt(right))) left = Math.max(map.get(s.charAt(right)) + 1, left);
            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);  // update last seen
            right++;
        }
        return len;
     }
    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating 
        characters is " + solve(str));
    }
}