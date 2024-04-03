class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] occupied = new boolean [board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(exist(board, word, 0, i, j, occupied)) return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int st, int i, int j, boolean [][] occupied) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || occupied[i][j]) return false;
        if(board[i][j] != word.charAt(st)) return false;
        if(st == word.length()-1) return true;
        occupied[i][j] = true;
        boolean exist = exist(board, word, st+1, i-1, j, occupied) || exist(board, word, st+1, i+1, j, occupied)
                || exist(board, word, st+1, i, j+1, occupied) || exist(board, word, st+1, i, j-1, occupied);
        occupied[i][j] = false;
        return exist;
    }
}
