package com.github.leetcode.wordsearch79;

public class WordSearch {

    private final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] used = new boolean[m][n];
        char[] words = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(m, n, i, j, 0, board, words, used)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int m, int n, int i, int j, int begin, char[][] board, char[] words, boolean[][] used) {
        if (begin == words.length - 1) {
            return board[i][j] == words[begin];
        }

        if (board[i][j] == words[begin]) {
            used[i][j] = true;

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];

                if (!withinBoundary(m, n, x, y) || used[x][y]) {
                    continue;
                }

                if (backtrack(m, n, x, y, begin + 1, board, words, used)) {
                    return true;
                }
            }

            used[i][j] = false;
        }

        return false;
    }

    public boolean withinBoundary(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
