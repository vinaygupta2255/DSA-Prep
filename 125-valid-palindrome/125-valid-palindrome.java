class Solution {
    
  public static boolean isPalindrome(String s) {

		//faltu character hatado
		String temp = "";

		for(int j=0; j<s.length(); j++) {   
			if(valid(s.charAt(j))) {
				temp = temp + s.charAt(j);
			}
		}

		/*
		 * //lowercase me kardo 
		 * for(int j=0; j<temp.length(); j++) {
		 * temp = temp +
		 * toLowerCase(s.charAt(j)); 
		 * }
		 */
		
		temp = temp.toLowerCase();
		//check palindrome
		return checkPalindrome(temp);

	}

	static boolean checkPalindrome(String a) {
		int s = 0;
		int e = a.length()-1;

		while(s<=e) {
			if(a.charAt(s) != a.charAt(e))
			{
				return false;       
			}
			else{
				s++;
				e--;
			}
		}
		return true;
	}


	static boolean valid(char ch) {
		if( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
			return true;
		}

		return false;
	}

	static char toLowerCase(char ch) {
		if( (ch >='a' && ch <='z') || (ch >='0' && ch <='9') )
			return ch;
		else{
			char temp = (char) (ch - 'A' + 'a');
			return temp;
		}
	}    
    
    
}