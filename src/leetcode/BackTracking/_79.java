package leetcode.BackTracking;

public
class _79
{
    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

    boolean r(char[][] board,
              String word,
              int nextCharIdx,
              boolean[][] seen,
              int y,
              int x)
    {
        // if we have used this char
        if (seen[y][x])
            return false;

        // if char is not what we are looking for
        if (board[y][x] != word.charAt(nextCharIdx))
            return false;

        nextCharIdx++;
        seen[y][x] = true;

        if (nextCharIdx >= word.length())
            return true;

        for (int i = 0; i < dirs.length; i++) {
            int[] dir = dirs[i];
            int newY = clamp(y + dir[0], 0, board.length - 1);
            int newX = clamp(x + dir[1], 0, board[0].length - 1);

            if (r(board, word, nextCharIdx, seen, newY, newX))
                return true;
        }

        nextCharIdx--;
        seen[y][x] = false;

        return false;
    }

    int clamp(int val, int min, int max) {
        return Math.min(Math.max(val, min), max);
    }

  public
    boolean exist(char[][] board, String word)
    {
        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (r(board, word, 0, seen, i, j))
                        return true;
                }
            }
        }

        return false;
    }
}
