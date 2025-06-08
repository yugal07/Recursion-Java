// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

public class WordSearch {
    public static boolean exists(char [][] board , String string){
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(search(board, string, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean search(char [][] board , String string , int i , int j , int index){
        if(index == string.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length ||  j >= board[0].length || board[i][j] != string.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = search(board, string, i + 1, j, index + 1) || 
                        search(board, string, i - 1, j, index + 1) ||
                        search(board, string, i, j + 1, index + 1) ||
                        search(board, string, i, j - 1, index + 1);


        board[i][j] = temp;
        return found;
    }
}
