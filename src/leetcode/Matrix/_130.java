package leetcode.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public
class _130
{

    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

    void bfs(char[][] board, Queue<int[]> q, boolean[][] seen)
    {
        if (q.isEmpty())
            return;

        int[] curr = q.poll();
        int r = curr[0];
        int c = curr[1];

        seen[r][c] = true;
        board[r][c] = 'Y';

        for (int i = 0; i < dirs.length; i++) {
            int[] dir = dirs[i];

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= board.length)
                continue;

            if (nc < 0 || nc >= board[0].length)
                continue;

            if (seen[nr][nc])
                continue;

            if (board[nr][nc] == 'Y')
                continue;

            if (board[nr][nc] == 'X')
                continue;

            q.add(new int[]{ nr, nc });
        }

        bfs(board, q, seen);
    }

  public
    void solve(char[][] board)
    {
        boolean[][] seen = new boolean[board.length][board[0].length];
        Queue<int[]> q = new LinkedList<>();

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O') {
                q.add(new int[]{ 0, c });
            }
            if (board[board.length - 1][c] == 'O') {
                q.add(new int[]{ board.length - 1, c });
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O') {
                q.add(new int[]{ r, 0 });
            }

            if (board[r][board[0].length - 1] == 'O') {
                q.add(new int[]{ r, board[0].length - 1 });
            }
        }

        bfs(board, q, seen);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';

                if (board[r][c] == 'Y')
                    board[r][c] = 'O';
            }
        }
    }
}
