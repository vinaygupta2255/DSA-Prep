class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) 
            return 0;
        if (s.isEmpty() || s.isBlank()) 
            return 1;
        int ans = 0;
        int ptr = 0;
        StringBuffer temp = new StringBuffer("");
        while (ptr < s.length()) {
            String aa = String.valueOf(s.charAt(ptr));
            if (temp.indexOf(aa) > -1) {
                temp = new StringBuffer(temp.substring(temp.indexOf(aa) + 1));
            }
            temp.append(s.charAt(ptr));

            ans = Integer.max(ans, temp.length());
            ptr++;
        }
        return ans;
    }
}
