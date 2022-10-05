class Solution {
    
//Solution-1 : by sorting all the strings - 
    //T.C = O(N *K log K), S.C = O(N*K)
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) 
            return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        for(String st : strs){
           char[] chArray= st.toCharArray();
           Arrays.sort(chArray);
           String key = String.valueOf(chArray);
            
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
                      
           map.get(key).add(st); 
        }
        return new ArrayList(map.values());
    }
    
    
//Solution-2 : by using character frequency array of 26, 
    //T.C = O(N*K + N*A), S.C = O(N*K + N*A)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) 
            return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        int[] count = new int[26];
        for(String st : strs){
             Arrays.fill(count, 0);
            
            for(char ch : st.toCharArray())
                count[ch - 'a']++;
            
        
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                  sb.append('#');
                sb.append(count[i]);
            }
                       String key = sb.toString();

            if(!map.containsKey(key))
                map.put(key, new ArrayList());
                      
           map.get(key).add(st); 
        }
        return new ArrayList(map.values());
    }
    
    
}