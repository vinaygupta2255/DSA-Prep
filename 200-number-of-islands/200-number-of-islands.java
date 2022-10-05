class Solution {
    //solution-1 using DFS traversal, same from Nick White video
    // T.C = O(m*n) S.C = O(m*n)
    //https://www.youtube.com/watch?v=U6-X_QOwPcs&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i =0;i<grid.length; i++){
             for(int j =0;j<grid[i].length; j++){
            if(grid[i][j] == '1'){
                count++;
                callDFS(grid, i, j);
             }  
           }
        }
        return count;
    }
    
    void callDFS(char[][] grid, int i, int j){
        //boundary check base case
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        callDFS(grid, i+1, j); // Up
        callDFS(grid, i-1, j); // Down
        callDFS(grid, i, j+1); // Left
        callDFS(grid, i, j-1); // Right
    }
 
    //solution-2 using BFS traversal
    // Please check the Solution section
    
}