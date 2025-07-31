// Using DFS with backtracking for checking if word exists in given board
// TC: O(mxn)
// SC: O(n) - where n the length of the word - as the recursive stack length at max would be the length of the word 

class Solution {
    int m;
    int n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean value = recursive(board, word, i, j,0);
                if(value){
                    return true;
                }
            }
        } 
        return false;

    }

    public boolean recursive(char[][] board, String word, int r, int c, int index){
        // Base
        // [["a"]], word = "a"
        if(word.charAt(index) == board[r][c] && word.length() == index+1){
            return true;
        }

        if(index == word.length()){
            return true;
        }
        if(index > word.length()){
            return false;
        }

        if(word.charAt(index) != board[r][c]){
            return false;
        }

        // Logic
        char temp = board[r][c];
        board[r][c] = '#';
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n){
                if(recursive(board, word, nr, nc, index + 1)){
                    board[r][c] = temp;
                    return true;
                }
            }
        }
        board[r][c] = temp;
        return false;
    }
}
