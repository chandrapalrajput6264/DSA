
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;

                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        (board[nr][nc] & 1) == 1) {
                        live++;
                    }
                }

                if (live == 3 || (live == 2 && (board[r][c] & 1) == 1)) {
                    board[r][c] |= 2;
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] >>= 1;
            }
        }
    }
}
