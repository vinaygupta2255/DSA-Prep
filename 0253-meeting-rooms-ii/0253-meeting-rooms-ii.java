import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
    // Remember the trick of this solution
    // solve this using Min Heap also i.e. priority Queue
    
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        
        int roomsCount = 0;
        int endItr = 0;
        for(int i = 0;i<intervals.length;i++){
            
            if(start[i] < end[endItr]){
                roomsCount ++;
            }else{
                endItr++;
            }
            
        }
        
        return roomsCount;
    
    }
}