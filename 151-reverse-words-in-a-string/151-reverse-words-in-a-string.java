class Solution {
       
   public static String reverseWords(String input) {
		input = input.trim();//triming all the extra spaces in front or back of the string!
        String str[] = input.split("\\s+");
		Stack<String> s = new Stack<String>();

		for (int i = 0; i<str.length; i++) {
			String ch = str[i];		
		    s.push(ch.trim() + " ");
		}

		String ans = "";
		while(!s.empty()) {
			ans+=s.peek();
			s.pop();
		}
		return ans.trim();
	}
}