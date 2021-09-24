// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes  
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0) return true;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dir = 0;
        int x=0, y=0;
        
        for(int i=0; i<instructions.length(); i++){
            char c = instructions.charAt(i);
            
            //G
            if(c == 'G'){
                x += dirs[dir][0];
                y += dirs[dir][1];
            }
            //L
            else if(c == 'L'){
                dir = (dir + 3)% 4;
            }
            //R
            else {
                dir = (dir + 1)% 4;
            }
        }
        
        return (x == 0 && y == 0) || dir != 0;
    }
}