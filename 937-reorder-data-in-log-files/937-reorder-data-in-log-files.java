class Solution {
    
    // Solution-1 : using customize comparator
    // T.C = O(M*N*logN), S.C = O(M*logN)   
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> myComp = new Comparator<String>(){
           @Override
           public int compare(String log1, String log2){
                
                //spiliting a log in 2 part - identifier & content
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                // case 1 : both are letter logs
                if(!isDigit1 && !isDigit2){
                    //comparing content
                   int cmp = split1[1].compareTo(split2[1]);
                    
                    if(cmp!=0) // contents are same
                        return cmp;
                    // comparing for identifiers now
                    return split1[0].compareTo(split2[0]);
                }
                
            // case 2 : 1 is letter log another is digit log
                if(!isDigit1 && isDigit2){
                     return -1;
               } else  if(isDigit1 && !isDigit2){
                    return 1;
                }
                else{
                    return 0; // both are digit logs
            }
           }
        };
        
           
        Arrays.sort(logs, myComp);
        return logs;
}
}