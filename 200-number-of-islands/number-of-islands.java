class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] != '1') {
                    continue;
                }

                islands++;

                // Iterative DFS using the grid itself as visited marker
                grid[r][c] = '0';

                int[] stack = new int[m * n];
                int top = 0;
                stack[top++] = r * n + c;

                while (top > 0) {
                    int cell = stack[--top];
                    int row = cell / n;
                    int col = cell % n;

                    if (row > 0 && grid[row - 1][col] == '1') {
                        grid[row - 1][col] = '0';
                        stack[top++] = (row - 1) * n + col;
                    }

                    if (row + 1 < m && grid[row + 1][col] == '1') {
                        grid[row + 1][col] = '0';
                        stack[top++] = (row + 1) * n + col;
                    }

                    if (col > 0 && grid[row][col - 1] == '1') {
                        grid[row][col - 1] = '0';
                        stack[top++] = row * n + col - 1;
                    }

                    if (col + 1 < n && grid[row][col + 1] == '1') {
                        grid[row][col + 1] = '0';
                        stack[top++] = row * n + col + 1;
                    }
                }
            }
        }

        return islands;
    }
}