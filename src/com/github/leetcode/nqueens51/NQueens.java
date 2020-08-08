package com.github.leetcode.nqueens51;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solveNQueens(n, 0, 0, 0, 0, new ArrayDeque<>(), res);

        return res;
    }

    public void solveNQueens(int n, int row, int column, int slash, int backslash, Deque<String> ans, List<List<String>> res) {
        if (row == n) {
            res.add(new ArrayList<>(ans));
        }

        int bits = (~(column | slash | backslash)) & ((1 << n) - 1);

        while (bits > 0) {
            // Place queen to the rightmost side where bit is 1.
            int position = bits & -bits;

            ans.add(placeQueen(n, position));

            solveNQueens(n, row + 1, column | position, (slash | position) << 1, (backslash | position) >> 1, ans, res);

            // Restore queen to `.` by removing rightmost bit 1.
            bits = bits & (bits - 1);
            ans.removeLast();
        }
    }

    public String placeQueen(int n, int position) {
        StringBuilder stringBuilder = new StringBuilder();
        int q = (int) (Math.log(position) / Math.log(2));

        for (int i = 0; i < q; i++) {
            stringBuilder.append(".");
        }

        stringBuilder.append("Q");

        for (int j = q + 1; j < n; j++) {
            stringBuilder.append(".");
        }

        return stringBuilder.toString();
    }
}
