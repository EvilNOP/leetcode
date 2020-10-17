package com.github.leetcode.nqueens52;

import java.util.Arrays;

public class NQueens52 {

    int total = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solveNQueens(0, n, board);

        return total;
    }

    public void solveNQueens(int row, int n, char[][] board) {
        if (row == n) {
            ++total;
        }

        for (int column = 0; column < n; column++) {
            if (isConflict(row, column, n, board)) {
                continue;
            }

            board[row][column] = 'Q';
            solveNQueens(row + 1, n, board);
            board[row][column] = '.';
        }
    }

    public boolean isConflict(int row, int column, int n, char[][] board) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column] == 'Q') {
                return true;
            }
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return true;
            }
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return true;
            }
        }

        return false;
    }
}
